package io.github.thang86.weather.ui.activity.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.thang86.weather.R
import io.github.thang86.weather.domain.model.Location
import io.github.thang86.weather.domain.model2.Resource
import kotlinx.android.synthetic.main.item_search_result.view.*


/**
 * ThangTX2
 */
class SearchLocationAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Resource>() {

        override fun areItemsTheSame(oldItem: Resource, newItem: Resource): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Resource, newItem: Resource): Boolean {
            return oldItem.name!! == oldItem.name
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return SearchLocationHoder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search_result,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchLocationHoder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Resource>) {
        differ.submitList(list)
    }

    class SearchLocationHoder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Resource) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            textViewCityName.text = item.name;
        }

    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Resource)
    }
}

