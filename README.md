Web Project Seed
=============

Have it JAR way

# Introduction
This is a small project for getting up to speed when creating a new web application from scratch using various
technologies.

## Technologies
The following is a listing of the major technologies used in order og relative significance.

1. [Groovy](http://groovy.codehaus.org/)
2. [Spring (4)](http://spring.io/)
3. [Gradle](http://www.gradle.org/)
4. [Java (8)](https://jdk8.java.net/)

# Local development
There are two ways of building and running the web application, both of which are listed below.

## Maven
1. Build the project: `mvn clean install`
2. Deploy into a servlet container like Apache Tomcat

## Gradle
1. Build and start Jetty: `gradle jettyRunWar`