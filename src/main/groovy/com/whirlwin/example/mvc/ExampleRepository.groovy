package com.whirlwin.example.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

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
