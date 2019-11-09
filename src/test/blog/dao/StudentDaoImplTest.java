package blog.dao;

import blog.entity.Student;
import blog.factory.DaoFactory;
import blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    StudentDao studentDao = DaoFactory.getStudentDaoInstance();

    @Test
    public void insert() throws SQLException {
        Student student = new Student();
        student.setUsername("用户测试对象");
        student.setAvatar("1.jpg");
        student.setCreateTime(LocalDateTime.now());
        int n = studentDao.insert(student);
        System.out.println("受影响行数为："+n);
        assertEquals(1,n);
    }

    @Test
    public void selectAll() throws Exception {
        List<Student> studentlist = studentDao.selectAll();
    }

//    @Test
//    public void batchInsert() throws SQLException{
//        int [] n = studentDao.batchInsert(JSoupSpider.getUsers());
//        assertEquals(24,n.length);
//    }
}