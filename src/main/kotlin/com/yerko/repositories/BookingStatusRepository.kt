package com.yerko.repositories

import com.yerko.domain.BookingStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingStatusRepository : JpaRepository<BookingStatus, Int>