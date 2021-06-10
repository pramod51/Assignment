package com.assign.assignment.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "languageDB")
public class LanguageDB {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "nativeName")
    private String nativeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
}
