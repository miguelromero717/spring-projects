package com.miguelromero717.integrationtestingapi.integration

import com.miguelromero717.integrationtestingapi.user.User
import com.miguelromero717.integrationtestingapi.user.UserRepository
import com.miguelromero717.integrationtestingapi.user.UserRoles
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.jdbc.Sql
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.UUID
import kotlin.random.Random

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest(
    @Autowired
    private val userRepository: UserRepository
) {

    @LocalServerPort
    private val port: Int = 0

    private val baseUrl = StringBuilder("http://localhost")

    private val totalTestUsers = 5;

    private val restTemplate: RestTemplate = RestTemplate()

    @BeforeEach
    fun setUp() {
        baseUrl.append(":$port").append("/v1/users")
    }

    @Test
    @Sql("/create-users.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql("/delete-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun `test get all users ok`() {
        val users : Array<User>? = restTemplate.getForObject(baseUrl.toString(), Array<User>::class)
        assertEquals(totalTestUsers, users?.size)
        assertTrue(users?.any { it.name.contains("Miguel Test 1") } == true)
    }

    @Test
    @Sql("/create-users.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql("/delete-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun `test get user by id`() {
        val user : User = restTemplate.getForObject(baseUrl.append("/1").toString(), User::class)
        assertEquals(1, user.id)
    }

    @Test
    @Sql("/delete-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun `test add user`() {
        val user = User(
            name = UUID.randomUUID().toString(),
            email = "${UUID.randomUUID()}@email.com",
            age = Random.nextInt(99),
            role = UserRoles.ADMIN
        )
        val response : User? = restTemplate.postForObject(baseUrl.toString(), user, User::class.java)

        assertEquals(user.name, response?.name)
        assertEquals(user.email, response?.email)
        assertEquals(user.age, response?.age)
        assertEquals(user.role, response?.role)
    }

    @Test
    @Sql("/create-users.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql("/delete-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun `test edit user`() {
        val userEdit = User(
            name = UUID.randomUUID().toString(),
            email = "${UUID.randomUUID()}@email.com",
            age = Random.nextInt(99),
            role = UserRoles.ADMIN
        )

        restTemplate.put(baseUrl.append("/{id}").toString(), userEdit, 3)

        val response = userRepository.findById(3).get()

        assertEquals(userEdit.name, response.name)
        assertEquals(userEdit.email, response.email)
        assertEquals(userEdit.age, response.age)
        assertEquals(userEdit.role, response.role)
    }

    @Test
    @Sql("/create-users.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql("/delete-users.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun `test delete user`() {
        val countUsers = userRepository.findAll().size
        val idToDelete = 5
        assertEquals(totalTestUsers, countUsers)
        restTemplate.delete(baseUrl.append("/{id}").toString(), idToDelete)
        assertEquals((totalTestUsers - 1), userRepository.findAll().size)
        assertTrue(userRepository.findById(idToDelete).isEmpty)
    }
}
