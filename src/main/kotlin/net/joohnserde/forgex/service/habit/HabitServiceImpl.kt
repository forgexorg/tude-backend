package net.joohnserde.forgex.service.habit

import net.joohnserde.forgex.entity.habit.Habit
import net.joohnserde.forgex.exception.NotFoundException
import net.joohnserde.forgex.model.habit.CreateHabitRequest
import net.joohnserde.forgex.model.habit.HabitResponse
import net.joohnserde.forgex.model.habit.HabitStatus
import net.joohnserde.forgex.model.habit.UpdateHabitRequest
import net.joohnserde.forgex.model.habit.UpdateHabitStatusRequest
import net.joohnserde.forgex.repository.habit.HabitRepository
import net.joohnserde.forgex.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.UUID


@Service
class HabitServiceImpl(

    val habitRepository: HabitRepository,

    val validationUtil: ValidationUtil,

) : HabitService {

    override fun create(habitRequest: CreateHabitRequest): HabitResponse {

        validationUtil.validate(habitRequest)

        val newHabit = Habit(
            userId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
            title = habitRequest.title,
            description = habitRequest.description,
            category = habitRequest.category,
            frequency = habitRequest.frequency,
            currentStreak = 0,
            highestStreak = 0,
            reminderTime = habitRequest.reminderTime,
            status = HabitStatus.NOTDONE,
            createdAt = Date(),
        )

        habitRepository.save(newHabit)
        return toHabitResponse(newHabit)
    }

    override fun update(
        id: UUID,
        habitRequest: UpdateHabitRequest
    ): HabitResponse {

        val habit = habitRepository.findByIdOrNull(id)
            ?: throw NotFoundException("habit not found")

        habit.apply {
            description = habitRequest.description
            category = habitRequest.category
            frequency = habitRequest.frequency
            reminderTime = habitRequest.reminderTime
        }
        habitRepository.save(habit)
        return toHabitResponse(habit)
    }

    override fun updateStatus(
        id: UUID,
        habitRequest: UpdateHabitStatusRequest
    ): HabitResponse {

        val habit = habitRepository.findByIdOrNull(id)
            ?: throw NotFoundException("habit not found")

        habit.status = habitRequest.habitStatus
        habitRepository.save(habit)
        return toHabitResponse(habit)
    }


    fun toHabitResponse(habit: Habit): HabitResponse {
        return HabitResponse(
            id = habit.id!!,
            userId = habit.userId,
            title = habit.title,
            description = habit.description,
            category = habit.category,
            frequency = habit.frequency,
            currentStreak = habit.currentStreak,
            highestStreak = habit.highestStreak,
            reminderTime = habit.reminderTime,
            status = habit.status,
            createdAt = habit.createdAt,
        )
    }

}
