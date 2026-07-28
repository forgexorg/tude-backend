package com.joohnserde.forgex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForgexApplication

fun main(args: Array<String>) {
	runApplication<ForgexApplication>(*args)
}
