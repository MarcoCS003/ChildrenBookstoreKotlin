@file:Suppress("UNUSED_EXPRESSION")

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
import childrenbookstore.composeapp.generated.resources.efectivo
import childrenbookstore.composeapp.generated.resources.tarjeta
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AgregarMetodoPagoApp() {
    var index by remember { mutableStateOf(1) }
    Box {
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = {if(index != 1){ index--} }, modifier = Modifier.size(35.dp)){
                Icon(painterResource(Res.drawable.arrowBack), null)
            }
        }
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            when(index){
                1 -> ComoPagar(modifier = Modifier.width(350.dp), {index = 2})
                2 -> FormularioTarjeta(modifier = Modifier.width(420.dp), {index = 3})
                else -> ""
            }
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

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ComoPagar(modifier: Modifier, onClick: () -> Unit) {
    Column(modifier) {
        Text("¿Cómo quieres pagar?", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 20.dp))
        Row (modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            RadioButton(selected = false, onClick = {})
            Text("Tarjeta de crédito", fontSize = 20.sp)
            Icon(painterResource(Res.drawable.tarjeta), null, modifier = Modifier.size(30.dp))
        }
        Row (modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            RadioButton(selected = true, onClick = {})
            Text("Tarjeta de débito", fontSize = 20.sp)
            Icon(painterResource(Res.drawable.tarjeta), null, modifier = Modifier.size(30.dp))
        }
        Row (modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            RadioButton(selected = false, onClick = {})
            Text("Efectivo", fontSize = 20.sp)
            Icon(painterResource(Res.drawable.efectivo), null, modifier = Modifier.size(30.dp))
        }
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7)),
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        ) {
            Text("Continuar Compra", color = Color.White)
        }
    }
}

@Composable
fun FormularioTarjeta(modifier: Modifier, onClick: () -> Unit) {
    var valueNumber by remember { mutableStateOf("") }
    var valueNombre by remember { mutableStateOf("") }
    var valueFecha by remember { mutableStateOf("") }
    var codigoSeguridad by remember { mutableStateOf("") }
    var showNumberError by remember { mutableStateOf(false) }
    var showFechaError by remember { mutableStateOf(false) }

    fun validateInputs() {
        showNumberError = valueNumber.length != 16
        showFechaError = !valueFecha.matches(Regex("\\d{2}/\\d{2}"))
    }

    Column(modifier = modifier) {
        Text(
            "Tarjeta de débito",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        OutlinedTextField(
            value = valueNumber,
            onValueChange = {
                valueNumber = it.filter { char -> char.isDigit() }.take(16)
                showNumberError = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            label = { Text("Número de tarjeta") },
            isError = showNumberError
        )
        if (showNumberError) {
            Text(
                "El número de tarjeta debe tener 16 caracteres.",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        OutlinedTextField(
            value = valueNombre,
            onValueChange = { valueNombre = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            label = { Text("Nombre y apellido") }
        )
        Row {
            OutlinedTextField(
                value = valueFecha,
                onValueChange = {
                    if (it.length <= 5) {
                        valueFecha = it.filter { char -> char.isDigit() || char == '/' }
                        if (it.length == 2 && !it.contains("/")) {
                            valueFecha = "$it/"
                        }
                    }
                    showFechaError = false
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text("Fecha de vencimiento") },
                isError = showFechaError
            )
            if (showFechaError) {
                Text(
                    "Fecha no válida. Use MM/AA.",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            OutlinedTextField(
                value = codigoSeguridad,
                onValueChange = {
                    codigoSeguridad = it.filter { char -> char.isDigit() }.take(3)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                label = { Text("Código de seguridad") }
            )
        }
        Button(
            onClick = {
                validateInputs()
                if (!showNumberError && !showFechaError) {
                    onClick()
                }
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
