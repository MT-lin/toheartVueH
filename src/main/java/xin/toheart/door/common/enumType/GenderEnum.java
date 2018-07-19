package xin.toheart.door.common.enumType;

/**
 * author   xieqx
 * createTime  2018/7/19
 * desc 性别
 */
public enum GenderEnum {
    MAN("1", "男"),
    WOMAN("2", "女");

    //数据库存储的key
    private String code;
    //数据库的描述
    private String name;

    private GenderEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //根据code 返回指定的枚举对象
    public static GenderEnum value(String code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (code.equals(genderEnum.getCode())) {
                return genderEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
