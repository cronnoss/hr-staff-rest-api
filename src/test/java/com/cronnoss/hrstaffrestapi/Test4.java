package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entities.Department;
import com.cronnoss.hrstaffrestapi.entities.Employee;
import com.cronnoss.hrstaffrestapi.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Position.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);

            session.createQuery("update Employee set salary =1000 " +
                    "where fullName = 'Mark'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}