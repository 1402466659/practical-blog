/**
 * FileName: StudentServiceImpl
 * Author:   hy
 * Date:     2019/11/7 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.service.impl;

import blog.dao.StudentDao;
import blog.entity.Student;
import blog.factory.DaoFactory;
import blog.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = DaoFactory.getStudentDaoInstance();
    @Override
    public List<Student> listStudent(){
        List<Student> studentList=null;
        try {
            studentList = studentDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有学生出现异常");
        }
        return studentList;
    }
}
