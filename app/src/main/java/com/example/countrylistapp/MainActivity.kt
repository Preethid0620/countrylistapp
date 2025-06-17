
package com.example.countrylistapp
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CountryViewModel
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewCountries)
        progressBar = findViewById(R.id.progressBar)
        errorTextView = findViewById(R.id.textViewError)

        // Initialize Repository and ViewModelFactory
        val apiService = RetrofitInstance.api
        val repository = CountryRepository(apiService)
        val viewModelFactory = CountryViewModelFactory(repository)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this, viewModelFactory)[CountryViewModel::class.java]

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        countryAdapter = CountryAdapter(emptyList())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = countryAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this) { countries ->
            countries?.let {
                recyclerView.visibility = View.VISIBLE
                errorTextView.visibility = View.GONE
                countryAdapter.updateData(it)
            }
            progressBar.visibility = View.GONE
        }

        viewModel.error.observe(this) { errorMessage ->
            errorMessage?.let {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.GONE
                errorTextView.visibility = View.VISIBLE
                errorTextView.text = it
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }

        // Show progress bar initially
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        errorTextView.visibility = View.GONE
    }
}
