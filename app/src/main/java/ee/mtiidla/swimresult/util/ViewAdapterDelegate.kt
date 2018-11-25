package ee.mtiidla.swimresult.util

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

typealias ViewHolderAdapterDelegate<I, T, VH> = AbsListItemAdapterDelegate<I, T, VH>

abstract class ViewAdapterDelegate<I : T, T : Any, V : View>(
    private val itemClickListener: ((I) -> Unit)? = null
) : ViewHolderAdapterDelegate<I, T, ViewAdapterDelegate<I, T, V>.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = ViewHolder(createView(parent))

    override fun onBindViewHolder(item: I, holder: ViewHolder, payloads: MutableList<Any>) {
        @Suppress("UNCHECKED_CAST") // We provide the views to ViewHolder, so we can later safely use them as V
        bindItem(item, holder.itemView as V, payloads)
        holder.item = item
    }

    abstract fun createView(parent: ViewGroup): V

    abstract fun bindItem(item: I, view: V, payloads: List<Any>)

    inner class ViewHolder(itemView: V) : RecyclerView.ViewHolder(itemView) {

        internal var item: I? = null

        init {
            itemClickListener.notNull { listener ->
                itemView.setOnClickListener {
                    item.notNull {
                        listener.invoke(it)
                    }
                }
            }
        }
    }
}