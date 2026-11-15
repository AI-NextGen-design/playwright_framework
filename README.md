# Playwright Java Automation Framework

An evolving, community-driven test automation framework built with Playwright and Java. The goal is to develop a practical, maintainable foundation for browser automation and demonstrate real-world automation engineering practices.

> **Project status:** In active development. Features and setup instructions may evolve as the framework grows.

## Technology stack

- Java 17
- Playwright for Java
- Maven
- Cucumber (BDD)
- TestNG
- PicoContainer for scenario-scoped dependency injection
- Allure reporting
- Azure DevOps pipeline integration

## Current capabilities

The framework is being developed to support:

- Browser and browser-context management
- Page and scenario context management
- Cucumber-based test scenarios
- TestNG-based test execution
- Parallel scenario execution (being implemented and validated)
- Allure result generation
- Failure screenshots and video evidence
- CI execution through Azure DevOps

Only consider a capability production-ready once it has been implemented and verified in the current repository.

## Prerequisites

- JDK 17
- Maven 3.8+
- Git
- A supported operating system for Playwright browsers

## Getting started

1. Clone the repository:

   ```bash
   git clone https://github.com/AI-NextGen-design/playwright_framework.git
   cd playwright_framework
   ```

2. Confirm Java and Maven are available:

   ```bash
   java -version
   mvn -version
   ```

3. Install the Playwright browser required by the tests. For Chromium:

   ```bash
   mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"
   ```

   On Linux CI agents, install browser system dependencies as required by the Playwright environment. See the official Playwright Java documentation for platform-specific instructions.

4. Run the test suite:

   ```bash
   mvn clean verify
   ```

## Reports and test evidence

The project is configured to use Allure. After a successful Maven verification run, check the configured report output under:

```text
target/allure-report/
```

Raw Allure results are written to the configured results directory (currently `allure-results/`).

Failure screenshots and videos may be written under `target/`, depending on the hooks and test outcome. These generated files are not source code and should generally not be committed.

## Configuration

Review `pom.xml` and the framework configuration classes before running tests. Environment-specific values, credentials, URLs and other secrets should be supplied through local configuration or CI secret variables; do not commit credentials or tokens.

If the project uses a CI flag, for example:

```bash
mvn clean verify -Dci=true
```

use it only where the framework's browser configuration expects it.

## Contributing

Contributions, issue reports, suggestions and code reviews are welcome.

Please read [CONTRIBUTING.md](CONTRIBUTING.md) before opening an issue or pull request. By submitting a contribution, you retain copyright in your original contribution and agree that it is offered to the project under the MIT License, subject to the terms of that licence.

## Code of conduct

We aim to maintain a welcoming and respectful community. Please read [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).

## Copyright and licence

Copyright (c) 2026 Avishek Kumar Jha.

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for the complete licence text.

The copyright notice identifies the copyright holder of the original project material; it does not transfer ownership of contributors' original contributions.

## Useful references

- [Playwright for Java documentation](https://playwright.dev/java/)
- [Cucumber documentation](https://cucumber.io/docs/)
- [TestNG documentation](https://testng.org/)
- [Allure documentation](https://allurereport.org/docs/)
