package com.yerko.repository

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.yerko.domain.Person
import com.yerko.repositories.PersonRepository
import com.yerko.services.impl.PersonServiceImpl
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class PersonRepositoryTest : Spek({

    describe("Save persons") {
        val personRepository : PersonRepository = mock()
        val personService = PersonServiceImpl(personRepository)

        it("should save a person") {
            val person = Person("1111", "John", "Doe")
            personService.save(person)
            verify(personRepository, times(1)).save(person)
        }

        it("should save a list of persons") {
            val person1 = Person("1111", "John", "Doe")
            val person2 = Person("2222", "Doe", "Doe")
            val persons = listOf(person1,person2)
            personService.save(persons)
            verify(personRepository, times(1)).save(persons)
        }
    }

    describe("Find persons") {
        val personRepository : PersonRepository = mock()
        val personService = PersonServiceImpl(personRepository)

        it("should find one person by id") {
            val id = "1111"
            val person = Person("1111", "John", "Doe")
            whenever(personRepository.findOne(id)).thenReturn(person)

            val p = personService.findOne(id)
            assertThat(p.id, equalTo(id))
            assertThat(p.firstName, equalTo("John"))
            assertThat(p.lastNameName, equalTo("Doe"))
        }

        it("should find all persons") {
            val person1 = Person("1111", "John", "Doe")
            val person2 = Person("2222", "Doe", "Doe")
            val persons = listOf(person1,person2)

            whenever(personRepository.findAll()).thenReturn(persons)

            val p = personService.findAll()
            assertThat(p.size, equalTo(persons.size))
        }

        it("should return empty list") {
            val person1 = Person("1111", "John", "Doe")
            val person2 = Person("2222", "Doe", "Doe")
            val persons = listOf(person1,person2)

            whenever(personRepository.findAll()).thenReturn(mutableListOf<Person>())

            val p = personService.findAll()
            assertThat(p.size, equalTo(0))
        }

    }


})
