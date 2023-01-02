package com.miu.mdp.data.local.mock

import com.miu.mdp.data.local.entity.QuizEntity

// default 15 android quiz questions list
fun defaultQuizQuestions() = listOf<QuizEntity>(
    QuizEntity(
        id = 1,
        question = "1. Android is ______",
        options = listOf("Operating System", "Application", "Language", "SDK"),
        answer = "a",
    ),
    QuizEntity(
        id = 2,
        question = "2. Under which of the following Android is licensed?",
        options = listOf("OSS", "Sourceforge", "Apache/MIT", "None of the above"),
        answer = "c",
    ),
    QuizEntity(
        id = 3,
        question = "3. Which of the following is not a component of Android?",
        options = listOf("Content Provider", "Intent", "Service", "None of the above"),
        answer = "b",
    ),
    QuizEntity(
        id = 4,
        question = "4. Which of the following is not a layout in Android?",
        options = listOf("TableLayout", "GridLayout", "LinearLayout", "None of the above"),
        answer = "d",
    ),
    QuizEntity(
        id = 5,
        question = "5. What does API stand for?",
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
        question = "6. APK stands for ______",
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
        question = "7. Which of the following is not a type of Intent?",
        options = listOf("Explicit Intent", "Implicit Intent", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 8,
        question = "8. Which of the following is not a type of Service?",
        options = listOf("Started Service", "Bound Service", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 9,
        question = "9. Which of the following is not a type of Broadcast Receiver?",
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
        question = "10. Which of the following is not a type of Content Provider?",
        options = listOf("Single Process", "Multi Process", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 11,
        question = "11.Which of the following is not an activity lifecycle callback method?",
        options = listOf("onCreate()", "onStart()", "onResume()", "onBack()"),
        answer = "d",
    ),
    QuizEntity(
        id = 12,
        question = "12. What is the minimum API level required to use Android's ConstraintLayout?",
        options = listOf("API 14", "API 15", "API 16", "API 17"),
        answer = "c",
    ),
    QuizEntity(
        id = 13,
        question = "13. What is the base class for all Android views?",
        options = listOf("View", "ViewGroup", "TextView", "LinearLayout"),
        answer = "1",
    ),

    QuizEntity(
        id = 14,
        question = "14. Which of the following is not a valid resource type in Android?",
        options = listOf("drawable", "string", "layout", "widget"),
        answer = "d",
    ),
    QuizEntity(
        id = 15,
        question = "15. Which of the following is not a valid layout attribute in Android?",
        options = listOf("layout_width", "layout_height", "layout_margin", "layout_padding"),
        answer = "d",
    ),
)
