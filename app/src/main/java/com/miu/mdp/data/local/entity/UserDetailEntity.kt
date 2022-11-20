package com.miu.mdp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.miu.mdp.domain.model.Contact

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
    @ColumnInfo(index = true)
    val email: String,
    val position: String,
    val contact: Contact,
    val aboutMe: String,
    val careerNote: String,
    val experienceMap: HashMap<String, List<String>>
)