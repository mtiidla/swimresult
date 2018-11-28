package ee.mtiidla.swimresult.util

import androidx.recyclerview.widget.RecyclerView

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