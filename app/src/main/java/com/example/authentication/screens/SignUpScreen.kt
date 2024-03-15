package com.example.authentication.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.authentication.Routes

@Composable
fun SignUpPage(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 56.dp,15.dp,15.dp)
    )
    {
        val username = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }


        Text(text = "Create account", style = TextStyle(fontSize = 30.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.Black))

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Username", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Your username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(26.dp))
        Text(text = "Email", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Your email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(text = "Password", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
            OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Your password") },
            modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Show/Hide password"
                        )
                    }
                }
            )
        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if (username.value.isEmpty() || email.value.isEmpty() || password.value.isEmpty()) {
                        return@Button
                    }
                    navController.navigate(Routes.Login.route)
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                )
            ) {
                Text("Sign Up", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
//        ClickableText(
//            text = AnnotatedString("Forgot password?"),
//            onClick = { },
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontFamily = FontFamily.Serif
//            )
//        )
    }
    }

