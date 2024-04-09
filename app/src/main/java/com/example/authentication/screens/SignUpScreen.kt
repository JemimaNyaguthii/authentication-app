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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.authentication.Routes

@Composable
fun SignUpPage(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 56.dp, 15.dp, 15.dp)
    )
    {
        val username = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        var rememberMe by remember { mutableStateOf(false) }

        var usernameError by remember { mutableStateOf("") }
        var passwordError by remember { mutableStateOf("") }
        var emailError by remember { mutableStateOf("") }


        Text(text = "Create account", style = TextStyle(fontSize = 30.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.Black))

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Username", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
        Column {
            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it
                    usernameError = if (it.isEmpty()) "Username is required" else ""
                },
                label = { Text("Your username") },
                modifier = Modifier.fillMaxWidth(),
                isError = usernameError.isNotEmpty(),
                singleLine = true
            )
            Text(
                text = usernameError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Email", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
        Column {
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                    emailError = if (it.isEmpty()) "Email is required" else ""
                },
                label = { Text("Your email") },
                modifier = Modifier.fillMaxWidth(),
                isError = emailError.isNotEmpty(),
                singleLine = true
            )
            Text(
                text = emailError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Password", style = TextStyle(fontSize =15.sp , fontFamily = FontFamily.Serif))
        Column {
            OutlinedTextField(
                value = password.value,
                onValueChange = { newValue ->
                    password.value = newValue
                    passwordError = if (newValue.isEmpty()) {
                        "Password is required"
                    } else if (!newValue.any { it.isDigit() } || !newValue.any { it.isLetter() }) {
                        "Password must contain both letters and numbers"
                    } else {
                        ""
                    }
                },
                label = { Text("Your password") },
                isError = passwordError.isNotEmpty(),
                singleLine = true,
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
            Text(
                text = passwordError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        )
            {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { isChecked ->
                        rememberMe = isChecked
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Magenta
                    ),
                )
                Text(
                    text = "I accept the terms and privacy policy",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {
                        var hasError = false
                        if (username.value.isEmpty()) {
                            usernameError = "Username is required"
                            hasError = true
                        } else {
                            usernameError = ""
                        }
                        if (email.value.isEmpty()) {
                            emailError = "Email is required"
                            hasError = true
                        } else {
                            emailError = ""
                        }
                        if (password.value.isEmpty()) {
                            passwordError = "Password is required"
                            hasError = true
                        } else {
                            passwordError = ""
                        }
                        if (hasError) {
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
                    Text(
                        "Sign Up",
                        style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
                    )
                }
            }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account? ",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif
                )
            )

            ClickableText(
                text = AnnotatedString(text = "Log in"),
                onClick = {
                    navController.navigate(Routes.Login.route)
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


