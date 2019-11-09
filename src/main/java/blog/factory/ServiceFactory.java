/**
 * FileName: ServiceFactory
 * Author:   hy
 * Date:     2019/11/7 10:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.factory;


import blog.service.StudentService;
import blog.service.UserService;
import blog.service.impl.StudentServiceImpl;
import blog.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }

    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }


}
