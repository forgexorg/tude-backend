package net.joohnserde.forgex.service.habit

import net.joohnserde.forgex.model.habit.CreateHabitRequest
import net.joohnserde.forgex.model.habit.HabitResponse
import net.joohnserde.forgex.model.habit.HabitStatus
import net.joohnserde.forgex.model.habit.UpdateHabitRequest
import net.joohnserde.forgex.model.habit.UpdateHabitStatusRequest
import java.util.Date
import java.util.UUID


interface HabitService {

    fun create(habitRequest: CreateHabitRequest): HabitResponse

    fun update(id: UUID, habitRequest: UpdateHabitRequest): HabitResponse

    fun updateStatus(id: UUID, habitRequest: UpdateHabitStatusRequest): HabitResponse
}
