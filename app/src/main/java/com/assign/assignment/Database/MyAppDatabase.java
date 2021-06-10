package com.assign.assignment.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PostDB.class},version = 1,exportSchema = true)


public abstract class MyAppDatabase extends RoomDatabase
{

    public abstract MyDao myDao();
}