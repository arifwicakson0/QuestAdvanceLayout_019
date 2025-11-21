package com.example.ucp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(onLogout: () -> Unit, onAdd: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Halaman Profile") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "profile",
                modifier = Modifier.size(120.dp)
            )

            Text("Nama: Nabil")
            Text("NIM: 1234567")
            Text("Kelas: TI-3A")

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Button(onClick = onLogout, modifier = Modifier.weight(1f)) {
                    Text("Logout")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = onAdd, modifier = Modifier.weight(1f)) {
                    Text("Tambah Presensi")
                }
            }
        }
    }
}