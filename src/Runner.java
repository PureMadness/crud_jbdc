import DAO.DepartmentController;
import DAO.FacultyController;
import DAO.ProfessorController;
import Entity.Department;
import Entity.Faculty;
import Entity.Professor;

import java.util.Scanner;

public class Runner {

    private static void Choose(){
        System.out.print("1.Create new\n" +
                            "2.Read by id\n" +
                            "3.Update\n" +
                            "4.Delete\n" +
                            "5.List of all ");
    }

    public static void main(String[] args){
        ProfessorController pc = new ProfessorController();
        DepartmentController dc = new DepartmentController();
        FacultyController fc = new FacultyController();
        Scanner sc = new Scanner(System.in);
        String nextChoose;
        boolean exit = false;
        while(!exit){
            System.out.println();
            System.out.println("Select database:\n" +
                    "1.Faculty\n" +
                    "2.Department\n" +
                    "3.Professor\n" +
                    "0.exit");
            String choose = sc.next();
            switch (choose){
                case "1":
                    Choose();
                    System.out.println("faculties: ");
                    nextChoose = sc.next();
                    switch (nextChoose){
                        case "1":
                            System.out.print("Enter faculty name: ");
                            String facultyName = sc.next();
                            fc.create(new Faculty(facultyName));
                            break;
                        case "2":
                            System.out.print("Enter id:");
                            System.out.println(fc.getEntityById(sc.nextLong()));
                            break;
                        case "3":
                            System.out.print("Enter id: ");
                            long id = sc.nextLong();
                            System.out.print("Enter new name: ");
                            fc.update(new Faculty(id, sc.next()));
                            break;
                        case "4":
                            System.out.print("Enter id of delete object: ");
                            fc.delete(sc.nextLong());
                            break;
                        case "5":
                            for(Faculty faculty: fc.getAll()){
                                System.out.println(faculty);
                            }
                            break;
                        default:break;
                    }
                    break;
                case "2":
                    Choose();
                    System.out.println("departments: ");
                    nextChoose = sc.next();
                    switch (nextChoose){
                        case "1":
                            System.out.print("Enter department name: ");
                            String departmentName = sc.next();
                            System.out.print("Enter faculty");
                            dc.create(new Department(departmentName, sc.next()));
                            break;
                        case "2":
                            System.out.print("Enter id:");
                            System.out.println(dc.getEntityById(sc.nextLong()));
                            break;
                        case "3":
                            System.out.print("Enter id: ");
                            long id = sc.nextLong();
                            System.out.print("Enter new name: ");
                            String newDepartmentName = sc.next();
                            System.out.print("Enter new faculty: ");
                            dc.update(new Department(id, newDepartmentName, sc.next()));
                            break;
                        case "4":
                            System.out.print("Enter id of delete object: ");
                            dc.delete(sc.nextLong());
                            break;
                        case "5":
                            for(Department department: dc.getAll()){
                                System.out.println(department);
                            }
                            break;
                        default:break;
                    }
                    break;
                case "3":
                    Choose();
                    System.out.println("professors: ");
                    nextChoose = sc.next();
                    switch (nextChoose){
                        case "1":
                            System.out.print("Enter professor name: ");
                            String professorName = sc.next();
                            System.out.print("Enter department: ");
                            pc.create(new Professor(professorName, sc.next()));
                            break;
                        case "2":
                            System.out.print("Enter id:");
                            System.out.println(pc.getEntityById(sc.nextLong()));
                            break;
                        case "3":
                            System.out.print("Enter id: ");
                            long id = sc.nextLong();
                            System.out.print("Enter new name: ");
                            String newProfessorName = sc.next();
                            System.out.print("Enter new department: ");
                            pc.update(new Professor(id, newProfessorName, sc.next()));
                            break;
                        case "4":
                            System.out.print("Enter id of delete object: ");
                            pc.delete(sc.nextLong());
                            break;
                        case "5":
                            for(Professor professor: pc.getAll()){
                                System.out.println(professor);
                            }
                            break;
                        default:break;
                    }
                    break;
                case "0":
                    exit = true;
                    break;
            }
        }


    }

}
