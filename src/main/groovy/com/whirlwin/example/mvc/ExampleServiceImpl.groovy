package com.whirlwin.example.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository

    @Autowired
    ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository
    }

    @Override
    def insertUser(User user) {
        exampleRepository.insertUser user
    }

    @Override
    List<User> findUsers() {
        exampleRepository.findUsers()
    }
}
