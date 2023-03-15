package com.david.pokebillion.ui.Jeux

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.david.pokebillion.databinding.FragmentJeuxBinding
import com.david.pokebillion.jeu1
import com.david.pokebillion.jeu2

class JeuxFragment : Fragment() {

    private var _binding: FragmentJeuxBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val JeuxViewModel =
            ViewModelProvider(this).get(JeuxViewModel::class.java)

        _binding = FragmentJeuxBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val button1 = binding.boutonHaut
        val button2 = binding.boutonBas
        button1.setOnClickListener {
            val intent =  Intent(activity, jeu1::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent =  Intent(activity, jeu2::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}