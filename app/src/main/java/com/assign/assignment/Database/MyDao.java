package com.assign.assignment.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao
{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addUser(PostDB postDB);

    @Query("select * from PostDB")
    public List<PostDB> getPosts();

    @Delete
    public void deletePosts(PostDB postDB);

    @Update
    public void updatePosts(PostDB postDB);


}