package cn.itcast.pojo;

/**
 * @author GuoQingchun
 * @date 2020/5/21  - 17:15
 */
public class SysException extends Exception {
    private String message;

    public SysException() {
    }

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
