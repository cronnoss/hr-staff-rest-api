package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entity.Department;
import com.cronnoss.hrstaffrestapi.entity.Employee;
import com.cronnoss.hrstaffrestapi.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
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

//            Employee emp = session.get(Employee.class, 7);
//            session.delete(emp);

            session.createQuery("DELETE Employee " +
                    "where  salary = 400").executeUpdate();

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}