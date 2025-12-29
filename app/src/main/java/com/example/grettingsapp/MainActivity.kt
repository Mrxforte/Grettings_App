package com.example.grettingsapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grettingsapp.ui.theme.GrettingsAppTheme
import kotlinx.serialization.Contextual

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GrettingsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding), context = LocalContext.current)
                }
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier, context: Context) {
    var text by remember {
        mutableStateOf("")
    }
    var displayText by remember {
        mutableStateOf("Your text comes here")
    }
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Image",
                contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()

            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(displayText, style = TextStyle(fontSize = 30.sp, color = Color.White))
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    textStyle = TextStyle(color = Color.White),
                    value = text,
                    onValueChange = { newValue ->
                        text = newValue
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                FilledTonalButton(onClick = {
                    displayText = text
                    Toast.makeText(context, "$text is typed by user!", Toast.LENGTH_LONG).show()
                }) {
                    Text("Allow Button")
                }
            }
        }
    }
}
