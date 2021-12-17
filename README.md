# IAS-Software homework repository

## 1st Homework
Project developed in Springboot in order to understand the dependency inversion concept and the Controller - Service - Repository modules.

The architecture proposed for the understanding of the dependency inversion concept can be seen in the next figure:

![Diagram](https://i.imgur.com/3WoNZEu.png)

## 2nd Homework
- Create a repository that doesnt use a memory-based database.

- Set up a service of a dockerized database (Postgresql) and its manager (Adminer).

- Create a configuration bean to set up the database connection.

- Understand the differences between a repository implemented with a Datasource (HikariCP) and a JDBC Template approach (based on Spring JDBC)


## 3rd Homework
- Defining Entities and value objects for the model of the domain
-
- Creating the unit tests for the value objects classes

- Defining a jackson configuration file to customize the way these value objects are mapped in a JSON

- Defining a internalmodule, from the jackson config file, to implement the custom serialization and deserialization for every value object

- Adding the service layer to abstract the business logic

- Refactoring the repository layer, based on the changes made in the service layer

- Creating a model layer that containes the Input and Output definitions

- Refactoring the controller layer, based on the Inputs that are received and the Outputs that must be given by the layer.
