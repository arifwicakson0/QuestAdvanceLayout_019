package com.example.ucp1.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(onBack: () -> Unit) {

    var matakuliah by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var jam by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    onBack()
                }) { Text("IYA") }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) { Text("TIDAK") }
            },
            title = { Text("Validasi") },
            text = { Text("Data telah lengkap dan akan disimpan.") }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Form Tambah Presensi") })
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding).padding(16.dp)
        ) {

            OutlinedTextField(
                value = matakuliah,
                onValueChange = { matakuliah = it },
                label = { Text("Nama Mata Kuliah") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = kelas,
                onValueChange = { kelas = it },
                label = { Text("Kelas") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tanggal,
                onValueChange = { tanggal = it },
                label = { Text("Tanggal (minggu ini)") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = jam,
                onValueChange = { jam = it },
                label = { Text("Jam Presensi") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(onClick = { showDialog = true }, modifier = Modifier.weight(1f)) {
                    Text("ADD")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = onBack, modifier = Modifier.weight(1f)) {
                    Text("BACK")
                }
            }
        }
    }
}