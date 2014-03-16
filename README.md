Web Project Seed
=============

Have it JAR way

# Introduction
This is a small project for getting up to speed when creating a new web application from scratch using various
technologies.

## Technologies
The following is a listing of the major technologies used in order og relative significance.

1. [Groovy](http://groovy.codehaus.org/)
2. [Java (8)](https://jdk8.java.net/)
3. [Spring (4)](http://spring.io/)
3. [MongoDB](http://www.mongodb.org)
4. [Gradle](http://www.gradle.org/)
5. [Maven](http://maven.apache.org/)
6. [Node.js](http://nodejs.org/)
6. [gulp.js](http://gulpjs.com/)

# Local development
There are two ways of building and running the web application, both of which are listed below.

## Prerequisites


### Create the `env.json` file
Create an `env.json` file in the project root based on the following example `env.json` file:

    {
      "env":        "dev",
      "compressed": false
    }


Edit the file accordingly if need be.

### Install Node.js dependencies

1. Firstly, install gulp so it is available from the command line: `npm install -g gulp`

2. Secondly, install all other dependencies: `npm install`

## Building

### Maven
1. Build the project: `mvn clean install`
2. Deploy into a servlet container like Apache Tomcat

### Gradle
1. Build and start Jetty: `gradle jettyRunWar`
