CREATE TABLE departments (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(35) NOT NULL,
    lname VARCHAR(35) NOT NULL,
    phonenumber VARCHAR(11),
    department_id INT NOT NULL,
    salary FLOAT NOT NULL,
    hire_date DATETIME NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(35) NOT NULL,
    lname VARCHAR(35) NOT NULL,
    email varchar(100) NOT NULL,
    phonenumber VARCHAR(11),
    preferred_contact VARCHAR(5) NOT NULL,
    PRIMARY KEY(Id)
);

CREATE TABLE cars (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    model varchar(50) NOT NULL,
    status varchar(25) NOT NULL,
    total_cost FLOAT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);