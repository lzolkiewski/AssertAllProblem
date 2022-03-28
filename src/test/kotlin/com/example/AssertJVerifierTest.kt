package com.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class AssertJVerifierTest {

    @Test
    fun `test using kotlin's assertall`() {
        val one: String = "somebody"
        val two: String = "once"

        assertAll(
            "Just simple test",
            { Assertions.assertThat(one).isEqualTo("somebody") }
        )
    }
}