/**
 * FileName: ResponseObject
 * Author:   hy
 * Date:     2019/11/9 17:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package blog.util;

import lombok.Data;

@Data
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;


    private ResponseObject() {

    }


    public static ResponseObject success(Integer code, String msg) {
        ResponseObject ro = new ResponseObject();
        ro.setCode(code);
        ro.setMsg(msg);
        return ro;
    }


    public static ResponseObject success(Integer code, String msg, Object data) {
        ResponseObject ro = new ResponseObject();
        ro.setCode(code);
        ro.setMsg(msg);
        ro.setData(data);
        return ro;
    }


    public static ResponseObject error(Integer code, String msg) {
        ResponseObject ro = new ResponseObject();
        ro.setCode(code);
        ro.setMsg(msg);
        return ro;
    }
}
