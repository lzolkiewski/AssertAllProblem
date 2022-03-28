package com.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssertJVerifierTest {

    @Test
    fun `test using kotlin's assertAll`() {
        val one = "somebody"

        org.junit.jupiter.api.assertAll(
            { assertThat(one).isEqualTo("somebody") }
        )
    }

    @Test
    fun `test using other java's assertAll`() {
        val two = "once"

        org.junit.jupiter.api.Assertions.assertAll(
            { assertThat(two).isEqualTo("once") }
        )
    }
}