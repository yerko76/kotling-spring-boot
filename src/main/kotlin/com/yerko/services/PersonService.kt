package com.yerko.services

import com.yerko.domain.Person

interface PersonService{
    fun findAll(): List<Person>
    fun findOne(id: String): Person
    fun save(p: Person)
    fun save(p: List<Person>)
}