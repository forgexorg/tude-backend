package net.joohnserde.forgex.entity.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "user")
data class User(

    @Id
    val id: Int,

    @Column(name = "username")
    val username: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "registered_at")
    val registered_at: Date

)
