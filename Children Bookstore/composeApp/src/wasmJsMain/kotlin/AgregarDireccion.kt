import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.arrowBack
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AgregarDireccion() {
    var index by remember { mutableStateOf(1) }
    Box {
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = {
                if (index != 1) {
                    index--
                }
            }, modifier = Modifier.size(35.dp)) {
                Icon(painterResource(Res.drawable.arrowBack), null)
            }
        }

        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            FormularioDireccion(modifier = Modifier.width(450.dp))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxSize().padding(end = 15.dp, bottom = 15.dp),
        ) {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Info, null, tint = Color.White)
            }
        }
    }
}

@Composable
fun FormularioDireccion(modifier: Modifier) {
    var valueAddress by remember { mutableStateOf("") }
    var valueEstado by remember { mutableStateOf("") }
    var valueNumero by remember { mutableStateOf("") }
    var codigoPostal by remember { mutableStateOf("") }


    Column(modifier = modifier) {
        Text(
            "Agregar Dirección",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        OutlinedTextField(
            value = valueAddress,
            onValueChange = {
                valueAddress = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            label = { Text("Ingresa tu dirección ") },
        )
        OutlinedTextField(
            value = valueEstado,
            onValueChange = { valueEstado = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            label = { Text("Ingresa tu estado") }
        )
        Row {
            OutlinedTextField(
                value = valueNumero,
                onValueChange = {
                    valueNumero = it
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text("Número") },
            )
            OutlinedTextField(
                value = codigoPostal,
                onValueChange = {
                    codigoPostal = it
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text("Código Postal") }
            )
        }
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text("Continuar", color = Color.White)
        }
    }
}
