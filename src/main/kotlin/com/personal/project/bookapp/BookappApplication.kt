package com.personal.project.bookapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookappApplication

fun main(args: Array<String>) {
    runApplication<BookappApplication>(*args)
}
