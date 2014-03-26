package com.whirlwin.example.mvc

interface ExampleRepository {

    def insertUser(User user)

    List<User> findUsers()
}