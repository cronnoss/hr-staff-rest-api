INSERT INTO department (depid, department_name)
VALUES ('1', 'IT'),
       ('2', 'Sales'),
       ('3', 'HR');

INSERT INTO position (posid, depid, position_name)
VALUES ('1', '1', 'developer'),
       ('2', '1', 'designer'),
       ('3', '2', 'manager'),
       ('4', '2', 'salesman'),
       ('5', '3', 'recruiter');

INSERT INTO employee (empid, full_name, date_of_birth, salary)
VALUES ('1', 'Egor', '2001-09-29 00:00:00', '700'),
       ('2', 'Sergey', '1994-05-04 00:00:00', '600'),
       ('3', 'Mark', '1997-12-17 00:00:00', '600'),
       ('4', 'Andrey', '1993-10-23 00:00:00', '400'),
       ('5', 'Boris', '2002-01-30 00:00:00', '400'),
       ('6', 'Irina', '1990-04-21 00:00:00', '900');

INSERT INTO positions_employees (posid, empid)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '3'),
       ('2', '3'),
       ('4', '4'),
       ('4', '5'),
       ('5', '6'),
       ('3', '6');