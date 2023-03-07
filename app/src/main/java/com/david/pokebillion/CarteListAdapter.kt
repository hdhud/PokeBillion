package com.david.pokebillion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarteListAdapter(private val context: Context, private val cartes: List<Carte>) : BaseAdapter() {

    override fun getCount(): Int {
        return cartes.size
    }

    override fun getItem(position: Int): Any {
        return cartes[position]
    }

    override fun getItemId(position: Int): Long {
        return cartes[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.carte_list, parent, false)
        val carte = cartes[position]


        view.findViewById<TextView>(R.id.nom_carte).text = carte.nom
        view.findViewById<TextView>(R.id.rarete_carte).text = carte.Rarete.toString()
        view.findViewById<TextView>(R.id.nb_carte).text = carte.nb_carte.toString()

        return view
    }
}

