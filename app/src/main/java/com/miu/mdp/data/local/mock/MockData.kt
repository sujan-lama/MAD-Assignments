package com.miu.mdp.data.local.mock

import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.model.User

fun getUserDetailMock(user: User) = UserDetailEntity(
    email = user.username,
    id = 0,
    image = "https://www.w3schools.com/howto/img_avatar.png",
    position = "Software Engineer",
    contact = Contact(
        phone = "N/A",
        email = user.username,
        linkedIn = "N/A",
        github = "N/A",
        pdf = "N/A"
    ),
    aboutMe = "I am a software engineer with 3 years of experience in Android development. I am passionate about building mobile applications that are easy to use and provide a great user experience. I am also interested in building web applications using the latest technologies. I am a quick learner and I am always looking for new challenges.",

    experienceMap = hashMapOf(
        "Languages" to listOf("Kotlin", "Java", "JavaScript", "Python", "C++"),
        "Frameworks/Web" to listOf(
            "Android",
            "Spring Boot",
            "React",
            "Node.js",
            "Express.js",
            "Django"
        ),
        "Microservices" to listOf("Docker", "Kubernetes", "AWS", "Azure", "GCP"),
        "Databases" to listOf("MySQL", "MongoDB", "PostgreSQL", "Redis", "SQLite"),
        "Tools" to listOf("Git", "Jira", "Confluence", "Slack", "Trello"),
    ),
    careerNote = "Completed on-campus studies and currently taking distance education courses to complete a Master's degree in Computer Science (Available for full-time, W-2 employment)."
)


