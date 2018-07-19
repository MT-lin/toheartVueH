package xin.toheart.door.common.enumType;

/**
 * author   xieqx
 * createTime  2018/7/19
 * desc 点赞状态
 */
public enum PariseStatusEnum {
    PRAISE("0", "未点赞"),
    NOPRAISE("1", "已点赞");

    //数据库存储的key
    private String code;
    //数据库的描述
    private String name;

    private PariseStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //根据code 返回指定的枚举对象
    public static PariseStatusEnum value(String code) {
        for (PariseStatusEnum articleType : PariseStatusEnum.values()) {
            if (code.equals(articleType.getCode())) {
                return articleType;
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