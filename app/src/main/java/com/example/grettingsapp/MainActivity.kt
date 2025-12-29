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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyAppBar() },
                    bottomBar = { MyBottomAppBar() },
                    floatingActionButton = { MyFloatingActionButton() })

                { innerPadding ->

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
                alpha = 0.5f,
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
                    textStyle = TextStyle(color = Color.White, fontSize = 30.sp),
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
                    Text(
                        "Allow Button", style = TextStyle(fontSize = 30.sp)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(
                "Greetings App",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Green,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.baseline_menu_24),
                    contentDescription = "iconButton",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
        }

    )
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(containerColor = Color.Green, contentColor = Color.White) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.baseline_home_24),
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painterResource(R.drawable.baseline_info_24),
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )

            }
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = {}, shape = CircleShape, containerColor = Color.Green) {
        Icon(
            painterResource(R.drawable.baseline_add_24),
            contentDescription = "Simple Floating Action Button"
        )
    }
}