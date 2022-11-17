package com.miguelromero717.integrationtestingapi.user

interface IUserService {

    fun getAllUsers(): List<User>

    fun getUserById(userId: Int): User?

    fun saveUser(userDTO: UserDTO): User

    fun editUser(userDTO: UserDTO, userId: Int): User

    fun deleteUser(userId: Int)
}
