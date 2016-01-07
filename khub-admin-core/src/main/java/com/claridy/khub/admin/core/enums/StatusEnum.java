package com.claridy.khub.admin.core.enums;

public enum StatusEnum implements AbstractEnumValueType<Integer> {
    IN_ACTIVE(0), ACTIVE(1);

    int value;

    private StatusEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
