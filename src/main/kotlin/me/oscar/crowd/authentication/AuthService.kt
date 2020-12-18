package me.oscar.crowd.authentication

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.stereotype.Service

@Service
class AuthService : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        println("the username is $username")
        PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("fff")

        return null
    }
}