package net.joohnserde.forgex.model.habit

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.Date
import java.util.UUID

class CreateHabitRequest(

    @field:NotBlank
    val title: String,

    val description: String?,

    val category: String?,

    @field:NotBlank
    val frequency: String,

    val reminderTime: Date?,

)
