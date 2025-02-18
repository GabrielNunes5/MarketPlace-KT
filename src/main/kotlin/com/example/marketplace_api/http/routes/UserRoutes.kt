package com.example.marketplace_api.http.routes

import com.example.marketplace_api.http.controller.UserController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions
import org.springframework.web.servlet.function.ServerResponse

@Configuration
class UserRoutes{

    @Bean
    fun userRouter(userController: UserController) : RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/users", userController::createUser)
            .GET("/users", userController::getUsers)
            .GET("/users/email/{email}", userController::getUserByEmail)
            .GET("/users/{id}", userController::getUserById)
            .PUT("/users/{id}", userController::updateUserById)
            .DELETE("/users/{id}", userController::deleteUserById)
            .build()
    }
}