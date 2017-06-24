package com.yerko.web

import com.yerko.domain.Person
import com.yerko.services.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController(val personService: PersonService) {

    @GetMapping
    fun list() = personService.findAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: String) = personService.findOne(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody p: Person) { personService.save(p) }

}
