package com.miu.mdp.data.local.dao

import androidx.room.*

interface BaseDAO<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: T)

    @Insert
    fun insert(entities: List<T>)

    @Update
    fun update(entity: T)

    @Update
    fun update(entities: List<T>)

    @Delete
    fun delete(entity: T)

    @Delete
    fun delete(entities: List<T>)

}