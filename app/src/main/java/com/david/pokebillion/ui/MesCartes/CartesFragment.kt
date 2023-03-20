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
import com.david.pokebillion.profil
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class CartesFragment : Fragment() {

    private var _binding: FragmentCartesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var carteList: List<Carte> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // si on a jamais trouver la carte , on l'affiche pas


        val notificationsViewModel =
                ViewModelProvider(this).get(CartesViewModel::class.java)

        _binding = FragmentCartesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val handler = Handler()
        handler.postDelayed({
            carteList = profil.getcarteList()
            carteList = carteList.filter { it.nb_Total != 0 }
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}