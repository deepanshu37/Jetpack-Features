package com.example.jetpackfeatures

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.AndroidPaint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackfeatures.ui.theme.JetpackFeaturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Used a basic column to display all elements vertically
            Column {
                Text(text = "\n⬆️This is how data is generally displayed:")
                //Data is at the end but still shown on top

                Text(text = "\nThis is how columns display data:")
                Column {
                    Text(text = "Text 1")
                    Text(text = "Text 2")
                    Text(text = "Text 3")
                }

                val painter = painterResource(id = R.drawable.ic_launcher_foreground)
                val description = "The Description"
                val title = "The titles"
                Box(modifier = Modifier.fillMaxWidth(0.5f))
                {
                    Image_Card(
                        painter = painter,
                        contentDescription = description,
                        title = title)
                }

/*                Text(text = "\nColumns Aligned Center Horizontally:")
                Column(modifier = Modifier  //Modifier is used to modify the appearance, layout and size of the element
                    *//*.fillMaxSize()*//*
                    .fillMaxHeight(0.5F)
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .border(5.dp, Color.Black)
                    .padding(top = 40.dp)
                    .border(5.dp, Color.Yellow)
                    .background(Color.Green),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Text 1")
                    Text(text = "Text 2")
                    Text(text = "Text 3")
                }*/

                Text(text = "\nThis is how rows display data:")
                //Row will display horizontally aligned
                Row {
                    Text(text = "Text 1")
                    Text(text = "Text 2")
                    Text(text = "Text 3")
                }

            //Steps to add a new kotlin new kotlin+JDBC activity:
            //Click inside 'Java' > right click on folder > Click on 'New' > 'Activity' > 'Gallery'
                //Opening a new activity named 'SecondActivity' on button click
                Button(onClick = {
                    val navigate = Intent(this@MainActivity,SecondActivity::class.java)
                    startActivity(navigate)}) {

                    Text(text = "Display Image")
                }

                //Opening a new activity named 'InternalStateChange' on button click
                Button(onClick = {
                    val navigate = Intent(this@MainActivity,InternalStateChange::class.java)
                    startActivity(navigate)}) {

                    Text(text = "Internal State Change")
                }

                //Opening a new activity named 'ExternalStateChange' on button click
                Button(onClick = {
                    val navigate = Intent(this@MainActivity,ExternalStateChange::class.java)
                    startActivity(navigate)}) {
                    Text(text = "External State Change")
                }

                //Opening a new activity named 'TextFieldsSnackBars' on button click
                Button(onClick = {
                    val navigate = Intent(this@MainActivity,TextFieldsSnackBars::class.java)
                    startActivity(navigate)}) {
                    Text(text = "Text Fields SnackBars")
                }
            }
            Text(text = "Text 1")
            Text(text = "Text 2")
            Text(text = "Text 3")
        }
    }
}

@Composable
fun Image_Card(
    painter: Painter,    //Allows us to use image from Image folder
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        /*elevation = 5.dp*/
    ){
        Box(modifier = Modifier.height(200.dp)){    //Each item wil be stacked on top of each other instead of displaying in rows or columns
            Image(
                painter = painter,
                contentDescription = contentDescription
                /*contentScale = ContentScale.crop*/
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)) {
                Column {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                    Text(
                        contentDescription,
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                }
            }
        }
    }
}
