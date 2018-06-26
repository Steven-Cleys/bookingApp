package com.personal.project.bookapp.service

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.repositories.SlotRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class BookingService(private val slotRepository: SlotRepository) {
    fun getData(): Unit {
        println("javaClass = $javaClass")

        val list = slotRepository.findAll()
        list.forEach{
            println("result is $it")
        }
    }

    fun getAll(): List<Slot>{
        return slotRepository.findAll()
    }

    fun getAllByDate(date:String): List<Slot>{
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return getAllByDate(LocalDate.parse(date,formatter))
    }

    fun getAllByDate(date:LocalDate): List<Slot>{
        return slotRepository.findAllByDate(date)
    }
}