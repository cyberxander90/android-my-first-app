package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Inés Saint Martin
 */
class ListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Get the ViewModel.
        viewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        // Create the observer which updates the UI.
        val modelObserver = Observer<ArrayList<Item>> { itemsList ->
            // Update the UI, in this case, a RecyclerView.
            viewManager = LinearLayoutManager(this)
            viewAdapter = FirstAdapter(itemsList)

            recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = viewManager

                // specify an viewAdapter
                adapter = viewAdapter
            }
        }

        viewModel.itemLiveData.observe(this, modelObserver)
    }
}