# Congress Communicator Android App

This is a self-contained Android application for batch emailing and calling US Congress members. All services, including email, calling, and text-to-speech, are built-in and do not require external APIs or configuration.

## Features

- **Batch Emailing**: Send personalized emails to multiple Congress members at once.
- **Email Alias**: Send emails from an alias to protect your privacy.
- **Batch Calling**: Make automated calls to multiple Congress members.
- **Caller ID Alias**: Make calls from an alias phone number.
- **Text-to-Speech**: Read user-provided scripts with a natural-sounding voice.
- **Automated Menu Navigation**: Navigate through automated phone menus to reach a live person.
- **Contact Importer**: Import contact information for all US Congress members.
- **Self-Contained**: All services are built-in and work offline once configured.

## Getting Started

To build and run this project, you will need Android Studio and the Android SDK. 

1. Clone the repository:
   ```
   git clone https://github.com/LexiconAngelus93/CongressCommunicator.git
   ```
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Project Structure

The project is organized into the following packages:

- `ui`: Contains all activities, fragments, and UI-related classes.
- `db`: Contains the Room database, entities, and DAOs for contact management.
- `email`: Contains the self-contained email service with SMTP functionality.
- `calling`: Contains the self-contained calling service with TTS and SIP integration.
- `contacts`: Contains the data importer for Congress member information.
- `utils`: Contains utility classes and helper functions.

## Dependencies

- [AndroidX](https://developer.android.com/jetpack/androidx) - Core Android libraries.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Material Design components.
- [Room](https://developer.android.com/training/data-storage/room) - Local database storage.
- [JavaMail for Android](https://github.com/javaee/javamail-for-android) - Email sending functionality.
- [PJSIP](https://www.pjsip.org/) - SIP protocol for VoIP calling.
- [Pico TTS](https://github.com/DougGore/picopi) - Text-to-speech engine.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


