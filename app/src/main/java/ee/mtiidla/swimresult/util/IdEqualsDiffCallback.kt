package ee.mtiidla.swimresult.util

import androidx.recyclerview.widget.DiffUtil

class IdEqualsDiffCallback<T : Any>(
    private val idComparison: (T) -> Long
) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem::class == newItem::class
            && idComparison.invoke(oldItem) == idComparison.invoke(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
}