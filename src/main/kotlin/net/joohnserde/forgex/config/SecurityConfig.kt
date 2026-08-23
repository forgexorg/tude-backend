package net.joohnserde.forgex.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests {
                it
                    .requestMatchers("/error").permitAll()

                    .requestMatchers("/api/new_habit").permitAll()
                    .requestMatchers("/api/register").permitAll()
                    .requestMatchers("/api/login").permitAll()

                    .anyRequest().authenticated()
            }
            .csrf { it.disable() }
            .build()

    }

}
