package com.google.android.material.tabs

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING
import ee.mtiidla.swimresult.util.notNull
import java.lang.ref.WeakReference

/**
 * Inspired from [TabLayout.TabLayoutOnPageChangeListener]
 */
class RecyclerViewTabListener(tabLayout: TabLayout) : RecyclerView.OnScrollListener() {

    private val tabLayout = WeakReference<TabLayout>(tabLayout)

    private var previousScrollState: Int = SCROLL_STATE_IDLE
    private var scrollState: Int = SCROLL_STATE_IDLE

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        previousScrollState = scrollState
        scrollState = newState

        tabLayout.get().notNull {
            if (scrollState == SCROLL_STATE_IDLE) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val position = layoutManager.findFirstVisibleItemPosition()
                if (it.selectedTabPosition != position && position < it.tabCount) {
                    it.selectTab(it.getTabAt(position), true)
                }
            }
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        tabLayout.get().notNull { tabView ->
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val position = layoutManager.findFirstVisibleItemPosition()
            val view = layoutManager.findViewByPosition(position)

            view.notNull { childView ->
                val offset = 1 - childView.right / childView.width.toFloat()
                val updateText = scrollState != SCROLL_STATE_SETTLING
                    || previousScrollState == SCROLL_STATE_DRAGGING
                val updateIndicator = !(scrollState == SCROLL_STATE_SETTLING
                    && previousScrollState == SCROLL_STATE_IDLE)
                tabView.setScrollPosition(position, offset, updateIndicator, updateText)
            }

        }
    }
}