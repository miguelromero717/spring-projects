package com.miguelromero717.integrationtestingapi.user

data class UserDTO(
    val name: String,
    val email: String,
    val age: Int,
    val role: UserRoles
)
