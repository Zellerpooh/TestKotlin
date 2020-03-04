package com.example.testkotlin.domain.commands

import com.example.testkotlin.data.server.ForecastRequest
import com.example.testkotlin.domain.mappers.ForecastDataMapper
import com.example.testkotlin.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}