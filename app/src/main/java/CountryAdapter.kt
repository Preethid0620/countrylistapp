package com.example.countrylistapp // Replace with your package name

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private var countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false) // We'll create this layout next
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countries[position]
        holder.bind(currentCountry)
    }

    override fun getItemCount() = countries.size

    fun updateData(newCountries: List<Country>) {
        countries = newCountries
        notifyDataSetChanged() // Consider using DiffUtil for better performance
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameRegionTextView: TextView = itemView.findViewById(R.id.textViewNameRegion)
        private val codeTextView: TextView = itemView.findViewById(R.id.textViewCode)
        private val capitalTextView: TextView = itemView.findViewById(R.id.textViewCapital)

        fun bind(country: Country) {
            nameRegionTextView.text = "${country.name}, ${country.region}"
            codeTextView.text = country.code
            capitalTextView.text = country.capital
        }
    }
}