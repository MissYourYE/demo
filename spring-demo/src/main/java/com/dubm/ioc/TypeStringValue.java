package com.dubm.ioc;

public class TypeStringValue {
    private String value;
    private Class<?> targetType;

    public TypeStringValue(String value, Class<?> targetType) {
        this.value = value;
        this.targetType = targetType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class<?> getTargetType() {
        return targetType;
    }

    public void setTargetType(Class<?> targetType) {
        this.targetType = targetType;
    }
}
