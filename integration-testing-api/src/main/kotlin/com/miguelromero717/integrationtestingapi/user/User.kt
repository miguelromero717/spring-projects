package com.miguelromero717.integrationtestingapi.user

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = 0,
    var name: String,
    var email: String,
    var age: Int,
    @Enumerated(EnumType.STRING)
    var role: UserRoles
)