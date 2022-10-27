package com.example.kiparolessons.cleancodetest.presentation

interface MainEvent

class SaveEvent(val text: String) : MainEvent
class LoadEvent : MainEvent