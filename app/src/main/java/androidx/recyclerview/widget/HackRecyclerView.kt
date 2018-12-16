package androidx.recyclerview.widget

import android.content.Context
import android.util.AttributeSet

/**
 * RecyclerView used to make setScrollState protected. Please never use this.
 */
open class HackRecyclerView : RecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun setScrollState(state: Int) {
        super.setScrollState(state)
    }
}
