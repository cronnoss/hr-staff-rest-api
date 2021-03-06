CREATE TABLE IF NOT EXISTS department
(
    depid           serial      NOT NULL,
    department_name varchar(25) NOT NULL UNIQUE,
    CONSTRAINT departments_pk PRIMARY KEY (depid)
);

CREATE TABLE IF NOT EXISTS position
(
    posid         serial       NOT NULL,
    depid         serial       NOT NULL,
    position_name varchar(255) NOT NULL,
    CONSTRAINT fk_position_depid FOREIGN KEY (depid) REFERENCES department (depid) ON DELETE CASCADE,
    CONSTRAINT positions_pk PRIMARY KEY (posid)
);

CREATE TABLE IF NOT EXISTS employee
(
    empid         serial       NOT NULL,
    full_name     varchar(255) NOT NULL,
    date_of_birth timestamptz default CURRENT_TIMESTAMP,
    salary        integer      NOT NULL,
    CONSTRAINT employees_pk PRIMARY KEY (empid)
);

CREATE TABLE IF NOT EXISTS positions_employees
(
    posid serial NOT NULL,
    empid serial NOT NULL,
    CONSTRAINT fk_positions_employees_posid FOREIGN KEY (posid) REFERENCES position (posid) ON DELETE CASCADE,
    CONSTRAINT fk_positions_employees_empid FOREIGN KEY (empid) REFERENCES employee (empid) ON DELETE CASCADE,
    PRIMARY KEY (posid, empid)
);