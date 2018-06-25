package com.personal.project.bookapp.repositories

import com.personal.project.bookapp.domain.Slot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SlotRepository: JpaRepository<Slot,Long> {
}