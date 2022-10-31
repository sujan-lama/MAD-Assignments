package com.miu.mdp.data.mock

import com.miu.mdp.data.local.entity.UserDetailEntity
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.model.Education
import com.miu.mdp.domain.model.Experience

fun getFakeUserDetail(username: String) = UserDetailEntity(
    id = 0,
    image = "https://www.w3schools.com/howto/img_avatar.png",
    email = username,
    position = "Software Engineer",
    contact = Contact(
        "641-233-2121",
        "sujan-lama",
        "sujan-lama",
        ""
    ),
    education = listOf(
        Education(
            "Master of Science",
            "Computer Science",
            "University of Minnesota",
            "2019",
            "2021"
        ),
        Education(
            "Bachelor of Science",
            "Computer Science",
            "University of Minnesota",
            "2015",
            "2019"
        )
    ),
    certification = listOf(
        Certification(
            certificationName = "OCA Java SE 8 Programmer I",
            image = "",
            certificationAuthority = "Google",
            certificationDate = "2019",
        ),
        Certification(
            certificationName = "iOS Developer",
            certificationAuthority = "Apple",
            certificationDate = "2019",
            image = ""
        )
    ),
    aboutMe = "I am a software developer with 5 years of experience in Android development. I have worked on multiple projects and have experience in developing mobile applications from scratch. I am a quick learner and have a passion for learning new technologies. I am looking for a challenging position where I can utilize my skills and knowledge to the fullest.",
    experience = listOf(
        Experience(
            companyName = "Google",
            position = "Android Developer",
            startDate = "2020",
            endDate = "present",
            description = "Developing android apps",
            image = ""
        ),
        Experience(
            companyName = "Apple",
            position = "iOS Developer",
            startDate = "2017",
            endDate = "2020",
            description = "Developing iOS apps",
            image = ""
        )
    ),

    careerNote = "Completed on-campus studies and currently taking distance education courses to complete a Master's degree in Computer Science (Available for full-time, W-2 employment).",
    experienceMap = hashMapOf(
        "Languages" to listOf("Java", "Kotlin", "Swift"),
        "Frameworks/Web" to listOf("Spring(Boot)", "Android", "iOS", "React", "Node.js"),
        "Databases" to listOf("MySQL", "MongoDB", "SQLite"),
        "Tools" to listOf(
            "IntelliJ IDEA",
            "Android Studio",
            "Xcode",
            "Visual Studio Code",
            "Git",
            "GitHub",
            "Jira"
        )
    ),
)
