/**
 * FileName: StudentDaoimpl
 * Author:   hy
 * Date:     2019/11/6 19:37
 * Description: 实现学生接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.dao;

import blog.entity.Student;
import blog.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public int insert(Student student) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_student VALUES (NULL,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, student.getUsername());
        pstmt.setString(2, student.getAvatar());
        pstmt.setTimestamp(3, Timestamp.valueOf(student.getCreateTime()));
        int n = pstmt.executeUpdate();
        connection.commit();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int[] batchInsert(List<Student> studentList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_student VALUES(NULL,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        studentList.forEach(student->{
            try {
                pstmt.setString(1,student.getUsername());
                pstmt.setString(2,student.getAvatar());
                pstmt.setTimestamp(3,Timestamp.valueOf(student.getCreateTime()));
                pstmt.setString(4,student.getDescription());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int [] result = pstmt.executeBatch();
        connection.commit();
        pstmt.close();
        connection.close();
        return result;
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_Student ORDER BY id DESC ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setAvatar(rs.getString("avatar"));
            Timestamp timestamp = rs.getTimestamp("create_time");
            student.setCreateTime(timestamp.toLocalDateTime());
            studentList.add(student);
        }
        return studentList;
    }

}
