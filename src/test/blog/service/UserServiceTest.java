package blog.service;

import blog.domain.UserDto;
import blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();
    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13975643665","237709407af04e104a62119c97c685e0");
        Map<String,Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}