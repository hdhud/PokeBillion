package com.david.pokebillion.ui.Clique

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.david.pokebillion.Carte
import com.david.pokebillion.databinding.FragmentCliqueBinding
import java.io.*


class CliqueFragment : Fragment() {

    private var _binding: FragmentCliqueBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private var carteList: List<Carte> = ArrayList()
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        var click =0
        val homeViewModel =
                ViewModelProvider(this).get(CliqueViewModel::class.java)

        _binding = FragmentCliqueBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = click.toString()
        }

        //carteList = Carte.getAllCartes()


        root.setOnClickListener {
            click++
            textView.text = click.toString()
            val random = randomINT(0, 1000000000)
            //System.out.println("Random : $random")
            val modulos = listOf(
                250,
                500,
                1000,
                2000,
                5000,
                10000,
                25000,
                50000,
                75000,
                100000,
                250000,
                500000,
                1000000,
                5000000,
                10000000,
                100000000,
                1000000000
            )
            var trouver = false
            var modulo = 0
            for (m in modulos) {
                if (random % m == 0) {
                    trouver = true
                    modulo = m
                }
            }
            if (trouver) {
                addramdomcarte(modulo)
            }
        }
        return root

    }

    fun randomINT(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }
    fun addramdomcarte(modulo: Int){
        var nbmodulo = 0
        var carterarete: ArrayList<Carte> = ArrayList()
        for (carte in carteList) {
            if (carte.Rarete == modulo) {
                nbmodulo++
                carterarete.add(carte)
            }
        }
        val random = randomINT(0, nbmodulo-1)
        println("${carterarete[random].id} Rareté : $modulo")
        Toast.makeText(requireContext(), "${carterarete[random].nom} Rareté : $modulo", Toast.LENGTH_SHORT).show()

        carteList[carterarete[random].id-1].nb_carte++
        carteList[carterarete[random].id-1].nb_Total++

        //println(carteList[carterarete[random].id-1])
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Carte.saveData(carteList)
    }
}
