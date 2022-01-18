package com.akshayashokcode.ktorpushnotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshayashokcode.ktorpushnotification.data.remote.ApiServiceImpl
import com.akshayashokcode.ktorpushnotification.ui.theme.KtorPushNotificationTheme
import io.ktor.client.*
import io.ktor.client.engine.android.*
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    private val client= HttpClient(Android)
    private val service=ApiServiceImpl(client)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorPushNotificationTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    val scope= rememberCoroutineScope()
                    var title by remember {
                        mutableStateOf("")
                    }
                    var description by remember {
                        mutableStateOf("")
                    }
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text("Title")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = {
                            Text("Description")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                service.sendNotification(
                                    title = title,
                                    description = description
                                )
                            }

                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Send")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KtorPushNotificationTheme {
        Greeting("Android")
    }
}