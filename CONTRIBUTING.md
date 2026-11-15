# Contributing

Thank you for considering a contribution to the Playwright Java Automation Framework. Contributions of code, documentation, bug reports, test scenarios and constructive feedback are welcome.

## Before you start

1. Check the existing issues and pull requests to avoid duplicating work.
2. For a substantial change, open an issue first to discuss the proposed approach.
3. Be respectful and follow the project's [Code of Conduct](CODE_OF_CONDUCT.md).

## How to contribute

1. Fork the repository.
2. Clone your fork:

   ```bash
   git clone https://github.com/AI-NextGen-design/playwright_framework.git
   cd playwright_framework
   ```

3. Create a focused branch:

   ```bash
   git checkout -b feature/short-description
   ```

4. Make your changes.
5. Run the relevant tests:

   ```bash
   mvn clean verify
   ```

6. Review your changes and ensure you have not committed credentials, tokens, local configuration, generated reports or unnecessary browser artifacts.
7. Push your branch and open a pull request against the upstream repository's default branch.

## Pull request guidelines

Please include:

- A clear summary of the change and its motivation.
- The related issue number, if one exists.
- Test evidence, including the command you ran and whether it passed.
- Screenshots or report snippets when they help explain a UI or reporting change.
- Any configuration or documentation updates needed by users.

Keep pull requests focused. Prefer small, reviewable changes over unrelated changes bundled together.

## Coding and test guidelines

- Follow the existing package structure and naming conventions.
- Keep scenario-specific state isolated; avoid sharing Playwright `Page`, `BrowserContext` or other thread-confined objects across worker threads.
- Prefer reusable utilities where they genuinely reduce duplication.
- Do not hardcode credentials or secrets.
- Add or update tests when changing framework behaviour.
- Update the README when setup, execution or supported capabilities change.

## Reporting issues

When opening an issue, include:

- A concise title.
- Steps to reproduce.
- Expected behaviour and actual behaviour.
- Relevant error logs and environment details (Java, Maven, OS and browser).
- A minimal example where possible.

Remove passwords, access tokens, personal data and other sensitive information from logs before posting.

## Contribution copyright and licence

You retain copyright in the original work you contribute. By submitting a contribution for inclusion in this project, you make that contribution available under the project's MIT License, so that the project and its users may use, modify and distribute it under that licence.

You confirm that you have the right to submit the contribution and that, to the best of your knowledge, it does not knowingly violate another party's rights.

This project does not currently require a separate Contributor Licence Agreement (CLA). If that policy changes, the project will communicate the change clearly and obtain any required agreement before relying on it.

## Questions

If you are unsure whether a change fits the project, open an issue to discuss it before investing significant time.
