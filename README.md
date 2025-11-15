# Aura: The AI Reflection Engine

> An intelligent, private, and multimodal journaling application designed to make self-reflection effortless and insightful.

This repository contains the source code for Aura. **Phase 2 of development is complete.** The application now features a full-stack, multi-language architecture where the frontend, backend, and AI microservice are all fully integrated for sentiment analysis.

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
| **AI Service** | Python (FastAPI) | ✅ **Functional (Phase 2)** |
| **File Storage** | AWS S3 | 🔜 **Up Next** |

---

## 🚀 How to Run Locally

You can now run the complete, integrated stack (Frontend + Backend + AI Service + Database).

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

4.  **Run the Java Backend (Terminal 1):**
    * Open the `services/main-backend` project in IntelliJ.
    * Run the `MainBackendApplication.java` file.
    * The server will start on `http://localhost:8080`.

5.  **Run the React Frontend (Terminal 2):**
    * Open a new terminal.
    * Navigate to the `services/frontend` directory.
    * Run `npm install` (if you haven't already, only needed the first time.).
    * Run `npm start`.
    * Your browser will automatically open to `http://localhost:3000`.

6.  **Set up the Python AI Service (One-Time Setup):**
    * Open a third terminal.
    * Navigate to the `services/ai-service` directory.
    * Create a virtual environment: `python -m venv venv`
    * Activate the virtual environment:
        * **Windows:** `.\venv\Scripts\activate`
        * **Mac/Linux:** `source venv/bin/activate`
    * Install the required packages: `pip install -r requirements.txt`

7.  **Run the Python AI Service (Terminal 3):**
    * Make sure your virtual environment is still active (your prompt should start with `(venv)`, activate it if needed).
    * From the `services/ai-service` directory, run the server:
    * `uvicorn app.main:app --reload --port 8000`

8.  **Use the Application:**
    * You can now use the web app in your browser to save journal entries, and the sentiment will be automatically analyzed and saved.