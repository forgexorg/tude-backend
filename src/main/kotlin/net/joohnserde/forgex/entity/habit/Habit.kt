package net.joohnserde.forgex.entity.habit

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.joohnserde.forgex.model.habit.HabitStatus
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "habits")
data class Habit(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = null,

    @Column(name = "user_id")
    val userId: UUID,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String?,

    @Column(name = "category")
    var category: String?,

    @Column(name = "frequency")
    var frequency: String,

    @Column(name = "current_streak")
    var currentStreak: Int,

    @Column(name = "highest_streak")
    var highestStreak: Int,

    @Column(name = "reminder_time")
    var reminderTime: Date?,

    @Column(name = "status")
    var status: HabitStatus,

    @Column(name = "created_at")
    val createdAt: Date,

)
