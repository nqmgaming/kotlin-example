package com.nqmgaming.kotlin.lab2.b8

class ManagerCard {
    private val _listCard = mutableListOf<Card>()
    val listCard: List<Card>
        get() = _listCard

    fun addCard(card: Card) {
//        _listCard.add(card)
        if (_listCard.find { it.id == card.id } == null) {
            _listCard.add(card)
            println("Card added")
        } else {
            println("Card already exists")
        }
    }

    fun deleteCardById(id: Int) {
        val card = _listCard.find { it.id == id }
        if (card != null) {
            _listCard.remove(card)
            println("Card removed")
        } else {
            println("Card not found")
        }
    }
}