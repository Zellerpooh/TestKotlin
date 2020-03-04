package com.example.testkotlin.domain.mappers

import com.example.testkotlin.data.server.Forecast
import com.example.testkotlin.data.server.ForecastResult
import com.example.testkotlin.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.testkotlin.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
            ForecastList(
                    forecast.city.name,
                    forecast.city.country,
                    convertForecastListToDomain(forecast.list)
            )

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                forecast.dt,
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon)
        )
    }

    private fun generateIconUrl(iconCode: String): String =
            "http://openweathermap.org/img/w/$iconCode.png"


}