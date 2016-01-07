package com.claridy.khub.admin.core.hibernate;

import java.util.Arrays;

import com.claridy.khub.admin.core.enums.AccessTypeEnum;

public class AccessTypeEnumValueUserType extends AbstractEnumUserType<AccessTypeEnum, Integer> {

    @Override
    protected Class<AccessTypeEnum> getEnumClass() {
        return AccessTypeEnum.class;
    }

    @Override
    protected Class<Integer> getValueClass() {
        return Integer.class;
    }

    @Override
    protected AccessTypeEnum convertEnum(Integer value) {
        return Arrays.stream(AccessTypeEnum.values()).filter(it -> value == it.getValue()).findFirst().orElse(null);
    }

    @Override
    protected Integer convertSqlValue(AccessTypeEnum enumValue) {
        return enumValue == null ? null : enumValue.getValue();
    }
}
