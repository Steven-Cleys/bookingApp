package com.personal.project.bookapp.endpoints

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.service.BookingService
import org.springframework.stereotype.Component
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/slot")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SlotEndpoint(val bookingService: BookingService) {
    @GET
    @Path("/all")
    fun getAllSlots(): List<Slot> {
        return bookingService.getAll()
    }

    @GET
    @Path("/date/{date}")
    fun getAllSlotsByDate(@PathParam("date") date:String): List<Slot> {
        return bookingService.getAllByDate(date)
    }
}