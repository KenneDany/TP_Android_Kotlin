package com.example.testapp1

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testapp1.ui.theme.TestApp1Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = "Happy Birthday Sam!", from = "From Emma")

                }

            }
    }
}

    @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize().padding(8.dp)) {

            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center

            )
            Text(
                text = from,
                fontSize = 36.sp
            )



        }
    }

    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.androidparty)
        Box(modifier) {
            Image(
                painter = image,
                contentDescription = null
            )

            GreetingText(
                message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )

        }


    }



    @Preview(showBackground = true, name = "phone", showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    TestApp1Theme {
        GreetingImage(
            message = "Happy Birthday Sam!",
            from = "From Emma"
        )
    }
    }
}