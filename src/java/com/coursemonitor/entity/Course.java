package com.coursemonitor.entity;
// Generated Feb 23, 2016 2:24:40 PM by Hibernate Tools 4.3.1



/**
 * Course generated by hbm2java
 */
public class Course  implements java.io.Serializable {


     private String courseId;
     private CourseLeader courseLeader;
     private String courseName;
     private String academicSession;

    public Course() {
    }

	
    public Course(String courseId) {
        this.courseId = courseId;
    }
    public Course(String courseId, CourseLeader courseLeader, String courseName, String academicSession) {
       this.courseId = courseId;
       this.courseLeader = courseLeader;
       this.courseName = courseName;
       this.academicSession = academicSession;
    }
   
    public String getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public CourseLeader getCourseLeader() {
        return this.courseLeader;
    }
    
    public void setCourseLeader(CourseLeader courseLeader) {
        this.courseLeader = courseLeader;
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getAcademicSession() {
        return this.academicSession;
    }
    
    public void setAcademicSession(String academicSession) {
        this.academicSession = academicSession;
    }




}


