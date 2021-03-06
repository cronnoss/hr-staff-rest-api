package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entities.Department;
import com.cronnoss.hrstaffrestapi.entities.Employee;
import com.cronnoss.hrstaffrestapi.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
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
            Department dep1 = new Department("IT");
            Department dep2 = new Department("Sales");
            Department dep3 = new Department("HR");

            Position pos1 = new Position("developer");
            Position pos2 = new Position("designer");
            Position pos3 = new Position("manager");
            Position pos4 = new Position("salesman");
            Position pos5 = new Position("recruiter");

            Employee emp1 = new Employee("Egor", java.sql.Timestamp.valueOf("2001-09-29 04:00:00"), 700);
            Employee emp2 = new Employee("Sergey", java.sql.Timestamp.valueOf("1994-05-04 04:00:00"), 600);
            Employee emp3 = new Employee("Mark", java.sql.Timestamp.valueOf("1997-12-17 04:00:00"), 600);
            Employee emp4 = new Employee("Andrey", java.sql.Timestamp.valueOf("1993-10-23 04:00:00"), 400);
            Employee emp5 = new Employee("Boris", java.sql.Timestamp.valueOf("2002-01-30 04:00:00"), 400);
            Employee emp6 = new Employee("Irina", java.sql.Timestamp.valueOf("1990-04-21 04:00:00"), 900);

            dep1.addPositionToDepartment(pos1);
            dep1.addPositionToDepartment(pos2);
            dep2.addPositionToDepartment(pos3);
            dep2.addPositionToDepartment(pos4);
            dep3.addPositionToDepartment(pos5);

            pos1.addEmployeeToPosition(emp1);
            pos2.addEmployeeToPosition(emp2);
            pos3.addEmployeeToPosition(emp3);
            pos2.addEmployeeToPosition(emp3);
            pos4.addEmployeeToPosition(emp4);
            pos4.addEmployeeToPosition(emp5);
            pos5.addEmployeeToPosition(emp6);
            pos3.addEmployeeToPosition(emp6);

            session.beginTransaction();
            session.save(dep1);
            session.save(dep2);
            session.save(dep3);
            session.save(pos1);
            session.save(pos2);
            session.save(pos3);
            session.save(pos4);
            session.save(pos5);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}