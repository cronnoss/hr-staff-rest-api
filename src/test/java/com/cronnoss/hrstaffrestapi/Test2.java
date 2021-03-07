package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entities.Department;
import com.cronnoss.hrstaffrestapi.entities.Employee;
import com.cronnoss.hrstaffrestapi.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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

            Department dep = new Department("Support");
            Position pos = new Position("technical support specialist");
            Employee emp = new Employee("Semen", java.sql.Timestamp.valueOf("1999-06-06 04:00:00"), 300);

            dep.addPositionToDepartment(pos);
            emp.addPositionToEmployee(pos);

            session.beginTransaction();

            session.persist(dep);
            session.persist(emp);

            session.getTransaction().commit();

            int myID = emp.getEmpid();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myID);
            session.getTransaction().commit();
            System.out.println("Added employee: " + employee);

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}