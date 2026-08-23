package net.joohnserde.forgex.controller.habit

import net.joohnserde.forgex.model.WebResponse
import net.joohnserde.forgex.model.habit.CreateHabitRequest
import net.joohnserde.forgex.model.habit.HabitResponse
import net.joohnserde.forgex.service.habit.HabitService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HabitController(private val habitService: HabitService) {

    @PostMapping(
        value = ["/api/new_habit"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun newHabit(
        @RequestBody body: CreateHabitRequest
    ): WebResponse<HabitResponse> {

        val response = habitService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}
