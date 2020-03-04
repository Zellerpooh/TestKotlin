package com.example.testkotlin.ui

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import com.example.testkotlin.utils.DelegatesExt

class App: Application() {

    companion object{
        var instance:App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate(){
        super.onCreate()
        instance=this
    }



}