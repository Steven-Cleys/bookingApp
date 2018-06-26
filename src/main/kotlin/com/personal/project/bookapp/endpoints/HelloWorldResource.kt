package com.personal.project.bookapp.endpoints

import com.personal.project.bookapp.service.BookingService
import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
@Component
class HelloWorldResource() {

    @Path("/world")
    @GET
    fun helloWorld(): String {
        return "Hello World"
    }

}