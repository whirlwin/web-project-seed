package com.whirlwin.example.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Repository

@Repository
class ExampleRepositoryImpl implements ExampleRepository {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    @Cacheable("example-cache")
    List<User> findUsers() {
        mongoOperations.findAll User.class
    }

    @Override
    def insertUser(User user) {
        mongoOperations.insert user
    }

}
