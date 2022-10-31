package com.miu.mdp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.model.Education
import com.miu.mdp.domain.model.Experience

@Entity(
    tableName = "userDetail",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["username"],
        childColumns = ["email"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class UserDetailEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: String,
    val email: String,
    val position: String,
    val contact: Contact,
    val education: List<Education>,
    val certification: List<Certification>,
    val aboutMe: String,
    val experience: List<Experience>,
    val careerNote: String,
    val experienceMap: HashMap<String, List<String>>
)