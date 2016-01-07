package com.claridy.khub.admin.core.hibernate;

import java.util.Arrays;

import com.claridy.khub.admin.core.enums.StatusEnum;

public class StatusEnumValueUserType extends AbstractEnumUserType<StatusEnum, Integer> {

    @Override
    protected Class<StatusEnum> getEnumClass() {
        return StatusEnum.class;
    }

    @Override
    protected Class<Integer> getValueClass() {
        return Integer.class;
    }

    @Override
    protected StatusEnum convertEnum(Integer value) {
        return Arrays.stream(StatusEnum.values()).filter(it -> value == it.getValue()).findFirst().orElse(null);
    }

    @Override
    protected Integer convertSqlValue(StatusEnum enumValue) {
        return enumValue == null ? null : enumValue.getValue();
    }
}
