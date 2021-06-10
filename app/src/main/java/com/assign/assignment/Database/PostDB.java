package com.assign.assignment.Database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.assign.assignment.Languages;

import java.util.ArrayList;
import java.util.List;


@Entity(tableName = "postDB")
public class PostDB {

    @NonNull
    @PrimaryKey()
    private String name;
    @ColumnInfo(name = "capital")
    private String capital;
    @ColumnInfo(name = "region")
    private String region;
    @ColumnInfo(name = "subregion")
    private String subregion;
    @ColumnInfo(name = "population")
    private String population;
    @ColumnInfo(name = "flag")
    private String flag;
    //@ColumnInfo(name = "borders")
    //private List<String> borders;
    //@ColumnInfo(name = "language")
    //private ArrayList<Languages> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /*public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }*/

    /*public ArrayList<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Languages> languages) {
        this.languages = languages;
    }*/
}
