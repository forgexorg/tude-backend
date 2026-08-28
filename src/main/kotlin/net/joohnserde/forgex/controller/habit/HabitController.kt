package net.joohnserde.forgex.controller.habit

import net.joohnserde.forgex.model.WebResponse
import net.joohnserde.forgex.model.habit.CreateHabitRequest
import net.joohnserde.forgex.model.habit.HabitResponse
import net.joohnserde.forgex.model.habit.HabitStatus
import net.joohnserde.forgex.model.habit.UpdateHabitRequest
import net.joohnserde.forgex.model.habit.UpdateHabitStatusRequest
import net.joohnserde.forgex.service.habit.HabitService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/api/habit")
class HabitController(private val habitService: HabitService) {

    @PostMapping(
        value = ["/create"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun createHabit(
        @RequestBody request: CreateHabitRequest
    ): WebResponse<HabitResponse> {

        val response = habitService.create(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(
        value = ["/{id}/update"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun updateHabit(
        @PathVariable id: UUID,
        @RequestBody request: UpdateHabitRequest
    ): WebResponse<HabitResponse> {

        val response = habitService.update(id, request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )

    }

    @PutMapping(
        value = ["/{id}/update_status"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun updateStatusHabit(
        @PathVariable id: UUID,
        @RequestBody request: UpdateHabitStatusRequest
    ): WebResponse<HabitResponse> {

        val response = habitService.updateStatus(id, request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}
