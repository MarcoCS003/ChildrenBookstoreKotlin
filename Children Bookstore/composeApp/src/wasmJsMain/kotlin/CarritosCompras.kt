import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.libroElmounstrodec
import childrenbookstore.composeapp.generated.resources.libroLavuelvaalmun
import childrenbookstore.composeapp.generated.resources.libroMartinaconvis
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun CarroComprasApp() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(Res.drawable.carritoTitulo),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                librosSeleccionados()
                ResumenCompra()
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun librosSeleccionados() {
    val listaLibrosSeleccionados = listOf(
        Libro(
            nome = "La vuelta al mundo en 80 días",
            categoria = listOf("Todo", "Aventura", "Aprendizaje"),
            precio = "14.99",
            image = painterResource(Res.drawable.libroLavuelvaalmun)
        ),
        Libro(
            nome = "Martina con vistas al mar",
            categoria = listOf("Todo", "Amistad", "Familia"),
            precio = "9.50",
            image = painterResource(Res.drawable.libroMartinaconvis)
        ),
        Libro(
            nome = "El monstruo de colores",
            categoria = listOf("Todo", "Emociones", "Aprendizaje"),
            precio = "8.99",
            image = painterResource(Res.drawable.libroElmounstrodec)
        )

    )
    LazyColumn {
        items(listaLibrosSeleccionados) { libro ->
            VistaCarritoLibro(libro)
        }
    }
}

@Composable
fun VistaCarritoLibro(book: Libro) {
    var valueChange by remember { mutableStateOf(1) }
    var showWarning by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.width(750.dp).height(120.dp).padding(end = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(book.image, null, modifier = Modifier.size(80.dp),)
        Text(book.nome, fontSize = 18.sp, modifier = Modifier.width(300.dp))
        Text("$${book.precio}", fontSize = 18.sp)
        Row {
            IconButton(onClick = { valueChange++ }) {
                Icon(imageVector = Icons.Default.Add, null)
            }
            OutlinedTextField(
                value = valueChange.toString(),
                onValueChange = {},
                modifier = Modifier.width(90.dp).height(55.dp),
                readOnly = false,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text("Cantidad") }
            )
            IconButton(onClick = { valueChange-- }) {
                Icon(imageVector = Icons.Default.Clear, null)
            }
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Delete, null)
        }
        var numero = (book.precio.toDouble()*100)/100.0
        Text("$${numero}")
    }

}

@Composable
fun ResumenCompra(productos: Double = 235.00) {
    Column(modifier = Modifier.width(250.dp).height(300.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Column(Modifier.fillMaxWidth()) {
            Text("Resumen de compra", fontSize = 20.sp, modifier = Modifier.padding(bottom = 20.dp))
            Row (modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Productos")
                Text(productos.toString())
            }
            Row (modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Envio")
                Text("$90.00")
            }
            Row (modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Total",  fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("${productos+80.00}",fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar Compra", color = Color.White)
        }
    }
}