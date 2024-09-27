package com.example.testapp1

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testapp1.ui.theme.TestApp1Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }

            }
    }
}
    /*Atelier 1 : jour 2*/
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

    //Atelier 1 : jour 2
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

    // Atelier 2 : jours 3
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

    //Devoir
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

    //Atelier 3 jour 4
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

    //Devoir
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
     //Devoir
    @Composable
    fun contactFooter(icon : Image, text : String, modifier: Modifier=Modifier){
        Row(modifier) {

        }
    }

    //Atelier 4 : jour 5
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


    //Devoir
    @Composable
    fun DiceWithButtonAndImage(modifier : Modifier = Modifier){
        var result by remember { mutableStateOf(1) }
        val imageResource = when (result){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString()
            )
            Spacer(modifier.height(16.dp))

            Button( onClick = { result = (1..6).random()}) {
                Text(text = stringResource(R.string.roll))
            }
        }
    }

    //Atelier 5 : jour 6
    @Composable
    fun TipTimeLayout() {
        var amountInput by remember { mutableStateOf("") }
        var tipInput by remember { mutableStateOf("") }
        var roundUp by remember { mutableStateOf(false) }

        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount, tipPercent, roundUp)

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )
            EditNumberField(
                label = R.string.bill_amount,
                leadingIcon = R.drawable.money,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = amountInput,
                onValueChanged = { amountInput = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            )
            EditNumberField(
                label = R.string.how_was_the_service,
                leadingIcon = R.drawable.percent,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                value = tipInput,
                onValueChanged = { tipInput = it },
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            )
            RoundTheTipRow(
                roundUp = roundUp,
                onRoundUpChanged = { roundUp = it },
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Text(
                text = stringResource(R.string.tip_amount, tip),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EditNumberField(
        @StringRes label: Int,
        @DrawableRes leadingIcon: Int,
        keyboardOptions: KeyboardOptions,
        value: String,
        onValueChanged: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = value,
            singleLine = true,
            leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
            modifier = modifier,
            onValueChange = onValueChanged,
            label = { Text(stringResource(label)) },
            keyboardOptions = keyboardOptions
        )
    }

    @Composable
    fun RoundTheTipRow(
        roundUp: Boolean,
        onRoundUpChanged: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.round_up_tip))
            Switch(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                checked = roundUp,
                onCheckedChange = onRoundUpChanged
            )
        }
    }

    /**
     * Calculates the tip based on the user input and format the tip amount
     */
    private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }


    //Devoir
    fun GalerieArtSpace(){

    }

    @Preview
    @Composable
    fun DiceRollerApp() {

    }

}
