INSERT INTO departments
    (name)
VALUES
    ('HR'),
    ('Sales'),
    ('Tech')
;

INSERT INTO employees
    (fname, lname, phonenumber, department_id, salary, hire_date)
VALUES
    ('James', 'Smith', '1234567890', 1, 1000, '2002-01-01'),
    ('John', 'Johnson', '2468101214', 1, 400, '2005-03-23'),
    ('Michael', 'Williams', '1357911131', 2, 600, '2009-05-12'),
    ('Johnathon', 'Smith', '1212121212', 1, 500, '2016-07-24')
;

INSERT INTO customers
    (fname, lname, email, phonenumber, preferred_contact)
VALUES
    ('William', 'Jones', 'william.jones@example.com', '3347927472', 'PHONE'),
    ('David', 'Miller', 'dmiller@example.net', '2137921892', 'EMAIL'),
    ('Richard', 'Davis', 'richard0123@example.com', NULL, 'EMAIL')
;

INSERT INTO cars
    (customer_id, employee_id, model, status, total_cost)
VALUES
    (1, 2, 'Ford F-150', 'READY', 230),
    (1, 2, 'Ford F-150', 'READY', 200),
    (2, 1, 'Ford Mustang', 'WAITING', 100),
    (3, 3, 'Toyota Prius', 'WORKING', 1254)
;