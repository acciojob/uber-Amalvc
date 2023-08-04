# MedTeams Backend

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Steps to Run](#steps-to-run)
3. [Executing the database migration](#executing-the-database-migration)
4. [Executing the data seeders](#executing-the-data-seeders)
5. [Branch Strategy](#branch-strategy)
6. [Database Schema](#database-schema)
7. [API Specification](#api-specification)
8. [Project Management with Jira](#project-management-with-jira)
9. [Architecture Pattern](#architecture-pattern)
10. [Recommended Extensions](#recommended-extensions)
11. [Error Code Schema](#error-code-schema)
12. [Coding Practices](#coding-practices)

## Prerequisites

Before you begin, ensure you have met the following requirements:

1. **Docker**: You can install the latest version of Docker Desktop from [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/)

2. **Visual Studio Code (VS Code)**: You can install the latest version of VS Code from [https://code.visualstudio.com/](https://code.visualstudio.com/)

3. **MySQL**: Install MySQL, a relational database management system. You can download and install MySQL from [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/).

These tools are essential for setting up and running the Med Teams Backend project locally.

## Steps to Run

Follow these steps to set up and run the MedTeams Backend project using Docker

1. Clone this repository and navigate to the project folder:

   ```sh
   git clone [https://github.com/mindstix-labs/biteline-backend.git]
   ```
   ```sh
   cd med-teams-backend
   ```
2. Setting up env file - Copy the env.example file provided in the repository and rename it to .env.
3. Go to the terminal and run the following command to start the application

   ```sh
   docker-compose up
   ```

...

## Executing the database migration
1. Run the application as above.
2. Connect to the backend application container:

   ```sh
   docker exec -it medteams-backend /bin/sh
   ```
3. Run the following command inside the container ("/application"):

   ```sh
   npx sequelize-cli db:migrate
   ```
...

## Executing the data seeders
1.  Run the application as above.
2.  Connect to the backend application container:

    ```sh
    docker exec -it medteams-backend /bin/sh
    ```
3. Run all seeders using the following command inside the container:

   ```sh
   npx sequelize-cli db:seed:all
   ```
...

## Branch Strategy
In the MedTeams Backend project, we follow a feature branching workflow with a dedicated stable branch to ensure collaborative and organized development. Feature branching allows us to work on new features, bug fixes, or tasks in isolation, while the stable branch ensures the main codebase remains unaffected. Here's how it works:

1. **Creating a Feature Branch**: Whenever you're working on a new feature or task, create a new branch from the main `develop` branch. Use a descriptive name for your branch, such as `feature/user-authentication` or `bugfix/payment-gateway-fix`.

2. **Isolated Development**: Work on your feature branch independently. You can make commits, tests, and changes specific to your feature without interfering with ongoing work in other branches.

3. **Collaboration**: If multiple team members are working on different features, each can create their own feature branch. This allows everyone to collaborate in parallel.

4. **Testing**: Once your feature is ready, ensure that it's thoroughly tested and meets the project's quality standards.

5. **Merge and Deployment**: After testing and code review, your feature branch can be merged into the stable branch. This integration ensures that new features are added while maintaining the stability of the main codebase.
...

## Database Schema
The MedTeams Backend project uses a structured database schema to efficiently manage and organize data. Our database schema is designed to support the requirements of the application and ensure data integrity. You can explore the details of our database schema using the provided link below:

[Access Database Schema](https://docs.google.com/spreadsheets/d/1mBt1kCQQLaHrMMDHU1EJsKR-vqOXKEwzyTaBWZ1owfM/edit#gid=377800607)

Understanding the database schema is essential for developing new features, performing database operations, and ensuring data consistency.
...

## API Specification
The MedTeams Backend project follows well-defined API specifications to ensure consistent communication between different components of the application. Our API specifications provide details about endpoints, request and response formats, authentication, and more. You can explore the API specifications using the provided link below:

[Access API Specifications](https://docs.google.com/document/d/1qfZp2ap2pXZgxnQOTxbxwOQoQaribIsN0vCfPbJKWw4/edit#heading=h.ad5xjxon8tq1)

Understanding the API specifications is crucial for developing, testing, and integrating new features, as well as for maintaining a clear understanding of the interactions within the application.
...

## Project Management with Jira

We manage our development tasks, issues, and project progress using Jira, a robust project management tool. Our Jira board provides an overview of ongoing tasks, features in development, bug fixes, and more. You can access our Jira board using the provided link below:

[Access Jira Board](link_to_your_jira_board)

The Jira board is a valuable resource for tracking the status of tasks, collaborating with team members, and staying informed about the project's progress.
...

## Architecture Pattern
MedTeams Backend project follows the Model-View-Controller (MVC) architecture pattern to design and organize the codebase. MVC is a widely adopted software design pattern that separates an application into three interconnected components:

1. **Model**: Represents the application's data and business logic. It encapsulates data manipulation, validation, and interactions with the database.

2. **View**: Handles the presentation and user interface elements. It displays data to users and captures user input. In our case, the view often translates to the API endpoints that expose data and functionality.

3. **Controller**: Acts as an intermediary between the model and view. It receives user requests, processes them by invoking appropriate actions on the model, and determines which view to present in response.
   
To delve deeper into the MVC framework and gain a comprehensive understanding of how it works, you can explore the detailed explanation provided in this [MVC Framework Introduction guide by GeeksforGeeks](https://www.geeksforgeeks.org/mvc-framework-introduction/).

By implementing the MVC architecture in the MedTeams Backend project, we achieve a separation of concerns, modularity, and maintainability, resulting in a well-organized and efficient codebase.
...

## Recommended Extensions

To enhance the development experience and ensure code quality, we recommend using the following extensions with your preferred code editor:

1. **Linter**: A linter helps maintain consistent code style and identify potential issues early in the development process. We suggest using [eslint](https://eslint.org/) along with [Prettier](https://prettier.io/) for code formatting. Install the relevant VS Code extensions for these tools to receive real-time feedback and automated formatting.

2. **SonarQube**: SonarQube is a powerful code analysis tool that provides insights into code quality, maintainability, and security. Integrating SonarQube into your development workflow can help identify and address code smells, vulnerabilities, and technical debt. Learn more about [SonarQube](https://www.sonarqube.org/)

Using these extensions can significantly improve code quality, streamline development, and contribute to a more robust and maintainable codebase. If you have any questions about setting up or configuring these extensions, feel free to reach out to our team.

...

## Error Code Schema

...
## Coding Practices

In the MedTeams Backend project, we adhere to the following coding practices to ensure readability, maintainability, and consistency in our codebase:

1. **Meaningful Variable and Function Names**: Use descriptive names that reflect the purpose and functionality of variables, functions, and classes.

2. **Comments and Documentation**: Provide clear comments to explain complex logic or decisions.

3. **Consistent Formatting**: Follow a consistent code formatting style throughout the project. We use tools like Prettier to automate code formatting.

4. **Modularization**: Organize code into modular components to enhance reusability and maintainability.

5. **Error Handling**: Implement proper error handling mechanisms to gracefully handle exceptions and failures.

6. **Version Control Best Practices**: Make frequent, small commits with meaningful messages. Use feature branches for development and keep the main branch stable.

7. **Performance Considerations**: Optimize code for performance by avoiding unnecessary computations and adhering to best practices.

8. **Security**: Implement security best practices, such as input validation and data sanitization, to prevent common vulnerabilities.

By following these coding practices, we aim to create a codebase that is maintainable, robust, and conducive to collaborative development.

...
