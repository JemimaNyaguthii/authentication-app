package com.example.authentication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.authentication.Routes

@Composable
fun LoginPage(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 56.dp, 15.dp, 15.dp)
    )
    {
        val username = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        var rememberMe by remember { mutableStateOf(false) }
        Text(
            text = "Sign In",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Username", style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Serif))
        OutlinedTextField(
            label = { Text(text = "Your username") },
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Password", style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Serif))
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
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { isChecked ->
                        rememberMe = isChecked

                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Magenta
                    )
                )
                Text(
                    text = "Remember me",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
            ClickableText(
                text = AnnotatedString("Forgot password?"),
                onClick = { },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    navController.navigate(Routes.SignUp.route)
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                )
            ) {
                Text(
                    text = "Sign In",
                    style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account? ",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )
            )

            ClickableText(
                text = AnnotatedString(text = "Sign up"),
                onClick = {
                    navController.navigate(Routes.SignUp.route)
                },
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Magenta,
                   textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}
