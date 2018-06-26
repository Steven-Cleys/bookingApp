package com.personal.project.bookapp.repositories

import com.personal.project.bookapp.domain.Slot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface SlotRepository: JpaRepository<Slot,Long> {

    fun findAllByDate(date: LocalDate) :List<Slot>
}