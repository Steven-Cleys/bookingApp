package com.personal.project.bookapp.config

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.repositories.SlotRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.LocalTime

/**
 * Insert default data to repository.
 */
@Configuration
class DataInit {

    @Bean
    fun init(slotRepository: SlotRepository) = CommandLineRunner {

        val slots = mutableListOf<Slot>()

        val slot1 = Slot(
             reservationName = "a test", date = LocalDate.now(), timeFrom = LocalTime.NOON
            , timeTo = LocalTime.of(14,0)
        )

        slots.add(slot1)
        val slot2 = Slot(
             "Ikke", LocalDate.now(), LocalTime.of(14,0)
            , LocalTime.of(15,0)
        )

        slots.add(slot2)

        slotRepository.saveAll(slots)

        println(" = " + slotRepository.findAllByDate(LocalDate.now()))

    }
}