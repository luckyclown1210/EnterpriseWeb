/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coursemonitor.model;

import com.coursemonitor.entity.CourseLeader;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nghia
 */
public class CourseLeaderDao {

    public List<CourseLeader> getCourseLeader() {
        List<CourseLeader> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from CourseLeader";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }
}
