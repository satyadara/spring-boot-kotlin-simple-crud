package com.satyadara.kotlincruddemo.services.impl

import com.satyadara.kotlincruddemo.models.User
import com.satyadara.kotlincruddemo.repositories.UserRepository
import com.satyadara.kotlincruddemo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
data class UserServiceImpl(@Autowired val userRepository: UserRepository) : UserService {
    override fun index(): List<User> {
        return userRepository.findAll()
    }

    override fun show(id: String): User {
        return userRepository.getOne(id)
    }

    override fun save(user: User): User {
        return userRepository.save(user)
    }

    override fun update(user: User, id: String): User {
        var edit: User = userRepository.getOne(id)
        edit.address = user.address
        edit.age = user.age

        return userRepository.save(edit)
    }

    override fun delete(id: String) {
        userRepository.delete(userRepository.getOne(id))
    }

    override fun searchByAge(age: Int): List<User> {
        return userRepository.findAllByAge(age)
    }
}
