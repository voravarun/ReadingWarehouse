package com.example.readingwarehouse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.readingwarehouse.Entites.BookToBuy

class TobuyAdapter(private var dataList: List<BookToBuy>): RecyclerView.Adapter<TobuyAdapter.ViewHolderClass>() {

    var onItemClick: ((BookToBuy) -> Unit)? = null

    fun setData(data: List<BookToBuy>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.tobuybitem, parent, false)

        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
//        holder.BImage
//        holder.BName.text = currentItem.bName
//        holder.BAuthor.text = currentItem.bAuthor
//        holder.BVol.text = currentItem.bVol.toString()
//        holder.BPrice.text = currentItem.bPrice.toString()
//        holder.itemView.setOnClickListener{
//            onItemClick?.invoke(currentItem)
//        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val BName:TextView = itemView.findViewById(R.id.book_name)
//        val BImage:ImageView = itemView.findViewById(R.id.book_image)
        val BAuthor:TextView = itemView.findViewById(R.id.book_author)
        val BVol:TextView = itemView.findViewById(R.id.book_vol)
        val BPrice:TextView = itemView.findViewById(R.id.book_price)

        fun bind(item: BookToBuy) {
            BName.text = item.bName
//            BImage
            BAuthor.text = item.bAuthor
            BVol.text = item.bVol.toString()
            BPrice.text = item.bPrice.toString()
        }
    }

}