package net.joohnserde.forgex.entity.user

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.Date


@Entity
@Table(name = "user")
class User(

    val name: String,

    val username: String,

    val email: String,

    val registered_at: Date
)
