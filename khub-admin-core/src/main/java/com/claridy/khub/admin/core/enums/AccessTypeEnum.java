package com.claridy.khub.admin.core.enums;

public enum AccessTypeEnum implements AbstractEnumValueType<Integer> {
    LOGIN(1), LOGOUT(2), LOGIN_FAILED(3);

    int value;

    private AccessTypeEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
