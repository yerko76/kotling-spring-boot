package com.yerko.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "booking_status")
class BookingStatus(@Id @GeneratedValue val id: Int = 0,
                    @NotNull val status: String = "")
