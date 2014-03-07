package com.whirlwin.whirlwin.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

class User {
    def name
    def age
}

@Repository
class ExampleRepository {

    @Autowired
    private MongoOperations mongoOperations;

    def insertSomeUser() {
        def user = new User(name: 'John Doe', age: 21)
        mongoOperations.insert(user)
    }

    def findUsers() {
        mongoOperations.findAll(User.class)
    }
}
