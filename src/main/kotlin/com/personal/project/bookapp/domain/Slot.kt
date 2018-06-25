package com.personal.project.bookapp.domain

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Slot(
    val reservationName: String,
    val date: LocalDate,
    val timeFrom: LocalTime,
    val timeTo: LocalTime,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)