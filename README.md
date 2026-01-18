# 📱 AppBattery

## Overview

**AppBattery** is a lightweight Android application built with **Kotlin** and **Jetpack Compose**, designed as a **portfolio and learning project** to demonstrate modern Android UI development practices.

The application provides a **real-time, animated visualization of the device battery level**, emphasizing clean UI, state management, and Compose-based animations.

---

## Key Features

- Real-time battery percentage display  
- Animated battery level indicator  
- Dynamic color feedback based on battery state:
  - **Red** – Critical (0–15%)
  - **Yellow** – Low (16–20%)
  - **Green** – Normal / Charged  
- Contextual status messages:
  - “Put it on charge!” for critical levels
  - “Fully charged!” at 100%  
- Automatic battery status refresh every second

---

## Technology Stack

- Kotlin  
- Jetpack Compose  
- Material Design 3  
- Kotlin Coroutines  
- Android SDK  

---

## Technical Highlights

- Declarative UI with `@Composable` functions  
- State handling using `remember` and `mutableStateOf`  
- Lifecycle-aware updates with `LaunchedEffect`  
- Smooth UI animations via `animateFloatAsState`  
- Direct integration with Android system battery services  

---

## Screenshots

<p align="center">
  
  
  <img src="https://github.com/user-attachments/assets/c15fcd3e-042f-4e05-8eef-d5df2ef46543" width="250"/>
</p>

---

## Project Scope

- Educational and portfolio-oriented project  
- No user data collection  
- No commercial intent  
- Focused on clarity, readability, and Compose best practices  

---

## Author

**Jéssica Miranda**  
Android Developer | Jetpack Compose Enthusiast  

---

## License

This project is open for educational and demonstration purposes.
