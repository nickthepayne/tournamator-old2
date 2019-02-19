package ch.tournamator

import org.junit.Assert.*
import org.junit.Test

class AppTest {

    @Test
    fun testAppHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

}
