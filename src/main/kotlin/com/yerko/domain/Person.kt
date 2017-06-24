package com.yerko.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "person")
class Person(@Id val id: String = "",
             @NotNull val firstName: String = "",
             @NotNull val lastNameName: String = "")