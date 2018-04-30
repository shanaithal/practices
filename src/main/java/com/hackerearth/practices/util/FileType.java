package com.hackerearth.practices.util;

public enum FileType {
    UTF_8("UTF-8"),
    UTF_16("UTF-16");

    private String value;

    FileType(String value) {

        this.value = value;
    }

    public String value() {

        return value;
    }
}
