package com.example.testkotlin.domain.commands

interface Command<out T> {
    fun execute(): T
}