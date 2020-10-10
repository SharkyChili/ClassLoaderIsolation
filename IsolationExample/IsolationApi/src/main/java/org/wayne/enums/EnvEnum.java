package org.wayne.enums;

public enum EnvEnum {
    A("A"),
    B("B");

    String env;

    EnvEnum(String env){
        this.env = env;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
