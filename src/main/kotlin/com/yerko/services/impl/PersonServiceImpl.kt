package com.yerko.services.impl

import com.yerko.domain.Person
import com.yerko.repositories.PersonRepository
import com.yerko.services.PersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(val personRepository: PersonRepository) : PersonService {

    override fun findAll(): List<Person> {
        return personRepository.findAll();
    }

    override fun findOne(id: String): Person {
       return personRepository.findOne(id)
    }

    override fun save(p: Person) {
        personRepository.save(p)
    }

    override fun save(p: List<Person>) {
        personRepository.save(p)
    }

}