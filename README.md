Web Project Seed
================

Have it JAR way

# Introduction
This is a small project for getting up to speed when creating a new web application from scratch using various
technologies. It consists of two modules; `web-app` and `integration-tests`.

## Technologies
The following is a listing of the major technologies used in order og relative significance.

1. [Groovy](http://groovy.codehaus.org/)
2. [Java (8)](https://jdk8.java.net/)
3. [Spring (4)](http://spring.io/)
3. [MongoDB](http://www.mongodb.org)
4. [Gradle](http://www.gradle.org/)
5. [Maven](http://maven.apache.org/)
6. [Node.js](http://nodejs.org/)
7. [Selenium](http://docs.seleniumhq.org/)
8. [gulp.js](http://gulpjs.com/)

# Local development
There are two ways of building and running the web application, both of which are listed below.

## Prerequisites

### Create the `env.json` file
Create an `env.json` file in the `web-app` module based on the following example `env.json` file:

    {
      "env":        "dev",
      "compressed": false
    }


Edit the file accordingly if need be.

### Install Node.js dependencies

1. Firstly, install gulp so it is available from the command line: `npm install -g gulp`

2. Secondly, install all other dependencies: `npm install` from the `web-app` module

## Building

### Maven
1. Build the project: `mvn clean install` from the `web-app` sub-module.
2. Deploy into a servlet container like Apache Tomcat

### Gradle
1. Build and start Jetty: `gradle jettyRunWar` from the `web-app` module

## Running integration tests

To run the integration tests run `mvn verify` from the `integration-tests` sub-module.
