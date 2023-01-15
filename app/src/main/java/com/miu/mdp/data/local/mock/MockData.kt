package com.miu.mdp.data.local.mock

import com.miu.mdp.data.local.entity.QuizEntity

// default 15 android quiz questions list
fun defaultQuizQuestions() = listOf<QuizEntity>(
    QuizEntity(
        id = 1,
        question = "Android is ______",
        options = listOf("Operating System", "Application", "Language", "SDK"),
        answer = "a",
    ),
    QuizEntity(
        id = 2,
        question = "Under which of the following Android is licensed?",
        options = listOf("OSS", "Sourceforge", "Apache/MIT", "None of the above"),
        answer = "c",
    ),
    QuizEntity(
        id = 3,
        question = "Which of the following is not a component of Android?",
        options = listOf("Content Provider", "Intent", "Service", "None of the above"),
        answer = "b",
    ),
    QuizEntity(
        id = 4,
        question = "Which of the following is not a layout in Android?",
        options = listOf("TableLayout", "GridLayout", "LinearLayout", "None of the above"),
        answer = "d",
    ),
    QuizEntity(
        id = 5,
        question = "What does API stand for?",
        options = listOf(
            "Application Programming Interface",
            "Android Programming Interface",
            "Android Page Interface",
            "Application Page Interface"
        ),
        answer = "a",
    ),
    QuizEntity(
        id = 6,
        question = "APK stands for ______",
        options = listOf(
            "Android Package Kit",
            "Android Package Key",
            "Android Package Kernel",
            "Android Package Keep"
        ),
        answer = "a",
    ),
    QuizEntity(
        id = 7,
        question = "Which of the following is not a type of Intent?",
        options = listOf("Explicit Intent", "Implicit Intent", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 8,
        question = "What phrase means that the compiler validates types while compiling?",
        options = listOf("Type Safety", "Data Binding", "Type Validation", "Wrong Text"),
        answer = "a",
    ),
    QuizEntity(
        id = 9,
        question = "Which of the following is not a type of Broadcast Receiver?",
        options = listOf(
            "Ordered Broadcast",
            "Sticky Broadcast",
            "None of the above",
            "Both a and b"
        ),
        answer = "c",
    ),
    QuizEntity(
        id = 10,
        question = "A ___ represents, by default the items in a row or column when using a GridLayout.",
        options = listOf("grid", "layout", "list", "span"),
        answer = "d",
    ),
    QuizEntity(
        id = 11,
        question = "To keep the UI running smoothly, use ___ for long running tasks, such as all database operations.",
        options = listOf("Coroutines", "ViewModels", "Returns", "Managed Threads"),
        answer = "a",
    ),
    QuizEntity(
        id = 12,
        question = "What is the minimum API level required to use Android's ConstraintLayout?",
        options = listOf("API 14", "API 15", "API 16", "API 17"),
        answer = "c",
    ),
    QuizEntity(
        id = 13,
        question = "What is the base class for all Android views?",
        options = listOf("View", "ViewGroup", "TextView", "LinearLayout"),
        answer = "a",
    ),

    QuizEntity(
        id = 14,
        question = "Which of the following is not a valid resource type in Android?",
        options = listOf("drawable", "string", "layout", "widget"),
        answer = "d",
    ),
    QuizEntity(
        id = 15,
        question = "Which of the following is not a valid layout attribute in Android?",
        options = listOf("layout_width", "layout_height", "layout_margin", "layout_padding"),
        answer = "d",
    ),
)
