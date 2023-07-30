package com.wenzh.sqlGenerateTool.core.model.enums;



/**
 * 内容类型
 *
 * @author wenzhou
 */
public enum ContentTypeEnum {

    DIC(0),
    FIELD_INFO(1),
    TABLE_INFO(2);

    private final Integer value;

    ContentTypeEnum(Integer value) {
        this.value = value;
    }


    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static ContentTypeEnum getEnumByValue(Integer value) {
        if (value == null || value < 0 || value > 2) {
            return null;
        }
        for (ContentTypeEnum mockTypeEnum : ContentTypeEnum.values()) {
            if (mockTypeEnum.value.equals(value)) {
                return mockTypeEnum;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }
}
