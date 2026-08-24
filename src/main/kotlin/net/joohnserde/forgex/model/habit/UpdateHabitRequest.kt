package net.joohnserde.forgex.model.habit

import net.joohnserde.forgex.model.habit.HabitStatus
import java.sql.Date

class UpdateHabitRequest(

    val title: String,

    val description: String?,

    val category: String?,

    val frequency: String,

    val reminderTime: Date?,
)
