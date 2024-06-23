---

# Project Setup

## Spring Initializr Setup

1. **Download Spring Boot using Maven:**
    - Visit [Spring Initializr](https://start.spring.io/) and select Maven as the build tool.
    - All the dependencies are included in pom.xml

2. **Opening Project in IntelliJ IDEA:**
    - Open IntelliJ IDEA and wait for the project to fully load (this may take a few minutes).

---

# Database Setup

## MySQL Setup

1. **Setting Up MySQL:**
    - Open MySQL Workbench.
    - Create a new database named `projekt`.
   

2. **Create `users` Table and Insert Sample Data:**

   ```sql
   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       token CHAR(16) NOT NULL
   );

   INSERT INTO users (name, token) VALUES
   ('Albert Einstein', 'aB3dE6fGhIjKlMn1'),
   ('Marie Curie', '2Mn0PaQ3RbXy4W5z'),
   ('Isaac Newton', 'cD7f8gH1iJ2kL9mN'),
   ('Leonardo da Vinci', 'OpQr5StUvWxY6ZaB'),
   ('Galileo Galilei', '7Mn8oPqR9sT1Uv2W'),
   ('Nikola Tesla', 'Xy3ZaBcD4eF5GhIj'),
   ('Ada Lovelace', 'K1Lm2NoP3QrS4tUv'),
   ('Charles Darwin', '5Wx6Y7ZaB8cD9eFg'),
   ('Thomas Edison', 'HiJ1KlMn2Op3QrSt'),
   ('Alexander Graham Bell', '4Uv5WxY6Za7BcD8e');
   ```

3. **Configure `application.properties`:**
    - Add the following properties to `src/main/resources/application.properties`:

   ```properties
   spring.application.name=projekt
   spring.datasource.url=jdbc:mysql://localhost:3306/projekt
   spring.datasource.username=<your_username_from_MySQLWorkbench_Connections>
   spring.datasource.password=<your_password_from_MySQLWorkbench_Connections>

   spring.jpa.show-sql=true
   spring.jpa.generate-ddl=true
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

---

# Testing

## Endpoints Testing

- **Retrieve details of a product by ID:**
    - Endpoint: `http://localhost:8080/products/id?id=1`

- **Filter products by name:**
    - Endpoint: `http://localhost:8080/products/name?name=Eyeshadow%20Palette%20with%20Mirror`

- **Filter products by category and price:**
    - Endpoint: `http://localhost:8080/products/filter?category=beauty&price=19.99`

- **Filter products by category:**
    - Endpoint: `http://localhost:8080/products/filter?category=beauty`

- **Filter products by price:**
    - Endpoint: `http://localhost:8080/products/filter?price=19.99`

## Authorization Testing

- Use Postman with requests of type GET.
- Add a custom Authorization header with a valid token from the `users` table.
- If the token is valid, you can access product information; otherwise, a 401 Unauthorized error is returned.

---

# Future Improvements

- Implement caching to improve performance by storing frequently filtered data in memory.
- Implement error logging functionality to create log files each time the application starts.

---

This README file provides steps for setting up the project, configuring the database, testing endpoints, and considerations for future enhancements. Adjust the placeholders `<your_username_from_MySQLWorkbench_Connections>` and `<your_password_from_MySQLWorkbench_Connections>` with your actual MySQL Workbench connection details before usage.