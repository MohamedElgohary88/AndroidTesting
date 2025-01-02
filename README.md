# Android Testing Project

This repository demonstrates best practices for testing Android applications using modern tools and frameworks. The project focuses on unit testing, coroutine handling, flow testing, and more, all built with Kotlin.

![android testing](https://github.com/user-attachments/assets/c19d2df0-700a-4897-9abd-243834b074a8)

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Tests](#tests)
  - [Unit Testing](#unit-testing)
  - [Coroutine and Flow Testing](#coroutine-and-flow-testing)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

**Android Testing** is a project designed to showcase how to write effective and reliable unit tests for Android applications. This project utilizes Test-Driven Development (TDD) principles, ensuring the development of robust, maintainable, and bug-free code.

---

## Features

- Unit testing with **JUnit**
- Coroutine testing with **Kotlin Coroutines Test**
- Flow testing to verify asynchronous data streams
- Usage of mock frameworks for test doubles
- Code coverage analysis using modern tools

---

## Technologies Used

- **Kotlin**: Primary programming language
- **JUnit**: Framework for writing and running unit tests
- **Mockk**: Library for creating mocks and stubs
- **Kotlin Coroutines**: Asynchronous programming
- **Flows**: Reactive streams in Kotlin
- **Kotlin Coroutines Test**: Framework for coroutine testing

---

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Android Studio (latest version recommended)
- Kotlin (1.5 or above)
- Gradle (configured in Android Studio)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/android-testing.git
   ```

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Run the tests using the built-in test runner.

---

## Project Structure

```plaintext
src/main/kotlin    // Application code
src/test/kotlin    // Unit tests
```

Key files and folders:
- `LeadsController`: Core class managing leads data.
- `LeadsControllerTest`: Unit tests for `LeadsController`.

---

## Tests

### Unit Testing

The project includes extensive unit tests covering:
- Validation logic
- Adding valid and invalid leads
- Handling duplicates

### Coroutine and Flow Testing

Tests for coroutines and flows ensure:
- Proper handling of asynchronous code
- Correct emission of data streams

Example:
```kotlin
@Test
fun `should emit expected values from flow`() {
    val flow = leadsController.getLeadsFlow()
    testCoroutineScope.runBlockingTest {
        val values = flow.toList()
        assertEquals(expectedValues, values)
    }
}
```

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes with clear messages.
4. Submit a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

Developed by **Mohamed Elgohary**. Feel free to connect on [LinkedIn]([https://linkedin.com/in/muhammadalgohar](https://www.linkedin.com/in/mohamed-elgohary8)).
