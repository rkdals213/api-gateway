package com.example.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class Controller {

    @GetMapping("/info")
    fun request(): String = "this is user server"
}