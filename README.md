# GrsActivityTrackerDemo
GrsActivityTrackerDemo


spring.h2.console.enabled=true
spring.datasource.platform=h2


spring.datasource.platform=postgres
spring.datasource.name=testapp

spring.datasource.url=jdbc:postgresql://localhost:5432/tests
spring.datasource.username=addyours
spring.datasource.password=




spring.jpa.show-sql=true

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update'
