# Congress Communicator - Complete Documentation

## Overview

Congress Communicator is a self-contained Android application designed for batch communications with US Congress members. The app provides email and calling capabilities with built-in services that require no external APIs or configuration.

## Architecture

The application follows a clean architecture pattern with the following layers:

### UI Layer
- **Activities**: Main screens for different functionalities
- **Adapters**: RecyclerView adapters for displaying lists
- **ViewModels**: Manage UI state and business logic

### Data Layer
- **Database**: Room database for local storage
- **Entities**: Data models for Congress members
- **DAOs**: Data access objects for database operations

### Service Layer
- **Email Service**: Self-contained SMTP email functionality
- **Calling Service**: Phone calling with TTS integration
- **Data Importer**: Manages Congress member data import

## Key Features

### 1. Email Service
- **Built-in SMTP**: No external email APIs required
- **Email Aliases**: Send emails from custom aliases
- **Batch Sending**: Send to multiple recipients simultaneously
- **Template System**: Pre-built templates for Congress communications
- **Auto-Configuration**: Automatic SMTP settings for popular providers

### 2. Calling Service
- **Text-to-Speech**: Natural voice synthesis for call scripts
- **Menu Navigation**: Automated navigation of phone menus
- **Batch Calling**: Sequential calls with proper delays
- **Caller ID Alias**: Support for caller ID customization
- **Call Logging**: Detailed tracking of call results

### 3. Database Management
- **Embedded Data**: Pre-loaded Congress member information
- **Real-time Search**: Instant search and filtering
- **Advanced Filters**: Filter by party, chamber, state
- **Contact Management**: Complete contact information storage

### 4. User Interface
- **Material Design**: Modern, professional interface
- **Responsive Layout**: Works on phones and tablets
- **Intuitive Navigation**: Easy-to-use interface
- **Progress Tracking**: Visual feedback for operations

## Technical Implementation

### Email Service Architecture

```kotlin
EmailService
├── SMTPConfig - Built-in SMTP configurations
├── EmailAccount - User email account management
├── EmailMessage - Message composition and formatting
└── EmailResult - Operation result tracking
```

### Calling Service Architecture

```kotlin
CallService
├── TTSService - Text-to-speech functionality
├── CallConfig - Call configuration and settings
├── MenuRule - Automated menu navigation rules
└── CallResult - Call result tracking
```

### Database Schema

```kotlin
CongressMember
├── Basic Info (name, title, party, chamber)
├── Location (state, district, office address)
├── Contact (phone, email, website)
├── External IDs (bioguide, govtrack, etc.)
└── Social Media (twitter, facebook, etc.)
```

## Setup and Installation

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API 24 or higher
- Java 8 or higher
- Gradle 8.0 or higher

### Building the App

1. **Clone the Repository**
   ```bash
   git clone https://github.com/LexiconAngelus93/CongressCommunicator.git
   cd CongressCommunicator
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Build the Project**
   - Wait for Gradle sync to complete
   - Build → Make Project (Ctrl+F9)
   - Run → Run 'app' (Shift+F10)

### Configuration

The app is designed to work out-of-the-box with minimal configuration:

1. **Email Setup**: Add your email accounts in the app settings
2. **Permissions**: Grant required permissions when prompted
3. **Data Import**: Congress member data is automatically imported on first run

## Usage Guide

### Setting Up Email

1. Open the app and navigate to Settings
2. Add your email account credentials
3. Configure email aliases if desired
4. Test the configuration

### Sending Batch Emails

1. From the main screen, tap the email FAB
2. Select recipients or choose "Select All"
3. Choose an email template or write custom content
4. Configure sender alias if needed
5. Tap "Send Email"

### Making Batch Calls

1. From the main screen, tap the phone FAB
2. Select recipients or choose "Select All"
3. Write or paste your call script
4. Configure TTS and auto-navigation settings
5. Tap "Start Calls"

### Searching and Filtering

1. Use the search bar to find specific members
2. Apply filters using the chip buttons
3. Combine multiple filters for precise results
4. Tap any member card for detailed information

## Security and Privacy

### Data Protection
- All data is stored locally on the device
- No external servers or cloud services used
- Email credentials are encrypted in local storage
- No tracking or analytics implemented

### Permissions
- **CALL_PHONE**: Required for making calls
- **RECORD_AUDIO**: Required for TTS functionality
- **INTERNET**: Required for email sending
- **READ/WRITE_CONTACTS**: Optional for contact integration

## Troubleshooting

### Common Issues

**Email Not Sending**
- Verify email credentials are correct
- Check internet connection
- Ensure email provider allows SMTP access
- Try enabling "Less secure app access" for Gmail

**Calls Not Working**
- Verify CALL_PHONE permission is granted
- Check device has calling capability
- Ensure phone numbers are valid
- Test TTS functionality separately

**App Crashes**
- Check Android version compatibility (API 24+)
- Verify all permissions are granted
- Clear app data and restart
- Check device storage space

### Performance Optimization

**Large Batch Operations**
- Use smaller batch sizes for better performance
- Allow adequate delays between operations
- Monitor device memory usage
- Close other apps during batch operations

## Development Notes

### Code Structure
- **Package Organization**: Features are organized by functionality
- **Dependency Injection**: Manual dependency injection for simplicity
- **Error Handling**: Comprehensive error handling throughout
- **Testing**: Unit tests for core functionality

### Build Configuration
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34
- **Build Tools**: 34.0.0

### Dependencies
- AndroidX libraries for modern Android development
- Room database for local storage
- Material Components for UI
- JavaMail for email functionality
- Kotlin coroutines for async operations

## Contributing

### Development Setup
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

### Code Style
- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Add comments for complex logic
- Maintain consistent formatting

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Support

For issues, questions, or contributions, please visit the GitHub repository:
https://github.com/LexiconAngelus93/CongressCommunicator

## Changelog

### Version 1.0.0 (Initial Release)
- Complete self-contained email service with SMTP
- Phone calling service with TTS and menu navigation
- Embedded Congress member database
- Material Design UI with search and filtering
- Batch operations for email and calling
- Email and caller ID alias support
- Automated phone menu navigation
- Professional documentation and setup guides

