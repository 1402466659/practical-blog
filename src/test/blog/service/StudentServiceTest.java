package blog.service;

import blog.entity.Student;
import blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {
    private StudentService studentService = ServiceFactory.getStudentServiceInstance();
    @Test
    public void listStudent() {
        List<Student> studentList = studentService.listStudent();
        studentList.forEach(System.out::println);
    }
}