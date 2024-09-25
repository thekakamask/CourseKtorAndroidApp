# CourseKtorAndroidApp
CourseKtorAndroidApp is an Android application designed to interact with a Ktor server via REST API calls. 
Using Jetpack Compose for the user interface, and Retrofit for network call management, the application displays information on courses retrieved via endpoints defined on the server.

## Main features

- Highest course display: the application makes a network call to retrieve the highest course available via an endpoint /course/top on the Ktor server.
- Modern user interface with Jetpack Compose: the application uses Jetpack Compose to display information reactively, based on the MVVM pattern.
- State management (LiveData): loading states, received data and errors are managed via LiveData in a ViewModel.
- Integration with Dagger Hilt: for dependency injection, Hilt is used to manage ViewModel, Retrofit and data repository instances.
- Network compatibility: the client is configured to accept HTTP (cleartext) communications with a local server, enabling work with a local backend during development.

## Execution

- Communication with a local server: the client is designed to operate in a local development environment, where the Ktor server is hosted locally. It uses a special address to access localhost from the Android emulator.
- Multi-platform mode: although primarily used for API calls, the application can be adapted to communicate with other servers or external REST API systems, and can display information in a browser or Android interface.
