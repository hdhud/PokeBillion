package com.david.pokebillion.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.david.pokebillion.Carte
import com.david.pokebillion.databinding.FragmentHomeBinding
import java.io.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val carteList: ArrayList<Carte> = ArrayList()
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        carteList.removeAll(carteList)
        loadData()

        root.setOnClickListener {
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
        println(carterarete[random].id)
        carteList[carterarete[random].id-1].nb_carte++
    }
    fun loadData() {
        val fileInputStream: FileInputStream = requireContext().openFileInput("data.txt")
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line = bufferedReader.readLine()
        while (line != null) {
            val carteArray2 = line.split("Carte(")
            for (i in 1..carteArray2.size - 1) {
                val carteArray3 = carteArray2[i].split(", ")
                val carteArray4 = carteArray3[0].split("=")[1].toInt()
                val carteArray5 = carteArray3[1].split("'")[1]
                val carteArray6 = carteArray3[2].split("'")[1].toInt()
                val carteArray7 = carteArray3[3].split("=")[1].toInt()
                val carteArray8 = carteArray3[4].split("=")[1].toBoolean()
                //System.out.println("Carte : $carteArray4, $carteArray5, $carteArray6, $carteArray7, $carteArray8")
                carteList.add(
                    Carte(
                        carteArray4,
                        carteArray5,
                        carteArray6,
                        carteArray7,
                        carteArray8
                    )
                )
            }
            line = bufferedReader.readLine()
        }
        fileInputStream.close()
        println("Load data")
    }
    fun saveData() {
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = requireContext().openFileOutput("data.txt", Context.MODE_PRIVATE)
            /*for (carte in carteList) {
                println(carte)
            }*/
            fileOutputStream.write(carteList.toString().toByteArray())
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        saveData()
    }
}
