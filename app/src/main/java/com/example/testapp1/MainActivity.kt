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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                    GreetingImage(message = "Happy Birthday Dany!", from = "From Kenne")

                }

            }
    }
}
    /**/
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
                fontSize = 36.sp,
                        modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.End)

            )
        }
    }

    //premier page
    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.androidparty)
        Box(modifier) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
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

    //deuxieme page : Article sur Compose
    @Composable
    fun Article(  modifier: Modifier=Modifier){
        Column(modifier) {

            Image(
                painter = painterResource(R.drawable.bg_compose_background),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Text(text = stringResource(R.string.title),
                fontSize = 30.sp, modifier = modifier.padding(16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.description) ,
                fontSize = 24.sp, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify
            )
            Text(text =  stringResource(R.string.description_content),
                fontSize = 24.sp, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify
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

        //Article()
    }
    }
}