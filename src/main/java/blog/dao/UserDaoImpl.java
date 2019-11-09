/**
 * FileName: UserDaoImpl
 * Author:   hy
 * Date:     2019/11/9 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.dao;

import blog.entity.User;
import blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public int[] batchInsert(List<User> userlist) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_user (mobile,password,nickname,avatar,gender,birthday,introduction,create_time) VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        userlist.forEach(user->{
            try {
                pstmt.setString(1, user.getMobile());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getNickname());
                pstmt.setString(4, user.getAvatar());
                pstmt.setString(5, user.getGender());
                //日期的设置，可以使用setObject
                pstmt.setObject(6, user.getBirthday());
                pstmt.setString(7, user.getIntroduction());
                pstmt.setObject(8, user.getCreateTime());
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("批量新增用户出现异常");
            }
        });
        int [] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
        return result;
    }

    @Override
    public User findUserByMobile(String mobile) throws SQLException{
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile =? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,mobile);
        ResultSet rs = pstmt.executeQuery();
        User user =null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getShort("follows"));
            user.setFans(rs.getShort("fans"));
            user.setArticles(rs.getShort("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
            user.setPassword(rs.getString("Password"));
        }
        return user;
    }
}
