package net.joohnserde.forgex.service.habit

import net.joohnserde.forgex.model.habit.CreateHabitRequest
import net.joohnserde.forgex.model.habit.HabitResponse


interface HabitService {

    fun create(habitRequest: CreateHabitRequest): HabitResponse

}
