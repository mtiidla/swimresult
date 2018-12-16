package ee.mtiidla.swimresult.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.recyclerview.widget.HackRecyclerView
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView which improves touch handling for nested scrolling children.
 */
class ScrollingChildrenRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : HackRecyclerView(context, attrs, defStyle) {



    private var mScrollPointerId = INVALID_POINTER
    private var mLastTouchX: Int = 0
    private var mLastTouchY: Int = 0
    private var mTouchSlop: Int = 0

    init {
        mTouchSlop = ViewConfiguration.get(context).scaledTouchSlop
    }

    override fun setScrollingTouchSlop(slopConstant: Int) {
        super.setScrollingTouchSlop(slopConstant)

        val viewConfiguration = ViewConfiguration.get(context)

        when (slopConstant) {
            RecyclerView.TOUCH_SLOP_DEFAULT -> mTouchSlop = viewConfiguration.scaledTouchSlop
            RecyclerView.TOUCH_SLOP_PAGING -> mTouchSlop = viewConfiguration.scaledPagingTouchSlop
        }
    }

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        val action = e.actionMasked
        val actionIndex = e.actionIndex

        val layoutManager = layoutManager ?: return false

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                mScrollPointerId = e.getPointerId(0)
                mLastTouchX = (e.x + 0.5f).toInt()
                mLastTouchY = (e.y + 0.5f).toInt()

                // Standard RecyclerView will set the state to SCROLL_STATE_DRAGGING
                // immediately on down, if the current state is SCROLL_STATE_SETTLING.
                // We want to avoid that in order to be able to immediately scroll nested scrolling
                // children.
                if (scrollState == RecyclerView.SCROLL_STATE_SETTLING) {
                    super.onInterceptTouchEvent(e)
                    scrollState = RecyclerView.SCROLL_STATE_IDLE
                    return false
                }
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                mScrollPointerId = e.getPointerId(actionIndex)
                mLastTouchX = (e.getX(actionIndex) + 0.5f).toInt()
                mLastTouchY = (e.getY(actionIndex) + 0.5f).toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                val index = e.findPointerIndex(mScrollPointerId)
                if (index < 0) {
                    // Pointer index for pointer id not found.
                    return false
                }

                // Only intercept the scroll event if the user is mainly dragging in the direction
                // which the LayoutManager can scroll.
                if (scrollState != RecyclerView.SCROLL_STATE_DRAGGING) {
                    val x = (e.getX(index) + 0.5f).toInt()
                    val y = (e.getY(index) + 0.5f).toInt()
                    val dx = mLastTouchX - x
                    val dy = mLastTouchY - y

                    if (layoutManager.canScrollVertically() && Math.abs(dx) > mTouchSlop &&
                        Math.abs(dx) > Math.abs(dy)
                    ) {
                        return super.onInterceptTouchEvent(e)
                    }

                    if (layoutManager.canScrollHorizontally() && Math.abs(dy) > mTouchSlop &&
                        Math.abs(dy) > Math.abs(dx)
                    ) {
                        return super.onInterceptTouchEvent(e)
                    }

                    super.onInterceptTouchEvent(e)
                    return false
                }
            }
        }

        return super.onInterceptTouchEvent(e)
    }

    companion object {

        private const val INVALID_POINTER = -1
    }
}
