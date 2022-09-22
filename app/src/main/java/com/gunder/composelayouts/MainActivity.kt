package com.gunder.composelayouts

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gunder.composelayouts.ui.theme.ComposeLayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                androidx.compose.material.Surface {
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(R.drawable.ic_account), contentDescription = "account logo",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape))
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material.Surface(shape = MaterialTheme.shapes.medium,
                elevation = 1.dp) {
                Text(text = msg.body,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(all = 4.dp))
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeLayoutsTheme {
        androidx.compose.material.Surface {
            MessageCard(msg = Message("Guna",
                "hello theres! i'm using compose to build android apps!"))
        }
    }
}

