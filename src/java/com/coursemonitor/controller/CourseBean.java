/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coursemonitor.controller;

import com.coursemonitor.entity.Course;
import com.coursemonitor.entity.CourseLeader;
import com.coursemonitor.model.CourseDao;
import com.coursemonitor.model.CourseLeaderDao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author Nghia
 */
@ManagedBean(name = "courseBean", eager = true)
@RequestScoped
public class CourseBean {

   
    private List<Course> list;
    private String cid;
    private String cname;
    private String academicSession;
    private CourseLeader cl;
    private String search;
    private Part image;

    public String saveCourse() {
        CourseDao stud = new CourseDao();
        Course c = new Course(cid, cl, cname, academicSession);
        stud.save(c);
        System.out.println("User successfully saved.");
        return "index";
    }
    
    public List<Course> searchCourse()
    {
            CourseDao cd = new CourseDao();
            return cd.searchCourse(search);

    }

    public List<Course> getAllCourse() {
        CourseDao cd = new CourseDao();
        return  cd.getCourse();
    }

    public List<CourseLeader> getAllLeader() {
        CourseLeaderDao cld = new CourseLeaderDao();
        return cld.getCourseLeader();
    }

 

    public String getAllLeaderName() {
        return cl.getClName();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAcademicSession() {
        return academicSession;
    }

    public void setAcademicSession(String academicSession) {
        this.academicSession = academicSession;
    }

    public CourseLeader getCl() {
        return cl;
    }

    public void setCl(CourseLeader cl) {
        this.cl = cl;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Course> getList() {
        if (search == null || search == "") list = getAllCourse();
        else list = searchCourse();
        return list;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    
    
    public String upload() throws IOException {
         InputStream inputStream = image.getInputStream();        
        FileOutputStream outputStream = new FileOutputStream(getFilename(image));
        
        byte[] buffer = new byte[4096];        
        int bytesRead = 0;
        while(true) {                        
            bytesRead = inputStream.read(buffer);
            if(bytesRead > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }else {
                break;
            }                       
        }
        outputStream.close();
        inputStream.close();
       
        return "success";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
    
    public CourseBean() {
    }

}
