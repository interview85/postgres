create sequence hibernate_sequence start 1 increment 1;

create table department
(
    dep_id int8 not null,
    name   varchar(255),
    primary key (dep_id)
);
create table domain
(
    dom_id int8 not null,
    name   varchar(255),
    primary key (dom_id)
);
create table employee
(
    emp_id int8 not null,
    name   varchar(255),
    dep_id int8,
    primary key (emp_id)
);
create table employee_project
(
    prj_id int8 not null,
    emp_id int8 not null,
    primary key (emp_id, prj_id)
);
create table project
(
    prj_id int8 not null,
    name   varchar(255),
    dom_id int8,
    primary key (prj_id)
);

alter table if exists employee
    add constraint employee_department_fk foreign key (dep_id) references department;
alter table if exists employee_project
    add constraint employee_project_employee_fk foreign key (emp_id) references employee;
alter table if exists employee_project
    add constraint employee_project_project_fk foreign key (prj_id) references project;
alter table if exists project
    add constraint project_domain_fk foreign key (dom_id) references domain;
