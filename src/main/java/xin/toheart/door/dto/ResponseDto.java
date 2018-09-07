package xin.toheart.door.dto;

/**
 * Created by Administrator on 2018/9/3.
 */
public class ResponseDto<T> {
    private int code = 20000;
    private boolean state;
    private T data;
    private String message;

    public ResponseDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
