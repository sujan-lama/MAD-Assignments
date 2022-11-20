package com.miu.mdp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.miu.mdp.domain.model.CertificationDTO
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.model.EducationDTO
import com.miu.mdp.domain.model.ExperienceDTO

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromArrayList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringToHashMap(value: String): HashMap<String, List<String>> {
        val listType = object : TypeToken<HashMap<String, List<String>>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromHashMapToString(map: HashMap<String, List<String>>): String {
        val gson = Gson()
        return gson.toJson(map)
    }

    @TypeConverter
    @JvmStatic
    fun fromCertificationToString(certificationDTO: List<CertificationDTO>): String {
        val gson = Gson()
        return gson.toJson(certificationDTO)
    }

    @TypeConverter
    @JvmStatic
    fun toCertificationFromString(value: String): List<CertificationDTO> {
        val listType = object : TypeToken<List<CertificationDTO>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromEducationToString(educationDTO: List<EducationDTO>): String {
        val gson = Gson()
        return gson.toJson(educationDTO)
    }

    @TypeConverter
    @JvmStatic
    fun toEducationFromString(value: String): List<EducationDTO> {
        val listType = object : TypeToken<List<EducationDTO>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromExperienceToString(experienceDTO: List<ExperienceDTO>): String {
        val gson = Gson()
        return gson.toJson(experienceDTO)
    }

    @TypeConverter
    @JvmStatic
    fun toExperienceFromString(value: String): List<ExperienceDTO> {
        val listType = object : TypeToken<List<ExperienceDTO>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromContactToString(contact: Contact): String {
        val gson = Gson()
        return gson.toJson(contact)
    }

    @TypeConverter
    @JvmStatic
    fun toContactFromString(value: String): Contact {
        val listType = object : TypeToken<Contact>() {}.type
        return Gson().fromJson(value, listType)
    }
}