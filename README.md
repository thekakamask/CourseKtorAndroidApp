# CourseKtorAndroidApp
CourseKtorAndroidApp is an Android application designed to interact with a Ktor server via REST API calls. The app utilizes modern Android development technologies, such as Jetpack Compose for the UI and Retrofit for network management, to display course information fetched from a server.

## Main features

- Welcome Message: Upon launch, the app displays a welcome message retrieved from the Ktor server's / endpoint.
- Highest Course Display: The application makes a network call to retrieve the course with the highest level available via an endpoint /course/top on the Ktor server.
- Search Course by ID: Users can input a course ID to retrieve and display detailed information about a specific course, fetched from the /course/{id} endpoint.
- Modern UI with Jetpack Compose: The application uses Jetpack Compose to create a reactive user interface, leveraging the MVVM (Model-View-ViewModel) architecture.
- State Management (LiveData): The app manages loading states, received data, and potential errors using LiveData objects in the ViewModel, ensuring a smooth user experience.
- Dependency Injection with Dagger Hilt: Hilt is used for managing dependencies, including ViewModels, Retrofit, and data repository instances, simplifying dependency management.
- Cleartext Communication: The client is configured to allow HTTP (cleartext) communication with the local Ktor server during development, making it easier to work in a local development environment.

## Execution

- Communication with a Local Server: The application is designed to work in a development environment where the Ktor server is hosted locally. It uses http://10.0.2.2:8080 to connect to the local server when running in an Android emulator.
- Browser and Android Interface Support: The server can respond to requests from both Android clients and browsers, making it a flexible solution for various platforms.
- Adaptability: Although the app is configured for local development, it can be easily adapted to work with external REST APIs or other backends by changing the API endpoints in the codebase.
