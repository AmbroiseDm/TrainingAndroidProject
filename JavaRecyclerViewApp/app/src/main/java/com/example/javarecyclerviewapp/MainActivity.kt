package com.example.javarecyclerviewapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val listItems = ArrayList<ListItems>()

    private val listSize = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLists()
        initRecyclerView()
    }

    private fun initLists() {

        for (n in 1..listSize) {
            val url = "https://dummyimage.com/30x30/ffffff/000000.png&text=$n"
            val txt = "Voici l'élément numéro $n de cette liste"
            val color: Int = when {
                n % 3 == 1 -> Color.BLUE
                n % 3 == 2 -> Color.GREEN
                else -> Color.YELLOW
            }
            listItems.add(ListItems(url, txt, color))
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = RecyclerViewAdapter(this, listItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}