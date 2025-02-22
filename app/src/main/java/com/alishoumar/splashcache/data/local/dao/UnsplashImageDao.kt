package com.alishoumar.splashcache.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alishoumar.splashcache.data.models.UnSplashImage


@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM unsplash_image_table")
    suspend fun getAllImages():PagingSource<Int, UnSplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnSplashImage>)

    @Query("DELETE FROM unsplash_image_table")
    suspend fun deleteImage()
}