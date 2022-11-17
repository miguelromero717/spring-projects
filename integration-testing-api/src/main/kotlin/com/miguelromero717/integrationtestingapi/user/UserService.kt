package com.miguelromero717.integrationtestingapi.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) : IUserService {

    override fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUserById(userId: Int): User? {
        return userRepository.findById(userId).get()
    }

    override fun saveUser(userDTO: UserDTO): User {
        val user = User(
            name = userDTO.name,
            email = userDTO.email,
            age = userDTO.age,
            role = userDTO.role
        )
        return userRepository.saveAndFlush(user)
    }

    override fun editUser(userDTO: UserDTO, userId: Int): User {
        val userEdit = userRepository.findById(userId).get()

        userEdit.email = userDTO.email
        userEdit.age = userDTO.age
        userEdit.name = userDTO.name
        userEdit.role = userDTO.role

        return userRepository.saveAndFlush(userEdit)
    }

    override fun deleteUser(userId: Int) {
        return userRepository.deleteById(userId)
    }
}