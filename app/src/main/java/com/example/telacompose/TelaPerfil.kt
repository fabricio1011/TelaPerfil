package com.example.telacompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

data class Ocorrencia(val urlImagem: String)

val listaOcorrencias = listOf(
    Ocorrencia("https://via.placeholder.com/150/0000FF"),
    Ocorrencia("https://via.placeholder.com/150/FF0000"),
    Ocorrencia("https://via.placeholder.com/150/00FF00"),
    Ocorrencia("https://via.placeholder.com/150/FFFF00"),
    Ocorrencia("https://via.placeholder.com/150/FF00FF"),
    Ocorrencia("https://via.placeholder.com/150/00FFFF")
)

@Composable
fun TelaPerfil() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar", tint = Color.White)

                var textoBusca by remember { mutableStateOf("") }

                TextField(
                    value = textoBusca,
                    onValueChange = { textoBusca = it },
                    placeholder = { Text("Buscar") },
                    singleLine = true,
                    trailingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Buscar")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                )

                Icon(Icons.Default.AccountCircle, contentDescription = "Perfil", tint = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Avatar + Botão
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { /* ação de editar */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                ) {
                    Text("Editar Perfil", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Ocorrências", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listaOcorrencias) { item ->
                    Box {
                        Image(
                            painter = rememberImagePainter(item.urlImagem),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(6.dp)
                                .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TelaPerfilPreview() {
    TelaPerfil()
}
