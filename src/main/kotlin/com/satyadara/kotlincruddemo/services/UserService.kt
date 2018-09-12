package com.satyadara.kotlincruddemo.services

import com.satyadara.kotlincruddemo.models.User

interface UserService {
    fun index(): List<User>
    fun show(id: String): User
    fun save(user: User): User
    fun update(user: User, id: String): User
    fun delete(id: String)
}
