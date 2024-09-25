package com.example.testapp1

import android.media.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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

            Text(text = stringResource(R.string.title1),
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

    //troisime page : TodoList
    @Composable
    fun ToDoList(modifier: Modifier=Modifier){

        Column(modifier.padding(45.dp, 100.dp, 45.dp, 100.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.ic_task_completed),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
            Text(text = stringResource(R.string.todoTitle) ,
                fontSize = 24.sp, fontWeight = FontWeight.Bold,
                modifier = modifier.padding(0.dp, 16.dp, 0.dp, 16.dp)
            )
            Text(text =  stringResource(R.string.todoContent),
                fontSize = 16.sp, modifier = modifier.padding(16.dp)
            )
        }
    }

    //quatrieme page : ComponentColumn
    @Composable
    fun componentColumn(title : String, content : String, backgroundColumn : Color, modifier: Modifier=Modifier){
        Column(
            modifier
                .background(backgroundColumn)
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = title,
                fontSize = 24.sp, fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(text = content,
                fontSize = 24.sp,
                textAlign = TextAlign.Justify,

                )
        }
    }

    //Cinqieme page : quadrant
    @Composable
    fun QuadrantCompose(modifier: Modifier=Modifier){
        Column(modifier.fillMaxSize()) {
            Row(modifier.weight(1f)) {
                componentColumn(
                    title = stringResource(R.string.quandrantTitleColumn1),
                    content = stringResource(R.string.quandrantContentColumn1),
                    backgroundColumn = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                componentColumn(
                    title = stringResource(R.string.quandrantTitleColumn2),
                    content = stringResource(R.string.quandrantContentColumn2),
                    backgroundColumn = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier.weight(1f) ) {
                componentColumn(
                    title = stringResource(R.string.quandrantTitleColumn1),
                    content = stringResource(R.string.quandrantContentColumn1),
                    backgroundColumn = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                componentColumn(
                    title = stringResource(R.string.quandrantTitleColumn2),
                    content = stringResource(R.string.quandrantContentColumn2),
                    backgroundColumn = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun contactFooter(icon : Image, text : String, modifier: Modifier=Modifier){
        Row(modifier) {

        }
    }

    //Sixieme page
    @Composable
    fun carteVisite(modifier: Modifier=Modifier){

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp // Largeur en dp
        val screenHeight = configuration.screenHeightDp

        Column(modifier.background(Color(0xFF75d2ac))) {
            Row(modifier = Modifier
                .height((screenHeight * 0.7).dp) ) {
                Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier
                            .width(100.dp)
                            .height(100.dp)
                            .background(Color(0xFF110047))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.android_logo),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                        )
                    }
                    Text(text = stringResource(R.string.carteTitle) ,
                        fontSize = 40.sp, fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )

                    Text(text = stringResource(R.string.carteContent) ,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF118200)
                    )
                }
            }
            Row(modifier = Modifier
                .height((screenHeight * 0.3).dp) ) {
                Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(
                        modifier
                            .padding(0.dp, 0.dp, 0.dp, 20.dp)
                            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Icon(
                            Icons.Rounded.Phone, contentDescription = "Localized description",
                            modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                        Text(text = "+11 (123) 444 555 666")
                    }
                    Row(modifier.padding(0.dp, 0.dp, 0.dp, 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Rounded.Share, contentDescription = "Localized description",
                            modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                        Text(text = "https://github.com/KenneDany")
                    }
                    Row(modifier.padding(0.dp, 0.dp, 0.dp, 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Icon(Icons.Rounded.Email, contentDescription = "Localized description",
                            modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                        Text(text = "kennedany4@gmail.com")
                    }
                }
            }
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
        Article()
    }
    }
}
