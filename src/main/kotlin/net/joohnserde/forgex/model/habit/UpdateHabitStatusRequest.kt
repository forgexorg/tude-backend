package net.joohnserde.forgex.model.habit

import jakarta.validation.constraints.NotBlank
import net.joohnserde.forgex.model.habit.HabitStatus
import java.util.UUID

class UpdateHabitStatusRequest(

    @field: NotBlank
    val habitStatus: HabitStatus
)
