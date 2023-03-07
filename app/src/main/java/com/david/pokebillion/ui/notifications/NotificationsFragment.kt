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

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //create a list of 102 Carte of set-de-base pokemon






        val carteArray = arrayListOf<Carte>(
            Carte(1, "Alakazam", 100000000, 0, false),
            Carte(2, "Tortank", 1000000000, 0, false),
            Carte(3, "Leveinard", 100000000, 0, false),
            Carte(4, "Dracaufeu", 1000000000, 0, false),
            Carte(5, "Mélofée", 10000000, 0, false),
            Carte(6, "Léviator", 10000000, 0, false),
            Carte(7, "Tygnon", 10000000, 0, false),
            Carte(8, "Mackogneur", 100000000, 0, false),
            Carte(9, "Magneton", 10000000, 0, false),
            Carte(10, "Mewtwo", 10000000, 0, false),
            Carte(11, "Nidoking", 10000000, 0, false),
            Carte(12, "Feunard", 10000000, 0, false),
            Carte(13, "Tartard", 10000000, 0, false),
            Carte(14, "Raichu", 10000000, 0, false),
            Carte(15, "Florizarre", 1000000000, 0, false),
            Carte(16, "Électhor", 10000000, 0, false),
            Carte(17, "Dardargnan", 10000000, 0, false),
            Carte(18, "Draco", 10000000, 0, false),
            Carte(19, "Triopikeur", 50000, 0, false),
            Carte(20, "Élektek", 10000000, 0, false),
            Carte(21, "Électrode", 10000000, 0, false),
            Carte(22, "Roucoups", 500000, 0, false),
            Carte(23, "Arcanin", 500000, 0, false),
            Carte(24, "Reptincel", 5000000, 0, false),
            Carte(25, "Lamantine", 250000, 0, false),
            Carte(26, "Minidraco", 100000, 0, false),
            Carte(27, "Canarticho", 25000, 0, false),
            Carte(28, "Caninos", 75000, 0, false),
            Carte(29, "Spectrum", 500000, 0, false),
            Carte(30, "Herbizarre", 250000, 0, false),
            Carte(31, "Lippoutou", 25000, 0, false),
            Carte(32, "Kadabra", 1000000, 0, false),
            Carte(33, "Coconfort", 50000, 0, false),
            Carte(34, "Machopeur", 1000000, 0, false),
            Carte(35, "Magicarpe", 100000, 0, false),
            Carte(36, "Magmar", 500000, 0, false),
            Carte(37, "Nidorino", 1000000, 0, false),
            Carte(38, "Têtarte", 100000, 0, false),
            Carte(39, "Porygon", 25000, 0, false),
            Carte(40, "Rattatac", 50000, 0, false),
            Carte(41, "Otaria", 75000, 0, false),
            Carte(42, "Carabaffe", 250000, 0, false),
            Carte(43, "Abra", 100000, 0, false),
            Carte(44, "Bulbizarre", 250000, 0, false),
            Carte(45, "Chenipan", 10000, 0, false),
            Carte(46, "Salamèche", 500000, 0, false),
            Carte(47, "Taupiqueur", 10000, 0, false),
            Carte(48, "Doduo", 10000, 0, false),
            Carte(49, "Soporifik", 50000, 0, false),
            Carte(50, "Fantominus", 25000, 0, false),
            Carte(51, "Smogo", 100000, 0, false),
            Carte(52, "Machoc", 75000, 0, false),
            Carte(53, "Magneti", 75000, 0, false),
            Carte(54, "Chrysacier", 50000, 0, false),
            Carte(55, "Nidoran ♂", 100000, 0, false),
            Carte(56, "Onix", 1000000, 0, false),
            Carte(57, "Roucool", 25000, 0, false),
            Carte(58, "Pikachu", 500000, 0, false),
            Carte(59, "Ptitard", 25000, 0, false),
            Carte(60, "Ponyta", 75000, 0, false),
            Carte(61, "Rattata", 25000, 0, false),
            Carte(62, "Sabelette", 50000, 0, false),
            Carte(63, "Carapuce", 250000, 0, false),
            Carte(64, "Staross", 250000, 0, false),
            Carte(65, "Stari", 25000, 0, false),
            Carte(66, "Saquedeneu", 10000, 0, false),
            Carte(67, "Voltorbe", 10000, 0, false),
            Carte(68, "Goupix", 250, 0, false),
            Carte(69, "Aspicot", 250, 0, false),
            Carte(70, "Peluche Mélofée", 500, 0, false),
            Carte(71, "Recherche informatique", 500, 0, false),
            Carte(72, "Vaporisateur rétrograde", 500, 0, false),
            Carte(73, "Faux Professeur Chen", 500, 0, false),
            Carte(74, "Récupérateur", 500, 0, false),
            Carte(75, "Fillette", 500, 0, false),
            Carte(76, "Éleveur de Pokémon", 1000, 0, false),
            Carte(77, "Marchand de Pokémon", 1000, 0, false),
            Carte(78, "Rappel", 1000, 0, false),
            Carte(79, "Double Suppression d'Énergie", 1000, 0, false),
            Carte(80, "Defender", 1000, 0, false),
            Carte(81, "Sauvegarde d'Énergie", 1000, 0, false),
            Carte(82, "Guérison Totale", 2000, 0, false),
            Carte(83, "Entretien", 2000, 0, false),
            Carte(84, "PlusPower", 2000, 0, false),
            Carte(85, "Centre Pokémon", 2000, 0, false),
            Carte(86, "Flûte Pokémon", 2000, 0, false),
            Carte(87, "Pokédex", 2000, 0, false),
            Carte(88, "Professeur Chen", 2000, 0, false),
            Carte(89, "Réanimation", 5000, 0, false),
            Carte(90, "Super Potion", 5000, 0, false),
            Carte(91, "Léo", 5000, 0, false),
            Carte(92, "Suppression d'Énergie", 5000, 0, false),
            Carte(93, "Rafale de vent", 5000, 0, false),
            Carte(94, "Potion", 5000, 0, false),
            Carte(95, "Transfert", 5000, 0, false),
            Carte(96, "Double Énergie Incolore", 250, 0, false),
            Carte(97, "Énergie Combat", 250, 0, false),
            Carte(98, "Énergie Feu", 250, 0, false),
            Carte(99, "Énergie Plante", 250, 0, false),
            Carte(100, "Énergie Électrique", 250, 0, false),
            Carte(101, "Énergie Psy", 250, 0, false),
            Carte(102, "Énergie Eau", 250, 0, false))

        binding.cartelist.adapter = CarteListAdapter(requireContext(),carteArray)
        //val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
        //textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}