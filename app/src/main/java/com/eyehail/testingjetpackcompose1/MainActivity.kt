package com.eyehail.testingjetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eyehail.testingjetpackcompose1.ui.theme.TestingJetPackCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                   UsersApplication()

            }
        }
    }

@Composable
fun UsersApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen") {
            FirstScreen(navController)
        }
        composable("second_screen") {
           SecondScreen()
        }
    }
}


@Composable
fun FirstScreen(navController: NavHostController) {
    Surface(modifier = Modifier
        .fillMaxSize(),
    )
    {
       Column(modifier = Modifier
           .fillMaxWidth()
           .absolutePadding(top = 20.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Top) {
            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") }
            )
           Text("Copied: " + text)
           Button(onClick = { navController?.navigate("second_screen") }) {

           }

        }
    }
}

@Composable
fun SecondScreen() {
    Surface(modifier = Modifier
        .fillMaxSize(),
    )
    {
        Column(modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") }
            )
            Text("Copied: " + text)

           /* Button(onClick = { *//*TODO*//* }) {
            }*/
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestingJetPackCompose1Theme {
        UsersApplication()
    }
}