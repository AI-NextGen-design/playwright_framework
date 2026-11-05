# Playwright Java Automation Framework

A scalable test automation framework built with Java, Playwright, Cucumber, TestNG, and Maven.

The framework is designed to support frontend UI automation, backend API testing, and end-to-end integration testing.

## Tech Stack

- Java 17
- Playwright Java
- Cucumber BDD
- TestNG
- Maven
- REST Assured (planned)

## Features

- Reusable Page Object Model (POM)
- Environment-based configuration
- Centralized browser and context management
- Cucumber-based test scenarios
- UI and API automation support (API automation planned)

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   ├── config/
│   │   ├── drivers/
│   │   ├── Context/
│   │   └── Constants/
│   └── resources/
│       └── config/
└── test/
    ├── java/
    │   ├── pages/
    │   ├── hooks/
    │   ├── runners/
    │   └── stepdefinitions/
    └── resources/
        └── features/
```

## Getting Started

### Prerequisites

- Java 17
- Maven 3.x

### Clone the Repository

```bash
git clone <repository-url>
cd playwright-java-framework
```

### Install Dependencies

```bash
mvn clean install
```

### Install Playwright Browsers

```bash
mvn exec:java \
  -Dexec.mainClass=com.microsoft.playwright.CLI \
  -Dexec.args="install"
```

### Run Tests

```bash
mvn test
```

Run tests against a specific environment:

```bash
mvn test -Denv=qa
```

## Current Progress

- Framework setup and browser management
- Environment configuration
- OrangeHRM login page object
- Cucumber login scenario (in progress)

## Planned Enhancements

- REST Assured API automation
- UI/API integration testing
- Parallel execution
- Allure reporting
- Jenkins/GitLab CI/CD integration

