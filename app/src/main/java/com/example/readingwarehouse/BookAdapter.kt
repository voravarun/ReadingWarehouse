package com.example.readingwarehouse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//class BookAdapter : ListAdapter<Book, BookAdapter.BookViewHolder>(BookDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
//        return BookViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
//        val book = getItem(position)
//        holder.bind(book)
//    }
//
//    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val img: ImageView = itemView.findViewById(R.id.imageView)
//        private val author: TextView = itemView.findViewById(R.id.Author)
//        private val BookName: TextView = itemView.findViewById(R.id.BookName)
//        private val volume: TextView = itemView.findViewById(R.id.Volume)
//        private val price: TextView = itemView.findViewById(R.id.BookPrice)
//        private val compareButton: Button = itemView.findViewById(R.id.compareButton)
//
//        fun bind(book: Book) {
//            author.text = book.author
//            BookName.text = book.name
//            volume.text = "Vol: "+book.volume.toString()
//            price.text = "Price: "+book.price.toString()+" ฿"
//        }
//    }
//
//    class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
//        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
//            return oldItem == newItem
//        }
//    }
//}


class BookAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img: ImageView = itemView.findViewById(R.id.imageView)
        private val author: TextView = itemView.findViewById(R.id.Author)
        private val BookName: TextView = itemView.findViewById(R.id.BookName)
        private val volume: TextView = itemView.findViewById(R.id.Volume)
        private val price: TextView = itemView.findViewById(R.id.BookPrice)
        private val compareButton: Button = itemView.findViewById(R.id.compareButton)

        fun bind(book: Book) {
            //set book image
            author.text = book.author
            BookName.text = book.name
            volume.text = "Vol: "+book.volume.toString()
            price.text = "Price: "+book.price.toString()+" ฿"
            compareButton.setOnClickListener {
                // Handle button click event here
            }
        }
    }
}