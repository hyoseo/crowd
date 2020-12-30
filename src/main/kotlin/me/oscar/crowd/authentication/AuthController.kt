package me.oscar.crowd.authentication

import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.validation.Valid

@Controller
class AuthController {

    @GetMapping("/sign-in")
    fun signIn(): String {
        return "sign-in"
    }

    @GetMapping("/sign-up")
    fun signUp(): String {
        return "sign-up"
    }

    @PostMapping("/sign-up")
    @ResponseBody
    fun register(@Valid signUpForm: SignUpForm, errors: Errors): String {

        return "your ${signUpForm.email} + ${signUpForm.password} ${errors.hasErrors()} ${errors.allErrors}"
    }
}