package com.example.socialapp.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.socialapp.MainActivity
import org.junit.Rule
import org.junit.Test

class SignupTest {

    @get:Rule
    val signupTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignUp() {
        launchingSignupScreen(signupTestRule) {
            typeEmail("basil@gmail.com")
            typePassword("Password")
            submit()
        } verify {
            timeLineScreenIsPresent()
        }
    }
}