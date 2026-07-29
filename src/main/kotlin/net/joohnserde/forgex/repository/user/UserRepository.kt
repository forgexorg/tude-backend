package net.joohnserde.forgex.repository.user

import net.joohnserde.forgex.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository

class UserRepository : JpaRepository<User, Int>
