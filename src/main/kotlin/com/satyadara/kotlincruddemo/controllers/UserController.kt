package com.satyadara.kotlincruddemo.controllers

import com.satyadara.kotlincruddemo.models.User
import com.satyadara.kotlincruddemo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/user"])
data class UserController(@Autowired val userService: UserService) {
    @RequestMapping(value = [""],
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun index(): List<User> {
        return userService.index()
    }

    @RequestMapping(value = ["/{id}"],
            method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun show(@PathVariable("id") id: String): User {
        return userService.show(id)
    }

    @RequestMapping(value = [""],
            method = [RequestMethod.POST],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(@RequestBody user: User): User {
        return userService.save(user)
    }

    @RequestMapping(value = ["/{id}/update"],
            method = [RequestMethod.PUT],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody user: User, @PathVariable("id") id: String): User {
        return userService.update(user, id)
    }

    @RequestMapping(value = ["/{id}"],
            method = [RequestMethod.DELETE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable("id") id: String): String {
        userService.delete(id)
        return "DELETED"
    }
}
