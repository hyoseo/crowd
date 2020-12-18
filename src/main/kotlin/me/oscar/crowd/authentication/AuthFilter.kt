package me.oscar.crowd.authentication

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.math.BigInteger
import java.security.MessageDigest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AuthFilter : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val username = obtainUsername(request) ?: ""
        val password = obtainPassword(request) ?: ""

        val authRequest = UsernamePasswordAuthenticationToken(encryptUserName(username, password), password)

        setDetails(request, authRequest)
        return this.authenticationManager.authenticate(authRequest);
    }

    fun encryptUserName(username: String, password: String): String {
        val md = MessageDigest.getInstance("SHA3-512")
        md.update(password.encodeToByteArray())
        md.update(password.reversed().encodeToByteArray())
        val digest = md.digest(username.encodeToByteArray())

        return String.format("%0" + (digest.size shl 1).toString() + "X", BigInteger(1, digest))
    }
}