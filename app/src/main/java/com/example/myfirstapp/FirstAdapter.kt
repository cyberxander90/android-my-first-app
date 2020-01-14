package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Inés Saint Martin
 */
class FirstAdapter(private val myDataset: Array<String>) :
        RecyclerView.Adapter<FirstAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.element_title)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup,
                                    viewType: Int): MyViewHolder {

        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_list_element, viewGroup, false)
        return MyViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}