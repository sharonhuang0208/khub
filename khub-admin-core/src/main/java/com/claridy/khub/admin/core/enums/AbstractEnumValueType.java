package com.claridy.khub.admin.core.enums;

import java.io.Serializable;

public interface AbstractEnumValueType<T extends Serializable> {
    T getValue();
}
