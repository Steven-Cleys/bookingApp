package com.personal.project.bookapp.service

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.repositories.SlotRepository
import org.springframework.stereotype.Service

@Service
class BookingService(private val slotRepository: SlotRepository) {
    fun getData(): Unit {
        println("javaClass = $javaClass")

        val list = slotRepository.findAll()
        list.forEach{
            println("result is $it")
        }
    }
}