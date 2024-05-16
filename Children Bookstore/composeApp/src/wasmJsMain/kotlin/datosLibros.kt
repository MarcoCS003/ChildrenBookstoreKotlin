import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.libroDondevivenmouns
import childrenbookstore.composeapp.generated.resources.libroElmer
import childrenbookstore.composeapp.generated.resources.libroPrincipitp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class Libro(
    val nome: String,
    val categoria: List<String>,
    val precio: String,
    val image: Painter
)

@Composable
fun ItemsBooks(categoria: String) {
    @OptIn(ExperimentalResourceApi::class)
    val librosParaNinos: List<Libro> = listOf(
        Libro(
            nome = "El Principito",
            categoria = listOf("Todo", "Fantasia", "Aprendizaje"),
            precio = "10.99f",
            image = painterResource(Res.drawable.libroPrincipitp)
        ),
        Libro(
            nome = "Donde viven los monstruos",
            categoria = listOf("Todo","Fantasia", "Aprendizaje"),
            precio = "9.99f",
            image = painterResource(Res.drawable.libroDondevivenmouns)
        ),
        Libro(
            nome = "Elmer",
            categoria = listOf("Todo","Amistad", "Animales"),
            precio = "8.50f",
            image = painterResource(Res.drawable.libroElmer)
        ),
        Libro(
            nome = "El libro de la selva",
            categoria = listOf("Todo","Animales", "Naturaleza", "Aprendizaje"),
            precio = "7.99f",
            image = painterResource(Res.drawable.libroEllibrodelasel)
        ),
        Libro(
            nome = "Cuentos de buenas noches para niñas rebeldes",
            categoria = listOf("Todo","Familia", "Aprendizaje"),
            precio = "15.00f",
            image = painterResource(Res.drawable.libroCuentosdebuenasn)
        ),
        Libro(
            nome = "Diario de Greg",
            categoria = listOf("Todo","Humor", "Familia", "Aprendizaje"),
            precio = " 11.50f",
            image = painterResource(Res.drawable.libroDiariodegref)
        ),
        Libro(
            nome = "El pez arcoíris",
            categoria = listOf("Todo","Naturaleza", "Aprendizaje"),
            precio = "6.99f",
            image = painterResource(Res.drawable.libroPezarcoiris)
        ),
        Libro(
            nome = "El gran libro de experimentos",
            categoria = listOf("Todo","Ciencia", "Aprendizaje"),
            precio = "12.99f",
            image = painterResource(Res.drawable.libroElgranlibrodeloex)
        ),
        Libro(
            nome = "La vuelta al mundo en 80 días",
            categoria = listOf("Todo","Aventura", "Aprendizaje"),
            precio = "14.99f",
            image = painterResource(Res.drawable.libroLavuelvaalmun)
        ),
        Libro(
            nome = "Martina con vistas al mar",
            categoria = listOf("Todo","Amistad", "Familia"),
            precio = "9.50f",
            image = painterResource(Res.drawable.libroMartinaconvis)
        ),
        Libro(
            nome = "El monstruo de colores",
            categoria = listOf("Todo","Emociones", "Aprendizaje"),
            precio = "8.99f",
            image = painterResource(Res.drawable.libroElmounstrodec)
        ),
        Libro(
            nome = "Pequeño cerdo capitalista",
            categoria = listOf("Todo","Educación financiera", "Aprendizaje"),
            precio = "13.50f",
            image = painterResource(Res.drawable.libroElpequecerdoc)
        ),
        Libro(
            nome = "Las princesas también se tiran pedos",
            categoria = listOf("Todo","Humor", "Familia"),
            precio = "10.50f",
            image = painterResource(Res.drawable.libroPrincesastambi)
        ),
        Libro(
            nome = "Matilda",
            categoria = listOf("Todo","Fantasia", "Aprendizaje"),
            precio = "11.99f",
            image = painterResource(Res.drawable.libroMatilda)
        ),
        Libro(
            nome = "El laberinto del fauno",
            categoria = listOf("Todo","Fantasia", "Aventura"),
            precio = "10.99f",
            image = painterResource(Res.drawable.libroEllaberintodelfa)
        ),
        Libro(
            nome = "¡Voy a comedte!",
            categoria = listOf("Todo","Humor", "Familia"),
            precio = "9.50f",
            image = painterResource(Res.drawable.libroVoyacomedte)
        ),
        Libro(
            nome = "Pinocho",
            categoria = listOf("Todo","Aventura", "Familia"),
            precio = "7.99f",
            image = painterResource(Res.drawable.libroPinocho)
        ),
        Libro(
            nome = "La pequeña oruga glotona",
            categoria = listOf("Todo","Naturaleza", "Aprendizaje"),
            precio = "6.99f",
            image = painterResource(Res.drawable.libroLapequelaoru)
        ),
        Libro(
            nome = "¡Buenas noches, Gorila!",
            categoria = listOf("Todo","Animales", "Familia"),
            precio = "8.99f",
            image = painterResource(Res.drawable.libroBuenasnochesgo)
        ),
        Libro(
            nome = "El pequeño vampiro",
            categoria = listOf("Todo","Fantasia", "Amistad"),
            precio = "9.99f",
            image = painterResource(Res.drawable.libroElpequevampi)
        ),
        Libro(
            nome = "La historia interminable",
            categoria = listOf("Todo","Fantasia", "Aventura"),
            precio = "12.50f",
            image = painterResource(Res.drawable.libroElgranlibrodeloex)
        ),
        Libro(
            nome = "Charlie y la fábrica de chocolate",
            categoria = listOf("Todo","Fantasia", "Aventura"),
            precio = "13.99f",
            image = painterResource(Res.drawable.libroCharlieylafabr)
        ),
        Libro(
            nome = "Cuentos de la selva",
            categoria = listOf("Todo","Animales", "Naturaleza"),
            precio = "$8.50f",
            image = painterResource(Res.drawable.libroCuentosdelase)
        ),
        Libro(
            nome = "El ratón de ciudad y el ratón de campo",
            categoria = listOf("Todo","Amistad", "Familia"),
            precio = "7.50f",
            image = painterResource(Res.drawable.libroRatondeCiudad)
        ),
        Libro(
            nome = "Las tres mellizas",
            categoria = listOf("Todo","Aventura", "Fantasia"),
            precio = "9.99f",
            image = painterResource(Res.drawable.libroLastresmelli)
        )
    )
    val listaMostrar = librosParaNinos.filter { libro -> categoria in libro.categoria  }
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 315.dp)) {
        items(listaMostrar) {
            BookView(it)
        }
    }
}

@Composable
fun BookView(libro: Libro) {
    Card(modifier = Modifier.padding(15.dp), backgroundColor = Color(0xFFd1f2eb)) {
        Row {
            Image(
                painter = libro.image,
                null,
                modifier = Modifier.size(height = 290.dp, width = 220.dp),
                Alignment.CenterStart
            )
            Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(10.dp).height(270.dp)) {
                Text(libro.nome, fontSize = 18.sp, color = Color(0xFF1b4f72))
                Text("$${libro.precio}", fontSize = 22.sp,  color = Color(0xFF1b4f72)
                )
                Button(onClick = {} , colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7))) {
                    Text("Comprar", color = Color.White)
                }
            }
        }
    }
}