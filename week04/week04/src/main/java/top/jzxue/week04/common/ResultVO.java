package top.jzxue.week04.common;

import lombok.Data;

import javax.xml.transform.Result;


@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    // 成功
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(200, "操作成功", data);
    }

    public static <T> ResultVO<T> success() {
        return new ResultVO<>(200, "操作成功", null);
    }

    // 失败
    public static <T> ResultVO<T> error(String msg) {
        return new ResultVO<>(400, msg, null);
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return new ResultVO<>(code, msg, null);
    }

    // 全参构造（必须加，否则new ResultVO<>()报错）
    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 无参构造（Lombok @Data 会生成，但显式写更稳妥）
    public ResultVO() {}
}

