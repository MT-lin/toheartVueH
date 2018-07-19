package xin.toheart.door.common.enumType;

/**
 * author   xieqx
 * createTime  2018/7/19
 * desc 文件描述
 */
public enum ArticleTypeEnum {
    STORY("1", "故事"),
    WHITE_WALL("2", "表白墙");

    //数据库存储的key
    private String code;
    //数据库的描述
    private String name;

    private ArticleTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //根据code 返回指定的枚举对象
    public static ArticleTypeEnum value(String code) {
        for (ArticleTypeEnum articleType : ArticleTypeEnum.values()) {
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