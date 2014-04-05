package com.whirlwin.example.config

import com.mongodb.Mongo
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories
class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        "example-db"
    }

    @Override
    Mongo mongo() throws Exception {
        new Mongo()
    }
}
