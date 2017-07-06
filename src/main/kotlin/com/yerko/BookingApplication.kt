package com.yerko

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BookingApplication

fun main(args: Array<String>) {
    SpringApplication.run(BookingApplication::class.java, *args)
}
