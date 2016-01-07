package com.claridy.khub.admin.core.hibernate;

import java.util.Arrays;

import com.claridy.khub.admin.core.enums.PermissionEnum;

public class PermissionEnumValueUserType extends AbstractEnumUserType<PermissionEnum, Integer> {

    @Override
    protected Class<PermissionEnum> getEnumClass() {
        return PermissionEnum.class;
    }

    @Override
    protected Class<Integer> getValueClass() {
        return Integer.class;
    }

    @Override
    protected PermissionEnum convertEnum(Integer value) {
        return Arrays.stream(PermissionEnum.values()).filter(it -> value == it.getValue()).findFirst().orElse(null);
    }

    @Override
    protected Integer convertSqlValue(PermissionEnum enumValue) {
        return enumValue == null ? null : enumValue.getValue();
    }
}
