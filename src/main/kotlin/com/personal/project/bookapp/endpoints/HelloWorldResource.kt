package com.personal.project.bookapp.endpoints

import com.personal.project.bookapp.service.BookingService
import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
@Component
class HelloWorldResource(val bookingService:BookingService) {

    @Path("/world")
    @GET
    fun helloWorld(): String {
        bookingService.getData()
        return "Hello World"
    }

}