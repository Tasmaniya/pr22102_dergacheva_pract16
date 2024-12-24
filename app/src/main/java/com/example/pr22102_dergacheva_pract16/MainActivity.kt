package com.example.pr22102_dergacheva_pract16

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pr22102_dergacheva_pract16.ui.theme.Pr22102_dergacheva_pract16Theme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pr22102_dergacheva_pract16Theme {
                AppNavigation()

            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "SplashScreen") {
        composable(route = "SplashScreen") { SplashScreen(navController) }
        composable(route = "Onboarding") { Onboarding(navController) }
        composable(route = "Login") { Login(navController) }
        composable(route = "Main") { Main(navController) }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate("Onboarding")
    }
    Box(
        modifier = Modifier
            .fillMaxSize() // Заполняем весь доступный размер
            .clip(RectangleShape) // Можно обрезать по желанию
    ) {
        Image(
            painter = painterResource(id = R.drawable.fon),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Устанавливаем масштабирование
            modifier = Modifier
                .align(Alignment.TopStart) // Выравниваем по верхнему левому углу
                .fillMaxHeight() // Заполняем высоту

        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
//            contentScale = ContentScale.Crop, // Устанавливаем масштабирование
            modifier = Modifier
                .align(Alignment.Center) // Выравниваем по верхнему левому углу
                .size(600.dp)

        )
    }

}
@Composable
fun Onboarding(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize() // Заполняем весь доступный размер
            .clip(RectangleShape) // Можно обрезать по желанию   background: #253334;

    ) {
        Image(
            painter = painterResource(id = R.drawable.fon),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Устанавливаем масштабирование
            modifier = Modifier
                .align(Alignment.TopStart) // Выравниваем по верхнему левому углу
                .fillMaxHeight() // Заполняем высоту

        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
//            contentScale = ContentScale.Crop, // Устанавливаем масштабирование
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(600.dp)

        )

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 400.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Привет",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Наслаждайся отборочными.\nБудь внимателен.\nДелай хорошо.",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 24.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("Login")},
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(red = 0x7c, green = 0x9a, blue = 0x92, alpha = 0xFF)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = 8.dp),

            ) {
            Text("Войти в аккаунт")
        }
        TextButton(
            onClick = {}
        ) {
            Text("Еще нет аккаунта? Зарегистрируйтесь", color = Color.White)
        }
    }

}
@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isMenuOpen by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E3C38))
            .padding(start = 15.dp,end=15.dp), // Цвет фона
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Иконка сверху
            Icon(
                painter = painterResource(id = R.drawable.logo), // Поставьте здесь нужную иконку
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp).align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Текст "Sign in"
            Text(
                text = "Sign in",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Поле Email
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF),//#BEC2C2
                    focusedContainerColor = Color.Transparent,
                    focusedTextColor = Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF),),
            )

            //Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()

                    .height(2.dp) // Высота линии
                    .background(Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF)) // Цвет линии
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Поле Пароль
            TextField(

                value = password,
                onValueChange = { password = it },
                label = { Text("Пароль") },
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedTextColor = Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF),//#BEC2C2
                    focusedContainerColor = Color.Transparent,
                    focusedTextColor = Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF),),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp) // Высота линии
                    .background(Color(red = 0xbe, green = 0xc2, blue = 0xc2, alpha = 0xFF)) // Цвет линии
            )

            Spacer(modifier = Modifier.height(16.dp))


            // Кнопка Sign In
            var errorMessage by remember { mutableStateOf("") }
            Button(
                onClick = {
                    navController.navigate("Main")
//                    if (email.isEmpty() || password.isEmpty()) {
//                        errorMessage = "Пожалуйста, заполните все поля."
//                    } else {
//                        errorMessage = ""
//                        navController.navigate("Main")
//                    }
                },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = Color(red = 0x7c, green = 0x9a, blue = 0x92, alpha = 0xFF))

            ) {
                Text(text = "Sign in", )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Текст для регистрации
            ClickableText(
                text = AnnotatedString("Register"),
                onClick = {
                    navController.navigate("Main")
//                    if (email.isEmpty() || password.isEmpty()) {
//                    errorMessage = "Пожалуйста, заполните все поля."
//                        navController.navigate("Main")
//                    } else {
//                    errorMessage = ""
//                    navController.navigate("Main")
//                    }
                },
                modifier = Modifier.align(Alignment.Start),
                style = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
// Кнопка Профиль
            Button(
                onClick = { if (email.isEmpty() || password.isEmpty()) {

                } else {

                    navController.navigate("Main")
                } },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = Color(red = 0x7c, green = 0x9a, blue = 0x92, alpha = 0xFF))
            ) {
                Text(text = "Профиль")
            }
        }

    }
    Box(modifier = Modifier.fillMaxSize()){
        Icon(
            painter = painterResource(id = R.drawable.list), // Поставьте здесь нужную иконку
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.fillMaxWidth().padding(bottom = 0.dp).align(Alignment.BottomCenter)
        )
    }
}
@Composable
fun Main(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF253334)).padding(16.dp)) {
        Box(modifier = Modifier.fillMaxWidth().padding(top=200.dp), contentAlignment = Alignment.Center) {
            Text(text = "С возвращением, Эмиль!", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "Каким ты себя ощущаешь сегодня?", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(top=50.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Img(imageId = R.drawable.a, "Спокойным")
            Spacer(modifier = Modifier.width(8.dp))
            Img(imageId = R.drawable.b, "Расслабленным")
            Spacer(modifier = Modifier.width(8.dp))
            Img(imageId = R.drawable.c, "Сосредоточенным")
            Spacer(modifier = Modifier.width(8.dp))
            Img(imageId = R.drawable.d, "Взволнованным")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                ContentBlock(title = "Заголовок блока", description = "Кратенкое описание блока с двумя строчками", imageId = R.drawable.aa)
                Spacer(modifier = Modifier.height(16.dp))
                ContentBlock(title = "Заголовок блока", description = "Кратенкое описание блока с двумя строчками", imageId = R.drawable.bb)
            }
        }
    }
}
@Composable
fun Img(imageId: Int, title: String){
    Column (){
        Card(
            modifier = Modifier

                .padding(16.dp), // Отступы вокруг карточки
            colors = CardDefaults.cardColors(containerColor = Color.White)

        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /* Handle click */ },
                tint = Color.White,
                painter = painterResource(id = imageId),
                contentDescription = title,

                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Взволнованным",
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )}

}
@Composable
fun ContentBlock(title: String, description: String, imageId: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFF2B2B2B))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(red = 25, green = 33, blue = 34)
                    //#253334
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color(red = 25, green = 33, blue = 34)
                )
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                ) {
                    Text(text = "подробнее", color = Color(red = 25, green = 33, blue = 34))
                }
            }
        }
    }
}