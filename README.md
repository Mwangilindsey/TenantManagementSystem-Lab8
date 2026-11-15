Tenant Management System

An Android application developed using Kotlin in Android Studio to help landlords manage tenant information, record rent details and access tenant contact information.

Download

Latest APK: Available under the GitHub Releases section once published.

Features

User Registration and Login: Allows users to create an account and log in to the application.

Dashboard: Displays the number of registered tenants and the total rent amount.

Add Tenants: Allows users to enter tenant information.

View Tenants: Displays registered tenant information.

Call Tenant: Allows users to select a tenant and open the phone dialler.

Navigation: Provides access to application features through the options menu and navigation drawer.

Local Database: Uses Room Database components for local tenant data storage. 

Technologies Used
Kotlin: Used as the main programming language for developing the application.
Android Studio: Used as the development environment.
XML: Used to design the application's user interface layouts.
Room Database: Used for local database storage.
ViewModel: Manages UI-related data.
LiveData: Observes changes in application data.
Git: Used for version control and tracking code changes.
GitHub: Used for hosting the project and supporting group collaboration.

Application Architecture

The application is organised using the Model-View-ViewModel (MVVM) architecture. It separates the application into two main layers: the UI layer and the data layer.

1. UI Layer

The UI layer contains the activities and fragments responsible for displaying information and interacting with users. It also includes the TenantViewModel, which manages UI-related data and communicates with the repository.

2. Data Layer

The data layer contains the components responsible for managing tenant information and database operations. These include the tenant model, Room Entity, DAO, Database and Repository.

Data Flow

The intended application data flow is:

UI Screens → TenantViewModel (LiveData) → TenantRepository → TenantDao → Room Database

UI Screens: Display information and receive user input.

TenantViewModel: Manages tenant-related data and communicates with the repository.

LiveData: Allows the UI to observe changes in tenant records.

TenantRepository: Handles communication between the ViewModel and the data source.

TenantDao: Defines database operations for inserting and retrieving tenant records.

Room Database: Provides local storage for tenant information.


Project Structure

The project is organised into two main packages:

UI Package

auth – Contains the login and registration activities.

main – Contains the main activity and application navigation.

dashboard – Contains the dashboard fragment.

tenants – Contains the Add Tenant and View Tenants fragments.

viewmodel – Contains the TenantViewModel class.

Data Package

model – Contains the tenant data model.

local – Contains the Room Entity, DAO and Database components.

repository – Contains the TenantRepository class.

Group Members and Individual Responsibilities

The project is being developed collaboratively by the members. 

1. Lindsey Mwangi (148349) – Stage 1: Project Setup

Selected the working Lab 7 project to be used as the foundation for Lab 8.

Created the shared GitHub repository and invited all group members.

Created and configured the .gitignore file to exclude unnecessary and sensitive project files.

Organised the project structure into ui and data packages.

Moved existing classes into their appropriate packages.

Updated package declarations and imports after reorganising the project.

Built and tested the application to confirm that it ran successfully.

2. Champion David (191481) – Stage 2: ViewModel and LiveData

Created TenantViewModel.kt to manage tenant-related application data.

Implemented LiveData to allow the UI to observe changes in tenant records.

Connected the ViewModel to the TenantRepository.

Created functions for adding, retrieving and managing tenant records.

Prepared the ViewModel to communicate with the application's UI components.

3. Safari Pascal Amindja (169470) – Stage 3: Room Database

Created TenantEntity.kt to define the structure of tenant records stored in the database.

Created TenantDao.kt to define database operations.

Created TenantDatabase.kt to configure and provide access to the Room database.

Configured the required Room dependencies.

Implemented the database components required for local tenant data storage.

4. Elizabeth Waithera (186909) – Stage 4: Connect UI to ViewModel

Updated DashboardFragment.kt to work with the TenantViewModel.

Updated AddTenantFragment.kt to use ViewModel functions when adding tenant records.

Updated ViewTenantsFragment.kt to retrieve and display tenant information.

Implemented LiveData observation to allow the UI to respond to changes in tenant records.

Replaced direct repository calls in the UI with ViewModel calls.


5. Lindsey Mwangi (148349) - Stage 6: APK Installation

Release distribution responsibilities

Generate the signed release APK.

Test APK installation.

Create the GitHub v1.0 release.

Upload the signed APK to GitHub Releases.

Version Control and Collaboration


How to Run the Application

Clone or download this GitHub repository.

Open the project in Android Studio.

Allow Gradle to sync and download the required dependencies.

Connect an Android device or start an Android emulator.

Click the Run button to install and launch the application.

Release Information

Application: Tenant Management System

Version: 1.0

Platform: Android

Release APK: Uploaded under the GitHub Releases section after final testing and distribution.
