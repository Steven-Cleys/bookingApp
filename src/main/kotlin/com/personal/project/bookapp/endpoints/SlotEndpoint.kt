package com.personal.project.bookapp.endpoints

import com.personal.project.bookapp.domain.Slot
import com.personal.project.bookapp.service.BookingService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

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

    @POST
    @Path("/book")
    fun getAllSlotsByDate(@RequestBody slot:Slot) : Response {
        //TODO better error handling
        return try {
            val _slot = bookingService.addSlot(slot)
            Response.ok(_slot, MediaType.APPLICATION_JSON).build()
        } catch (e:Exception) {
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.localizedMessage).build()
        }
    }
}