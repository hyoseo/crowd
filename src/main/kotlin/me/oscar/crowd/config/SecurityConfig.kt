package me.oscar.crowd.config

import me.oscar.crowd.authentication.AuthFilter
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher




@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .antMatchers("/dist/**", "/plugins/**")
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
    }

    override fun configure(http: HttpSecurity) {
        http.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .authorizeRequests()
                .mvcMatchers("/", "/sign-in", "/sign-up").permitAll()
                .anyRequest().authenticated()

        http.formLogin()
                .loginPage("/sign-in")
                .permitAll()
    }

    fun authenticationFilter(): AuthFilter {
        val filter = AuthFilter()
        filter.setRequiresAuthenticationRequestMatcher(AntPathRequestMatcher("/sign-in", "POST"))
        filter.setAuthenticationManager(authenticationManagerBean())
        return filter
    }
}
