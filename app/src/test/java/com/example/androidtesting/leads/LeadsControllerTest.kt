package com.example.androidtesting.leads

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class LeadsControllerTest {

    private lateinit var controller: LeadsController

    @Before
    fun setup() {
        controller = LeadsController()
    }

    @Test
    fun `Given valid lead  when call addLead() then we should expect leads list has on item`() {
        // Given
        val lead = Lead("Mohamed", "Ramadan", "01016125421")

        // When
        controller.addLead(lead)

        // Then
        assertEquals(1, controller.getLeads().size)
    }

    @Test
    fun `Given lead with two chars in  first name when call addLead() then we should expect that leads is empty`() {
        // Given
        val lead = Lead("mo", "Elgohary", "089798")

        // When
        controller.addLead(lead)

        // Then
        assertTrue(controller.getLeads().isEmpty())
    }

    @Test
    fun `Given lead with two chars in last name when call addLead() then we should expect that leads is empty`() {
        // Given
        val lead = Lead("mahmoud", "", "1111111")

        // When
        controller.addLead(lead)

        // Then
        controller.getLeads().isEmpty().let { assertTrue(it) }
    }

    @Test
    fun `Given lead with not valid phone number when call addLead() then we should expect that leads is empty`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "3123")

        // When
        controller.addLead(lead)
        assertTrue(controller.getLeads().isEmpty())
    }

    @Test
    fun `Given lead with not valid phone number with 12 digits when call addLead() then we should expect that leads is empty`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "012938989132")

        // When
        controller.addLead(lead)

        // Then
        assertTrue(controller.getLeads().isEmpty())
    }

    @Test
    fun `Given lead with valid phone number with 1 digits  when call addLead() then we should expect that leads has one item`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "12938989132")

        // When
        controller.addLead(lead)

        // Then
        assertEquals(1, controller.getLeads().size)
    }

    @Test
    fun `Given lead with  phone number with 11 chars when call addLead() then we should expect that leads are empty`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "mimo")

        // When
        controller.addLead(lead)

        // Then
        assertTrue(controller.getLeads().isEmpty())
    }

    @Test
    fun `Given lead with duplicated leads when call addLead() then we should expect that leads length is one item`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "11111111111")

        // When
        controller.addLead(lead)
        controller.addLead(lead)

        // Then
        assertEquals(1, controller.getLeads().size)
    }

    @Test
    fun `Given  duplicated lead   when call addLead() then we should expect that leads list size is 1 `() {
        // Given
        val lead1 = Lead("Mohamed", "Elgohary", "11111111111")
        val lead2 = Lead("Mohamed", "Elgohary", "11111111111")

        // When
        controller.addLead(lead1)
        controller.addLead(lead2)

        // Then
        assertEquals(1, controller.getLeads().size)
    }

    @Ignore("ignore this test for now")
    @Test
    fun `Given lead with 5 number phone digits  when call addLead() then we should expect that leads is empty`() {
        // Given
        val lead = Lead("Mohamed", "Elgohary", "11111")

        // When
        controller.addLead(lead)

        // Then
        assertTrue(controller.getLeads().isEmpty())
    }

    @After
    fun close() {
        println("close ..... called")
        controller = LeadsController()
    }
}
