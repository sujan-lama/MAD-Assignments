package com.miu.mdp.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.miu.mdp.domain.model.Certification
import com.miu.mdp.domain.model.Contact
import com.miu.mdp.domain.model.Education
import com.miu.mdp.domain.model.Experience

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
    fun fromCertificationToString(certification: List<Certification>): String {
        val gson = Gson()
        return gson.toJson(certification)
    }

    @TypeConverter
    @JvmStatic
    fun toCertificationFromString(value: String): List<Certification> {
        val listType = object : TypeToken<List<Certification>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromEducationToString(education: List<Education>): String {
        val gson = Gson()
        return gson.toJson(education)
    }

    @TypeConverter
    @JvmStatic
    fun toEducationFromString(value: String): List<Education> {
        val listType = object : TypeToken<List<Education>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromExperienceToString(experience: List<Experience>): String {
        val gson = Gson()
        return gson.toJson(experience)
    }

    @TypeConverter
    @JvmStatic
    fun toExperienceFromString(value: String): List<Experience> {
        val listType = object : TypeToken<List<Experience>>() {}.type
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