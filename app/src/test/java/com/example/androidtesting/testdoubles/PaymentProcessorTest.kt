package com.example.androidtesting.testdoubles

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertTrue
import org.junit.Test

class PaymentProcessorTest {

    @Test
    fun `test stub test doubles scenario`() {
        val paymentService: PaymentService = mockk()
        val paymentProcessor = PaymentProcessor(paymentService)
        // stub
        every { paymentService.processPayment(any()) } returns true

        val result = paymentProcessor.pay(10)

        assertTrue(result)
    }
}