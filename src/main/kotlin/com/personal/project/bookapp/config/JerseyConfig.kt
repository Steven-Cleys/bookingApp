package com.personal.project.bookapp.config

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component
import com.personal.project.bookapp.endpoints.HelloWorldResource
import org.glassfish.jersey.servlet.ServletProperties
import javax.ws.rs.ApplicationPath

@Component
@ApplicationPath("api")
class JerseyConfig : ResourceConfig() {
    init {
        packages("com.personal.project.bookapp.endpoints")
       // register(HelloWorldResource())

    }
}