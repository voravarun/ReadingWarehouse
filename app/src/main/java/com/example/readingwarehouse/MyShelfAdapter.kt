package com.example.readingwarehouse


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.readingwarehouse.Entites.MyShelf

class MyShelfAdapter(private var dataList: List<MyShelf>) : RecyclerView.Adapter<MyShelfAdapter.ViewHolder>() {

    fun setData(data: List<MyShelf>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.myshelfbitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookNameTextView: TextView = itemView.findViewById(R.id.book_name)
        private val bookAuthorTextView: TextView = itemView.findViewById(R.id.book_author)
        private val bookVolumeTextView: TextView = itemView.findViewById(R.id.book_volume)
        private val bookBarcodeTextView: TextView = itemView.findViewById(R.id.book_barcode) // Updated ID

        fun bind(item: MyShelf) {
            bookNameTextView.text = item.Title
            bookAuthorTextView.text = item.Author
            bookVolumeTextView.text = item.VolumeNo.toString()
            bookBarcodeTextView.text = item.barcode.toString()
        }
    }
}
