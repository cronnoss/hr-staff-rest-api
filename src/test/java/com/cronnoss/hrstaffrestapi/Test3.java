package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entity.Department;
import com.cronnoss.hrstaffrestapi.entity.Employee;
import com.cronnoss.hrstaffrestapi.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
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

//            List<Employee> emps = session.createQuery("from Employee")
//                    .getResultList();

            List<Employee> emps = session.createQuery("from Employee " +
                    "WHERE fullName = 'Mark'")
                    .getResultList();

            for (Employee e : emps)
                System.out.println(e);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}