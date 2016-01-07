package com.claridy.khub.admin.core.enums;

public enum PermissionEnum implements AbstractEnumValueType<Integer> {
    NORMAL(0), ALL(1);

    int value;

    private PermissionEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
