package net.joohnserde.forgex.model.habit

import java.util.Date
import java.util.UUID

class HabitResponse(

    val userId: UUID,

    val title: String,

    val description: String?,

    val category: String?,

    val frequency: String,

    val currentStreak: Int,

    val highestStreak: Int,

    val reminderTime: Date?,

    val status: HabitStatus,

    val createdAt: Date,

)
