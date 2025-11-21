package com.example.ucp1.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(onLoginSuccess: () -> Unit) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Informasi") },
            text = { Text("Menyetujui syarat & ketentuan") }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Halaman Login")})
        }
    ){
    }
    Column(
            modifier = Modifier.padding(16.dp)
        ){

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        Spacer(modifier =
            Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Spacer(modifier =
            Modifier.height(8.dp))

        Row {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    if (it) showDialog = true
                }
            )
            Text("Setuju Syarat & Ketentuan")
        }

        Spacer(modifier =
            Modifier.height(16.dp))

        Button(
            onClick =
                { onLoginSuccess() },
            enabled = isChecked,
            modifier =
                Modifier.fillMaxWidth()
        ) {
            Text("LOGIN")
        }
    }
}

