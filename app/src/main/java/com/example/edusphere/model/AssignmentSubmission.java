// AssignmentSubmission.java
package com.example.edusphere.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assignment_submissions")
public class AssignmentSubmission {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int assignmentId;
    private int studentId;
    private String filePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
