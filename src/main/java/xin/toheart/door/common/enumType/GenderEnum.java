package xin.toheart.door.common.enumType;

/**
 * author   xieqx
 * createTime  2018/7/19
 * desc 性别
 */
public enum GenderEnum {
    MAN(1, "男"),
    WOMAN(2, "女");

    //数据库存储的key
    private int code;
    //数据库的描述
    private String name;

    private GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    //根据code 返回指定的枚举对象
    public static GenderEnum value(int code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (code == genderEnum.getCode()) {
                return genderEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
