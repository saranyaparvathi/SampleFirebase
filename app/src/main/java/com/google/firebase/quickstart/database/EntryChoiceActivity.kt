package com.google.firebase.quickstart.database

import android.content.Intent
import com.firebase.example.internal.BaseEntryChoiceActivity
import com.firebase.example.internal.Choice

class EntryChoiceActivity : BaseEntryChoiceActivity() {

    override fun getChoices(): List<Choice> {
        return listOf(
                Choice(
                        "Add Student Details",
                        "Fill in the details of Shelter home students.",
                        Intent(this, com.google.firebase.quickstart.database.java.SignInActivity::class.java)),
                Choice(
                        "View Student list",
                        "View student details.",
                        Intent(this, com.google.firebase.quickstart.database.java.MainActivity::class.java))
        )
    }
}
