# Aura: The AI Reflection Engine

> An intelligent, private, and multimodal journaling application designed to make self-reflection effortless and insightful.

This repository contains the source code for Aura. **Phase 1 of development is complete**, with a functional full-stack application connecting a React frontend to a Java Spring Boot backend.

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
| **Frontend** | React (JavaScript) | ✅ **Functional (Phase 1)** |
| **AI Service** | Python (FastAPI) | 🔜 **Up Next** |

---

## 🚀 How to Run Locally

You can now run the full-stack application (Frontend + Backend + Database).

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
    * In a terminal, navigate to `services/main-backend`.
    * Open the project in IntelliJ.
    * Run the `MainBackendApplication.java` file.
    * The server will start on `http://localhost:8080`.

5.  **Run the React Frontend:**
    * Open a **new terminal**.
    * Navigate to the `services/frontend` directory.
    * Run `npm install` (only needed the first time).
    * Run `npm start`.
    * Your browser will automatically open to `http://localhost:3000`.

6.  **Use the Application:**
    * You can now use the web app in your browser to save journal entries.
    * You can also still use the `requests.http` file to test the API directly.