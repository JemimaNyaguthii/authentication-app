package com.example.authentication

sealed class Routes(val route: String) {
     object SignUp :Routes("SignUp")
     object Login : Routes("Login")
}