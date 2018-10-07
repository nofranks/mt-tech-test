-- noinspection SqlNoDataSourceInspectionForFile


CREATE TABLE employee (
  employee_id int NOT NULL,
  full_name varchar(30) NOT NULL,
  first_name varchar(30) NOT NULL,
  last_name varchar(30) NOT NULL,
  position_id int DEFAULT NULL,
  position_title varchar(30) DEFAULT NULL,
  store_id int NOT NULL,
  department_id int NOT NULL,
  birth_date date NOT NULL,
  hire_date datetime DEFAULT NULL,
  end_date datetime DEFAULT NULL,
  salary decimal(10,4) NOT NULL,
  supervisor_id int DEFAULT NULL,
  education_level varchar(30) NOT NULL,
  marital_status varchar(30) NOT NULL,
  gender varchar(30) NOT NULL,
  management_role varchar(30) DEFAULT NULL,
  PRIMARY KEY  (employee_id)
);

CREATE TABLE department (
  department_id int NOT NULL,
  department_description varchar(30) NOT NULL,
  PRIMARY KEY (department_id)
);

CREATE TABLE position (
  position_id int NOT NULL,
  position_title varchar(30) NOT NULL,
  pay_type varchar(30) NOT NULL,
  min_scale decimal(10,4) NOT NULL,
  max_scale decimal(10,4) NOT NULL,
  management_role varchar(30) NOT NULL,
  PRIMARY KEY (position_id)
)