package net.joohnserde.forgex.repository.user

import net.joohnserde.forgex.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserRepository : JpaRepository<User, Int> {

    fun findByUsername(username: String): User?

    fun findByEmail(email: String): User?
}
