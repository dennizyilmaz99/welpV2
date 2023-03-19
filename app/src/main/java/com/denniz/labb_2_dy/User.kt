package com.denniz.labb_2_dy

class UserSignin (
    var username: String = "",
    var password: String = "",
){
    override fun toString(): String {
        return "Users(username='$username', password='$password'"
    }
}