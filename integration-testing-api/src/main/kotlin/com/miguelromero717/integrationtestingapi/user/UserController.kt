package com.miguelromero717.integrationtestingapi.user

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userService: IUserService
) {
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<User?> {
        return ResponseEntity.ok(
            userService.getUserById(
                userId = id
            )
        )
    }

    @PostMapping
    fun saveUser(
        @RequestBody @Validated payload: UserDTO
    ): ResponseEntity<User> {
        return ResponseEntity.ok(
            userService.saveUser(
                userDTO = payload
            )
        )
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Int,
        @RequestBody @Validated payload: UserDTO
    ): ResponseEntity<User> {
        return ResponseEntity.ok(
            userService.editUser(
                userDTO = payload,
                userId = id
            )
        )
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Int
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(
            userService.deleteUser(userId = id)
        )
    }
}
