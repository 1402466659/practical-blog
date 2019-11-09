/**
 * FileName: Student
 * Author:   hy
 * Date:     2019/11/6 19:37
 * Description: 学生基本信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Student {
    private Integer id;
    private String username;
    private String avatar;
    private LocalDateTime createTime;
    private String description;
}
