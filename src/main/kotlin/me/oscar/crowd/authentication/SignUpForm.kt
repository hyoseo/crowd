package me.oscar.crowd.authentication

import javax.validation.constraints.Email
import javax.validation.constraints.Pattern


data class SignUpForm(@field:Email(message = "Your email format is wrong") val email: String,
                      @field:Pattern(
                          regexp = "^(?=.*\\d)(?=(.*\\W))(?=.*[a-zA-Z])(?!.*\\s).{8,100}\$",
                          message = "Your password must be between 8 ~ 100 length and must contain at least 1 digit, 1 special and 1 alphabetic character and must not contain blank space")
                      val password: String)