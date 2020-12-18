package me.oscar.crowd.authentication

import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController : CommandLineRunner {

    @GetMapping("/sign-in")
    fun signIn(): String {
        return "sign-in"
    }

    @GetMapping("/sign-up")
    fun signUp(): String {
        return "sign-up"
    }

    override fun run(vararg args: String?) {
        val encode = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("fff")

        println(encode)
        println("ended")
    }
}