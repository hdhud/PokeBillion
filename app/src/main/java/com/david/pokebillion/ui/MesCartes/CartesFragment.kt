package com.david.pokebillion.ui.MesCartes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.david.pokebillion.Carte
import com.david.pokebillion.CarteActivity
import com.david.pokebillion.CarteListAdapter
import com.david.pokebillion.databinding.FragmentCartesBinding
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class CartesFragment : Fragment() {

    private var _binding: FragmentCartesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val carteList: ArrayList<Carte> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val notificationsViewModel =
                ViewModelProvider(this).get(CartesViewModel::class.java)

        _binding = FragmentCartesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //why the data i load is
        carteList.removeAll(carteList)
        val handler = Handler()
        handler.postDelayed({
            loadData()
            binding.cartelist.adapter = CarteListAdapter(requireContext(),carteList)

            (binding.cartelist.adapter as CarteListAdapter).notifyDataSetChanged()
        }, 200)

        //val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
        //textView.text = it
        }
        binding.cartelist.setOnItemClickListener{parent,view,position,id ->
            val carte = carteList[position]

            val intent = Intent(requireContext(), CarteActivity::class.java)

            intent.putExtra("carte", carte)
            startActivity(intent)
        }
        return root
    }
    fun loadData(){
        val fileInputStream: FileInputStream = requireContext().openFileInput("data.txt")
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line = bufferedReader.readLine()
        println("Loaded data")
        while (line != null) {
            val carteArray2 = line.split("Carte(")
            for (i in 1..carteArray2.size-1) {
                val carteArray3 = carteArray2[i].split(", ")
                val carteArray4 = carteArray3[0].split("=")[1].toInt()
                val carteArray5 = carteArray3[1].split("'")[1]
                val carteArray6 = carteArray3[2].split("=")[1].toInt()
                val carteArray7 = carteArray3[3].split("=")[1].toInt()
                val carteArray8 = carteArray3[4].split("=")[1].toBoolean()
                val carteArray9 = carteArray3[3].split("=")[1].toInt()
                //System.out.println("Carte : $carteArray4, $carteArray5, $carteArray6, $carteArray7, $carteArray8, $carteArray9")
                carteList.add(Carte(carteArray4, carteArray5, carteArray6, carteArray7, carteArray8, carteArray9))
            }
            line = bufferedReader.readLine()
        }
        fileInputStream.close()
        println("Loaded data")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}