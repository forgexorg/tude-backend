package net.joohnserde.forgex.repository.habit

import net.joohnserde.forgex.entity.habit.Habit
import org.springframework.data.jpa.repository.JpaRepository

interface HabitRepository : JpaRepository<Habit, Int>
