package com.gunder.composelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row {
        Image(painter = painterResource(R.drawable.ic_account), contentDescription = "account logo")
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(msg = Message("Guna", "hello theres! i'm using compose to build android apps!"))
}

