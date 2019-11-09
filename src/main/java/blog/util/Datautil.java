/**
 * FileName: Datautil
 * Author:   hy
 * Date:     2019/11/9 13:55
 * Description: 用于生成用户数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.util;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

import java.awt.*;
import java.time.LocalDate;
import java.util.Random;

public class Datautil {
    public  static String getMobile(){
        StringBuilder stringBuilder = new StringBuilder("139");
        Random random  = new Random();
        for(int i =0;i< 8 ;i++){
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static String getPassword(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0;i< 6 ;i++){
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static String getGender(){
        String [] genders =new String[]{"男","女"};
        Random random =  new Random();
        int index =random.nextInt(2);
        return genders[index];
    }

    public static LocalDate getBirthday(){
        LocalDate now = LocalDate.now();
        Random random = new Random();
        int bound = random.nextInt(8888);
        return now.minusDays(bound);
    }

    public static void main(String[] args) {
        for(int i = 0;i< 10 ;i++){
            System.out.println(Datautil.getBirthday());
        }
    }
}
