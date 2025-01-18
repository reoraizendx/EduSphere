// Module.java
package com.example.edusphere.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "modules")
public class Module {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int courseId;
    private String title;
    private String fileUrl;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
}
