package com.david.pokebillion

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.david.pokebillion.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)





        val file = File("/data/user/0/com.david.pokebillion/files/data.txt")
        if (!file.exists()) {
            val carteList = listOf<Carte>(
                Carte(1, "Alakazam", 100000000, 1, false,0),
                Carte(2, "Tortank", 1000000000, 0, false,0),
                Carte(3, "Leveinard", 100000000, 0, false,0),
                Carte(4, "Dracaufeu", 1000000000, 0, false,0),
                Carte(5, "Mélofée", 10000000, 0, false,0),
                Carte(6, "Léviator", 100000000, 0, false,0),
                Carte(7, "Tygnon", 10000000, 0, false,0),
                Carte(8, "Mackogneur", 100000000, 0, false,0),
                Carte(9, "Magneton", 10000000, 0, false,0),
                Carte(10, "Mewtwo", 100000000, 0, false,0),
                Carte(11, "Nidoking", 10000000, 0, false,0),
                Carte(12, "Feunard", 100000000, 0, false,0),
                Carte(13, "Tartard", 10000000, 0, false,0),
                Carte(14, "Raichu", 10000000, 0, false,0),
                Carte(15, "Florizarre", 1000000000, 0, false,0),
                Carte(16, "Électhor", 100000000, 0, false,0),
                Carte(17, "Dardargnan", 250000, 0, false,0),
                Carte(18, "Draco", 5000000, 0, false,0),
                Carte(19, "Triopikeur", 50000, 0, false,0),
                Carte(20, "Élektek", 1000000, 0, false,0),
                Carte(21, "Électrode", 75000, 0, false,0),
                Carte(22, "Roucoups", 500000, 0, false,0),
                Carte(23, "Arcanin", 500000, 0, false,0),
                Carte(24, "Reptincel", 5000000, 0, false,0),
                Carte(25, "Lamantine", 250000, 0, false,0),
                Carte(26, "Minidraco", 100000, 0, false,0),
                Carte(27, "Canarticho", 50000, 0, false,0),
                Carte(28, "Caninos", 75000, 0, false,0),
                Carte(29, "Spectrum", 500000, 0, false,0),
                Carte(30, "Herbizarre", 250000, 0, false,0),
                Carte(31, "Lippoutou", 25000, 0, false,0),
                Carte(32, "Kadabra", 1000000, 0, false,0),
                Carte(33, "Coconfort", 50000, 0, false,0),
                Carte(34, "Machopeur", 1000000, 0, false,0),
                Carte(35, "Magicarpe", 100000, 0, false,0),
                Carte(36, "Magmar", 500000, 0, false,0),
                Carte(37, "Nidorino", 1000000, 0, false,0),
                Carte(38, "Têtarte", 100000, 0, false,0),
                Carte(39, "Porygon", 25000, 0, false,0),
                Carte(40, "Rattatac", 50000, 0, false,0),
                Carte(41, "Otaria", 75000, 0, false,0),
                Carte(42, "Carabaffe", 5000000, 0, false,0),
                Carte(43, "Abra", 100000, 0, false,0),
                Carte(44, "Bulbizarre", 5000000, 0, false,0),
                Carte(45, "Chenipan", 10000, 0, false,0),
                Carte(46, "Salamèche", 250000, 0, false,0),
                Carte(47, "Taupiqueur", 10000, 0, false,0),
                Carte(48, "Doduo", 10000, 0, false,0),
                Carte(49, "Soporifik", 500000, 0, false,0),
                Carte(50, "Fantominus", 25000, 0, false,0),
                Carte(51, "Smogo", 100000, 0, false,0),
                Carte(52, "Machoc", 75000, 0, false,0),
                Carte(53, "Magneti", 50000, 0, false,0),
                Carte(54, "Chrysacier", 50000, 0, false,0),
                Carte(55, "Nidoran ♂", 100000, 0, false,0),
                Carte(56, "Onix", 1000000, 0, false,0),
                Carte(57, "Roucool", 25000, 0, false,0),
                Carte(58, "Pikachu", 5000000, 0, false,0),
                Carte(59, "Ptitard", 25000, 0, false,0),
                Carte(60, "Ponyta", 75000, 0, false,0),
                Carte(61, "Rattata", 10000, 0, false,0),
                Carte(62, "Sabelette", 500000, 0, false,0),
                Carte(63, "Carapuce", 250000, 0, false,0),
                Carte(64, "Staross", 250000, 0, false,0),
                Carte(65, "Stari", 25000, 0, false,0),
                Carte(66, "Saquedeneu", 10000, 0, false,0),
                Carte(67, "Voltorbe", 10000, 0, false,0),
                Carte(68, "Goupix", 1000000, 0, false,0),
                Carte(69, "Aspicot", 25000, 0, false,0),
                Carte(70, "Peluche Mélofée", 500, 0, false,0),
                Carte(71, "Recherche informatique", 500, 0, false,0),
                Carte(72, "Vaporisateur rétrograde", 500, 0, false,0),
                Carte(73, "Faux Professeur Chen", 500, 0, false,0),
                Carte(74, "Récupérateur", 500, 0, false,0),
                Carte(75, "Fillette", 500, 0, false,0),
                Carte(76, "Éleveur de Pokémon", 1000, 0, false,0),
                Carte(77, "Marchand de Pokémon", 1000, 0, false,0),
                Carte(78, "Rappel", 1000, 0, false,0),
                Carte(79, "Double Suppression d'Énergie", 1000, 0, false,0),
                Carte(80, "Defender", 1000, 0, false,0),
                Carte(81, "Sauvegarde d'Énergie", 1000, 0, false,0),
                Carte(82, "Guérison Totale", 2000, 0, false,0),
                Carte(83, "Entretien", 2000, 0, false,0),
                Carte(84, "PlusPower", 2000, 0, false,0),
                Carte(85, "Centre Pokémon", 2000, 0, false,0),
                Carte(86, "Flûte Pokémon", 2000, 0, false,0),
                Carte(87, "Pokédex", 2000, 0, false,0),
                Carte(88, "Professeur Chen", 2000, 0, false,0),
                Carte(89, "Réanimation", 5000, 0, false,0),
                Carte(90, "Super Potion", 5000, 0, false,0),
                Carte(91, "Léo", 5000, 0, false,0),
                Carte(92, "Suppression d'Énergie", 5000, 0, false,0),
                Carte(93, "Rafale de vent", 5000, 0, false,0),
                Carte(94, "Potion", 5000, 0, false,0),
                Carte(95, "Transfert", 5000, 0, false,0),
                Carte(96, "Double Énergie Incolore", 250, 0, false,0),
                Carte(97, "Énergie Combat", 250, 0, false,0),
                Carte(98, "Énergie Feu", 250, 0, false,0),
                Carte(99, "Énergie Plante", 250, 0, false,0),
                Carte(100, "Énergie Électrique", 250, 0, false,0),
                Carte(101, "Énergie Psy", 250, 0, false,0),
                Carte(102, "Énergie Eau", 250, 0, false,0)
            )
<<<<<<< HEAD
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            println("createfile")
            Carte.saveData(carteList)
        }
=======
        //saveData(carteList.toString())
        //loadData()
        //Carte.saveData(carteList)

>>>>>>> 6aab91e2c47c5dfc481e46644440f72f83bec541

        /*val carteArray = loadData()
        val carteArray2 = carteArray.split("Carte(")
        for (i in 1..carteArray2.size-1) {
            val carteArray3 = carteArray2[i].split(", ")
            val carteArray4 = carteArray3[0].split("=")[1].toInt()
            val carteArray5 = carteArray3[1].split("=")[1].replace(")", "")
            val carteArray6 = carteArray3[2].split("=")[1].toInt()
            val carteArray7 = carteArray3[3].split("=")[1].toInt()
            val carteArray8 = carteArray3[4].split("=")[1].toBoolean()
            val carteArray9 = carteArray3[3].split("=")[1].toInt()

            carteList.add(Carte(carteArray4, carteArray5, carteArray6, carteArray7, carteArray8, carteArray9))
        }*/

    }

    fun saveData(data: String) {
        println("saveData")
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput("data.txt", Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun loadData(): String {
        val fileInputStream: FileInputStream
        try {
            fileInputStream = openFileInput("data.txt")
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                println(text)
                stringBuilder.append(text)
            }
            return stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }
}