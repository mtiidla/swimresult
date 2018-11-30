package ee.mtiidla.swimresult.util

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.RecyclerViewTabListener
import com.google.android.material.tabs.TabLayout

fun RecyclerView.Adapter<*>.setStableIds() {
    try {
        if (getItemId(0) == RecyclerView.NO_ID) {
            throw UnsupportedOperationException("Requesting stable ids, but getItemId is not implemented for adapter $this")
        }
    } catch (exception: IndexOutOfBoundsException) {
        // ignore, getItemId most likely implemented
    }
    this.setHasStableIds(true)
}

/**
 * Keeps the selection of the underlying RecyclerView and TabLayout in sync.
 *
 * Clients are responsible for populating the tabLayout with matching size and
 * dataset to the RecyclerView. This implementation supports only RecyclerView items that fill the
 * entire RecyclerView width and Horizontal LayoutManager
 */
fun TabLayout.setupWithRecyclerView(recyclerView: RecyclerView) {
    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab) {
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
        }

        override fun onTabSelected(tab: TabLayout.Tab) {
            recyclerView.smoothScrollToPosition(tab.position)
        }
    })
    recyclerView.addOnScrollListener(RecyclerViewTabListener(this))
}