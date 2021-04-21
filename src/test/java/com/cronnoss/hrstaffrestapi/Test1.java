package com.cronnoss.hrstaffrestapi;

import com.cronnoss.hrstaffrestapi.entity.Department;
import com.cronnoss.hrstaffrestapi.entity.Employee;
import com.cronnoss.hrstaffrestapi.entity.Position;
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

            emp1.addPositionToEmployee(pos1);
            emp2.addPositionToEmployee(pos2);
            emp3.addPositionToEmployee(pos3);
            emp3.addPositionToEmployee(pos2);
            emp4.addPositionToEmployee(pos4);
            emp5.addPositionToEmployee(pos4);
            emp6.addPositionToEmployee(pos5);
            emp6.addPositionToEmployee(pos3);

            session.beginTransaction();

            session.persist(dep1);
            session.persist(dep2);
            session.persist(dep3);

            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);
            session.persist(emp4);
            session.persist(emp5);
            session.persist(emp6);

//            Employee employee = session.get(Employee.class, 6);
//            session.delete(employee);

//            Position position = session.get(Position.class, 4);
//            session.delete(position);

//            Department department = session.get(Department.class, 2);
//            session.delete(department);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}