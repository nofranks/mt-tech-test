package org.olly.matillion.foodmart.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

    private Integer id;
    private String fullname;
    private String firstname;
    private String lastname;
    private Integer storeId;
    private Integer departmentId;

    private LocalDate birthDate;
    private Double salary;
    private String educationLevel;
    private String maritalStatus;
    private String gender;

    private Integer positionId;
    private String positionTitle;
    private LocalDateTime hireDate;
    private LocalDateTime endDate;
    private Integer supervisorId;
    private String managementRole;

    public Employee(){
        super();
    }

    /*

    `employee_id` int(11) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `position_id` int(11) DEFAULT NULL,
  `position_title` varchar(30) DEFAULT NULL,
  `store_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `hire_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `salary` decimal(10,4) NOT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `education_level` varchar(30) NOT NULL,
  `marital_status` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `management_role` varchar(30) DEFAULT NULL,
     */
/*
    public static class EmployeeBuilder {
        private Employee employeeToBuild;




        public EmployeeBuilder(Integer id, String fullname, String firstname, String lastname, Integer storeId, LocalDate birthDate, Double salary, String educationLevel, String maritalStatus, String gender) {
            this.id = id;
            this.fullname = fullname;
            this.firstname = firstname;
            this.lastname = lastname;
            this.storeId = storeId;
            this.birthDate = birthDate;
            this.salary = salary;
            this.educationLevel = educationLevel;
            this.maritalStatus = maritalStatus;
            this.gender = gender;
        }

        public EmployeeBuilder setPositionId(Integer positionId) {
            this.positionId = positionId;
            return this;
        }

        public EmployeeBuilder setPositionTitle(String positionTitle) {
            this.positionTitle = positionTitle;
            return this;
        }

        public EmployeeBuilder setHireDate(LocalDateTime hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public EmployeeBuilder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public EmployeeBuilder setSupervisorId(Integer supervisorId) {
            this.supervisorId = supervisorId;
            return this;
        }

        public EmployeeBuilder setManagementRole(String managementRole) {
            this.managementRole = managementRole;
            return this;
        }
    }

*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getManagementRole() {
        return managementRole;
    }

    public void setManagementRole(String managementRole) {
        this.managementRole = managementRole;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", storeId=" + storeId +
                ", departmentId=" + departmentId +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", educationLevel='" + educationLevel + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", gender='" + gender + '\'' +
                ", positionId=" + positionId +
                ", positionTitle='" + positionTitle + '\'' +
                ", hireDate=" + hireDate +
                ", endDate=" + endDate +
                ", supervisorId=" + supervisorId +
                ", managementRole='" + managementRole + '\'' +
                '}';
    }
}
