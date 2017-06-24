package com.yerko

import com.yerko.domain.Person
import com.yerko.repositories.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BookingApplication{

    @Bean
    open fun init(repository: PersonRepository) = CommandLineRunner {
        repository.save(Person("1111", "John", "Doe"))
        repository.save(Person("2222", "lorem", "ipsum"))
        repository.save(Person("3333", "alice", "chains"))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(BookingApplication::class.java, *args)
}
