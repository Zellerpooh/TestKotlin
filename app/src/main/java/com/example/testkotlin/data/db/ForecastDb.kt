package com.example.testkotlin.data.db

class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode:Long,date:Long)=forecastDbHelper.use{


    }



}