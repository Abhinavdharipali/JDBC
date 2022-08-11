package com.wavemaker.training;

import com.wavemaker.training.db.dao.EmployeeDAO;
import com.wavemaker.training.db.model.Employee;
import com.wavemaker.training.db.model.Department;
import com.wavemaker.training.db.dao.DepartmentDAO;

import java.util.List;
import java.util.Scanner;

public class Main {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public  void printEmployee() {
        List<Employee> employeeList = employeeDAO.getListOfStudents();
        if(employeeList != null) {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
    public  void printDepartments() {
        List<Department> listOfDepartments = departmentDAO.getListOfDepartments();
        if(listOfDepartments != null) {
            for (Department department : listOfDepartments) {
                System.out.println(department);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Main Program");
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Employee employee=new Employee();
        int ch=0;
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.DELETE");
            System.out.println("4.UPDATE");
            System.out.print("Enter Your Choice : ");
            ch = s.nextInt();
        switch(ch){
            case 1:

                System.out.print("Enter ID to insert: ");
                employee.setId(s.nextInt());
                System.out.print("Enter Name : ");
                employee.setName(s1.nextLine());
                System.out.print("Enter AGE: ");
                employee.setAge(s.nextInt());
                System.out.print("Enter ADDRESS: ");
                employee.setAddress(s1.nextLine());
                new Main().employeeDAO.createEmployee(employee);
                break;
            case 2:
                System.out.println("----------------------------");
                new Main().printEmployee();
                System.out.println("----------------------------");
                break;
            case 3:
                System.out.print("Enter ID to Delete :");
                employee.setId(s.nextInt());
                System.out.println("----------------------------");
                new Main().employeeDAO.deleteEmployee(employee);

                System.out.println("----------------------------");
            case 4:
                System.out.print("Enter Empno to Update :");

                employee.setId(s.nextInt());
                System.out.print("Enter new Name : ");
                employee.setName(s1.nextLine());
                System.out.print("Enter new Salary : ");
                employee.setAge(s.nextInt());
                System.out.print("Enter ADDRESS to update: ");
                employee.setAddress(s.nextLine());
                new Main().employeeDAO.UpdateEmployee(employee);
        };


//        new Main().printEmployee();
//        new Main().printDepartments();
//        new Main().employeeDAO.createEmployee(new Employee());
//        new Main().employeeDAO.deleteEmployee(new Employee());
//        new Main().employeeDAO.UpdateEmployee(new Employee());*/

    }
}
