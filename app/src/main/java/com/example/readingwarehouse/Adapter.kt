//package com.example.readingwarehouse
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class Adapter ( private val dataList: ArrayList<IncomeData>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
//    //    (private val dataList: ArrayList<IncomeData>): RecyclerView.Adapter<Adapter.ViewHolderClass>() {
//    // create new views
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // inflates the card_view_design view
//        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.myshelfbitem, parent, false)
//
//        return ViewHolder(view)
//    }
//
//
//    // binds the list items to a view
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        val ItemsViewModel = dataList[position]
//
////        // sets the image to the imageview from our itemHolder class
////        holder.imageView.setImageResource(ItemsViewModel.image)
////
////        // sets the text to the textview from our itemHolder class
////        holder.textView.text = ItemsViewModel.text
//
//    }
//
//    // return the number of the items in the list
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    // Holds the views for adding it to image and text
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.book_image)
//        val textView: TextView = itemView.findViewById(R.id.book_name)
//    }
//}