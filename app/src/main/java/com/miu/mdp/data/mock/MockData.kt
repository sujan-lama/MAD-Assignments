package com.miu.mdp.data.mock

import com.miu.mdp.domain.model.*

fun getMockUserDetail(email: String) = UserDetail(
    image = "https://www.w3schools.com/howto/img_avatar.png",
    email = email,
    position = "Software Engineer",
    contact = Contact(
        "641-233-2121",
        "sujan@gmail.com",
        "sujan-lama",
        "sujan-lama",
        "Sujan Lama"
    ),
    aboutMe = "I am a software developer with 5 years of experience in Android development. I have worked on multiple projects and have experience in developing mobile applications from scratch. I am a quick learner and have a passion for learning new technologies. I am looking for a challenging position where I can utilize my skills and knowledge to the fullest.",
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

fun getMockExperience(email: String) = listOf(
    Experience(
        id = 1,
        companyName = "Google",
        position = "Android Developer",
        startDate = "2020",
        endDate = "present",
        description = "Developing android apps",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        email = email
    ),
    Experience(
        id = 2,
        companyName = "Apple",
        position = "iOS Developer",
        startDate = "2017",
        endDate = "2020",
        description = "Developing iOS apps",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        email = email
    )
)

fun getMockEducation(email: String) = listOf(
    Education(
        schoolName = "University of Iowa",
        degree = "Master of Science",
        startDate = "2017",
        endDate = "2019",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        email = email
    ),
    Education(
        schoolName = "University of Iowa",
        degree = "Bachelor of Science",
        startDate = "2013",
        endDate = "2017",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        email = email
    )
)

fun getMockCertification(email: String) = listOf(
    Certification(
        certificationName = "OCA Java SE 8 Programmer I",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        certificationAuthority = "Google",
        certificationDate = "2019",
        email = email
    ),
    Certification(
        certificationName = "AWS Certified Solutions Architect - Associate",
        certificationAuthority = "Amazon",
        certificationDate = "2019",
        image = "https://www.w3schools.com/howto/img_avatar.png",
        email = email
    )
)