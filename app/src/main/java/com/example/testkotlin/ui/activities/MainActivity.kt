package com.example.testkotlin.ui.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.R
import com.example.testkotlin.data.db.ForecastDbHelper
import com.example.testkotlin.domain.commands.RequestForecastCommand
import com.example.testkotlin.domain.model.Forecast
import com.example.testkotlin.ui.adapters.ForecastListAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread




/**
 * @url:https://github.com/antoniolg/Kotlin-for-Android-Developers
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {

                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastList.adapter = adapter

            }
        }
    }

}





