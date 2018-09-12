package com.satyadara.kotlincruddemo.repositories

import com.satyadara.kotlincruddemo.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>
