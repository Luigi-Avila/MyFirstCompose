package com.example.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MyBox()
                    //MyRow()
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var counter by rememberSaveable { mutableStateOf(0) }
        Button(onClick = { counter += 1 }) {
            Text("Pulsar")
        }
        MySpacer(size = 10)
        Text("He sido pulsado $counter veces")
    }
}

@Composable
fun MyExercise() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), Alignment.Center
        ) {
            Text("Ejemplo 1")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red), Alignment.Center
            ) {
                Text("Ejemplo 2")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), Alignment.Center
            ) {
                Text("Ejemplo 3")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), Alignment.BottomCenter
        ) {
            Text("Ejemplo 4")
        }

    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        )
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red)
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text("Hola soy Luigi")
            }
        }
        MySpacer(size = 80)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        )

    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(
        modifier = Modifier
            .width(0.dp)
            .height(size.dp)
    )
}

@Composable
fun MyRow() {
    /*Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("Hola mundo 1")
        Text("Hola mundo 2")
        Text("Hola mundo 3")
    } */

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))
        Text("Hola mundo 1", modifier = Modifier.width(100.dp))

    }
}

@Composable
fun MyColumn() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text("Hola mundo")
        Text("Hola mundo2")
        Text("Hola mundo3")
        Text("Hola mundo4")
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Blue), contentAlignment = Alignment.Center
        ) {
            Text("Esto es un ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstComposeTheme {
        //MyBox()
        //MyColumn()
        //MyRow()
        //MyComplexLayout()
        //MyExercise()
        MyStateExample()
    }
}