package com.example.socialapp.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.socialapp.MainActivity
import com.example.socialapp.R

fun launchingSignupScreen(
    rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: SignupRoboto.() -> Unit
): SignupRoboto {
    return SignupRoboto(rule).apply(block)
}

class SignupRoboto(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun typeEmail(email: String) {
        val emailHint = rule.activity.getString(R.string.label_hint_email)
        rule.onNodeWithText(emailHint)
            .performTextInput(email)
    }

    fun typePassword(password: String) {
        val passwordHint = rule.activity.getString(R.string.label_hint_password)
        rule.onNodeWithText(passwordHint)
            .performTextInput(password)
    }

    fun submit() {
        val labelSubmit = rule.activity.getString(R.string.label_submit)
        rule.onNodeWithText(labelSubmit)
            .performClick()
    }

    infix fun verify(block: SignUpVerification.() -> Unit):SignUpVerification {
       return SignUpVerification(rule).apply(block)
    }

}

class SignUpVerification(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun timeLineScreenIsPresent() {
        val titleTimeLine = rule.activity.title.toString()
        rule.onNodeWithText(titleTimeLine)
            .assertIsDisplayed()
    }

}
