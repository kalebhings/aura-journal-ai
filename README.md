# Aura: The AI Reflection Engine

> An intelligent, private, and multimodal journaling application designed to make self-reflection effortless and insightful.

This repository contains the source code for Aura. This project is currently in **Phase 1 of active development**, focused on building the core backend services.

---

## 🔮 Project Vision

The goal of Aura is to transform journaling/note taking from a static log into a dynamic, interactive conversation with your personal history.

When complete, Aura will allow you to:
* **Capture Moments Effortlessly:** Create a single journal entry with any combination of rich text, uploaded images, and audio recordings.
* **Get AI-Powered Insights:** A secure backend pipeline will automatically:
    * Transcribe spoken audio notes.
    * Generate descriptive captions for images.
    * Detect sentiment and auto-tag entries with key topics, people, and places.
* **Use True Semantic Search:** Ask natural language questions like, "Show me happy entries about my dog at the park," and Aura will find relevant text, audio, and images.

---

## 🛠️ Tech Stack & Current Status

This project is being built as a multi-language, microservice-based application.

| Service | Language / Framework | Status |
| :--- | :--- | :--- |
| **Main Backend** | Java (Spring Boot) | ✅ **Functional** |
| **Database** | PostgreSQL (Docker) | ✅ **Functional** |
| **Frontend** | React (JavaScript) | 🔜 **Up Next** |
| **AI Service** | Python (FastAPI) | 📋 **Planned** |

---

## 🚀 How to Run Locally (Backend Only)

You can currently run the Java backend and its PostgreSQL database.

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/kalebhings/aura-journal-ai.git](https://github.com/kalebhings/aura-journal-ai.git)
    cd aura-journal-ai
    ```

2.  **Ensure Docker Desktop is running.**

3.  **Start the database container:**
    From the root `aura-journal-ai` folder, run:
    ```sh
    docker-compose up -d
    ```
    *(This will start the PostgreSQL database in the background).*

4.  **Run the Java Backend:**
    * Open the `services/main-backend` project in IntelliJ.
    * Run the `MainBackendApplication.java` file.
    * The server will start on `http://localhost:8080`.

5.  **Test the API:**
    * The `requests.http` file in the project is configured to test the running API endpoints.