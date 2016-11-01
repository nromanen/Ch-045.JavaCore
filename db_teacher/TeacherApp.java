package db_teacher;

import db_teacher.model.Department;
import db_teacher.model.Teacher;

import java.util.List;

/**
 * Created by roma on 24.10.2016.
 */
public class TeacherApp {

    public static void main(String[] args){
        DBConnector dbConnector = new DBConnector();
        DBWorker dbWorker = new DBWorker();

        List<Teacher> teachers = dbWorker.getAllTeacher();
        for(Teacher teacher : teachers){
            System.out.println(teacher);
        }

        List<Department>departments = dbWorker.getAllDepartment();
        for (Department department:departments){
            System.out.println(department);
        }

        //System.out.println(dbWorker.addNewTeacher());

        dbConnector.closeConnection();
    }
}
