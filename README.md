# UICatalogIOS Automation

This project is a comprehensive test automation framework for mobile applications, built using Java, Maven, Appium, TestNG, and Selenium. It focuses on automating UI tests for iOS applications, particularly Apple's UIKitCatalog sample app, as well as other mobile apps such as SwagLabs, Myntra, and various news apps. The framework supports both iOS and Android platforms, with extensive utilities for handling gestures, signatures, swipes, and more.

## Features

- **Page Object Model (POM)**: Organized page classes for UI elements like Alerts, Buttons, Sliders, and TextFields.
- **Base Test Classes**: Separate base classes for iOS (`BaseIOSTest`) and Android (`BaseAndroidTest`) tests, providing common setup and teardown.
- **Gesture Utilities**: Comprehensive utilities for iOS and Android gestures, including taps, swipes, long presses, and signature drawing.
- **Retry Mechanism**: Built-in retry analyzer for flaky tests.
- **Reporting**: Integrated with Allure for detailed test reports.
- **Cross-Platform Support**: Tests for web, Android, and iOS platforms.
- **App Management**: Pre-built app files for UIKitCatalog and SauceLabs sample apps.

## Project Structure

```
UICatalogIOS/
├── app/                          # Mobile app binaries
│   ├── iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.zip
│   └── UIKitCatalog.app.zip
├── driver/                       # WebDriver executables
│   └── chromedriver
├── src/
│   ├── main/java/org/uicatlog/pages/  # Page Object classes
│   │   ├── AlertsPage.java
│   │   ├── ButtonsPage.java
│   │   ├── SlidersPage.java
│   │   └── TextFieldsPage.java
│   └── test/
│       ├── java/org/uicatlog/
│       │   ├── base/             # Base test classes
│       │   │   ├── BaseAndroidTest.java
│       │   │   ├── BaseForWebAndroidTest.java
│       │   │   ├── BaseForWebMiOSTest.java
│       │   │   └── BaseIOSTest.java
│       │   ├── listeners/        # Test listeners
│       │   │   └── TestListener.java
│       │   ├── tests/            # Test classes
│       │   │   ├── AlertsTest.java
│       │   │   ├── ButtonsTest.java
│       │   │   ├── SlidersTest.java
│       │   │   ├── TextFieldsTest.java
│       │   │   ├── SwagLabsMobileAppTest.java
│       │   │   └── ... (other test files)
│       │   └── utils/            # Utility classes
│       │       ├── AndroidGesturesUtils.java
│       │       ├── IosGestures.java
│       │       ├── SwipeStaticUtils.java
│       │       ├── SignatureHelper.java
│       │       ├── RetryAnalyzer.java
│       │       └── ... (other utilities)
│       └── resources/            # Test resources (if any)
├── pom.xml                       # Maven configuration
├── testng.xml                    # TestNG suite configuration
├── .gitignore                    # Git ignore file
└── README.md                     # This file
```

## Prerequisites

- **Java**: JDK 21 or higher
- **Maven**: 3.6 or higher
- **Appium**: Server 2.0 or higher
- **iOS**: Xcode with iOS Simulator (for iOS tests)
- **Android**: Android SDK with emulator or device (for Android tests)
- **Node.js**: For running Appium server
- **IDE**: IntelliJ IDEA or Eclipse with Maven support

## Setup

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd UICatalogIOS
   ```

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

3. **Start Appium Server**:
   - Install Appium globally: `npm install -g appium`
   - Start the server: `appium`
   - For iOS, ensure Xcode and Simulator are set up.
   - For Android, ensure Android SDK and emulator/device are configured.

4. **Configure Capabilities**:
   - Update base test classes (`BaseIOSTest.java`, `BaseAndroidTest.java`) with appropriate Appium capabilities for your devices/simulators.

## Running Tests

- **Run All Tests**:
  ```bash
  mvn test
  ```

- **Run Specific Test Suite**:
  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```

- **Run with Allure Reports**:
  ```bash
  mvn clean test
  allure serve target/allure-results
  ```

- **Run Specific Test Class**:
  ```bash
  mvn test -Dtest=AlertsTest
  ```

## Test Apps

- **UIKitCatalog**: Apple's sample iOS app for testing UI components. Located in `app/UIKitCatalog.app.zip`.
- **SauceLabs Mobile Sample**: Sample app for testing. Located in `app/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.zip`.
- Other apps like SwagLabs, Myntra, and news apps are tested via their respective test classes.

## Utilities

- **Gesture Utils**: `IosGestures.java`, `AndroidGesturesUtils.java` for platform-specific gestures.
- **Swipe Utils**: `SwipeStaticUtils.java`, `SwipeUntilElementVisible.java` for scrolling and swiping.
- **Signature Utils**: Various signature helpers for drawing signatures in apps.
- **Retry and Listeners**: `RetryAnalyzer.java`, `TestListener.java` for test reliability.

## Contributing

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/new-feature`.
3. Commit changes: `git commit -am 'Add new feature'`.
4. Push to branch: `git push origin feature/new-feature`.
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For questions or issues, please open an issue on the GitHub repository.