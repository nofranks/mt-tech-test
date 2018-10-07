package org.olly.matillion.foodmart.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {

    //required fields
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

    //optional fields
    private Integer positionId;
    private String positionTitle;
    private LocalDateTime hireDate;
    private LocalDateTime endDate;
    private Integer supervisorId;
    private String managementRole;

    public Employee(){
        super();
    }

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


    public static class EmployeeBuilder {
        private Employee employeeToBuild;

        private EmployeeBuilder(){
            employeeToBuild = new Employee();
        }

        public static EmployeeBuilder getInstance(){
            return new EmployeeBuilder();
        }

        public Employee build(){
            return this.employeeToBuild;
        }

        public  EmployeeBuilder id(Integer id) {
            this.employeeToBuild.setId(id);
            return this;
        }

        public  EmployeeBuilder fullname(String fullname) {
            this.employeeToBuild.setFullname(fullname);
            return this;
        }

        public  EmployeeBuilder firstname(String firstname) {
            this.employeeToBuild.setFirstname(firstname);
            return this;
        }

        public  EmployeeBuilder lastname(String lastname) {
            this.employeeToBuild.setLastname(lastname);
            return this;
        }

        public  EmployeeBuilder storeId(Integer storeId) {
            this.employeeToBuild.setStoreId(storeId);
            return this;
        }

        public  EmployeeBuilder birthDate(LocalDate birthDate) {
            this.employeeToBuild.setBirthDate(birthDate);
            return this;
        }

        public  EmployeeBuilder salary(Double salary) {
            this.employeeToBuild.setSalary(salary);
            return this;
        }

        public  EmployeeBuilder educationLevel(String educationLevel) {
            this.employeeToBuild.setEducationLevel(educationLevel);
            return this;
        }

        public  EmployeeBuilder maritalStatus(String maritalStatus) {
            this.employeeToBuild.setMaritalStatus(maritalStatus);
            return this;
        }

        public  EmployeeBuilder gender(String gender) {
            this.employeeToBuild.setGender(gender);
            return this;
        }

        public  EmployeeBuilder positionId(Integer positionId) {
            this.employeeToBuild.setPositionId(positionId);
            return this;
        }

        public  EmployeeBuilder positionTitle(String positionTitle) {
            this.employeeToBuild.setPositionTitle(positionTitle);
            return this;
        }

        public  EmployeeBuilder hireDate(LocalDateTime hireDate) {
            this.employeeToBuild.setHireDate(hireDate);
            return this;
        }

        public  EmployeeBuilder endDate(LocalDateTime endDate) {
            this.employeeToBuild.setEndDate(endDate);
            return this;
        }

        public  EmployeeBuilder supervisorId(Integer supervisorId) {
            this.employeeToBuild.setSupervisorId(supervisorId);
            return this;
        }

        public  EmployeeBuilder managementRole(String managementRole) {
            this.employeeToBuild.setManagementRole(managementRole);
            return this;
        }

        public  EmployeeBuilder departmentId(Integer departmentId) {
            this.employeeToBuild.setDepartmentId(departmentId);
            return this;
        }
    }
}
