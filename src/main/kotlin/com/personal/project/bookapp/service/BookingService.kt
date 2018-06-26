package com.personal.project.bookapp.service

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.repositories.SlotRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class BookingService(private val slotRepository: SlotRepository) {

    fun getAll(): List<Slot>{
        return slotRepository.findAll()
    }

    fun getAllByDate(date:String): List<Slot>{
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return getAllByDate(LocalDate.parse(date,formatter))
    }

    fun getAllByDate(date:LocalDate): List<Slot>{
        return slotRepository.findAllByDate(date)
    }

    fun addSlot(slot:Slot) : Slot {
        return slotRepository.save(slot)
    }
}