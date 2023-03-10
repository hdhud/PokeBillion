package com.david.pokebillion.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.david.pokebillion.Carte
import com.david.pokebillion.CarteListAdapter
import com.david.pokebillion.R
import com.david.pokebillion.databinding.FragmentNotificationsBinding
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.lang.Thread.sleep

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val carteList: ArrayList<Carte> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        sleep(1000)
        val notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root



        loadData()
        binding.cartelist.adapter = CarteListAdapter(requireContext(),carteList)
        //val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
        //textView.text = it
        }
        return root
    }
    fun loadData(){
        val fileInputStream: FileInputStream = requireContext().openFileInput("data.txt")
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line = bufferedReader.readLine()
        while (line != null) {
            val carteArray2 = line.split("Carte(")
            for (i in 1..carteArray2.size-1) {
                val carteArray3 = carteArray2[i].split(", ")
                val carteArray4 = carteArray3[0].split("=")[1].toInt()
                val carteArray5 = carteArray3[1].split("'")[1]
                val carteArray6 = carteArray3[2].split("'")[1].toInt()
                val carteArray7 = carteArray3[3].split("=")[1].toInt()
                val carteArray8 = carteArray3[4].split("=")[1].toBoolean()
                //System.out.println("Carte : $carteArray4, $carteArray5, $carteArray6, $carteArray7, $carteArray8")
                carteList.add(Carte(carteArray4, carteArray5, carteArray6, carteArray7, carteArray8))
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