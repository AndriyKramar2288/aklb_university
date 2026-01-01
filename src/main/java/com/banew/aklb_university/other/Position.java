package com.banew.aklb_university.other;

public enum Position {
    STUDENT("Студент"), SCIENTIST("Науковець"), TEACHER("Викладач"), READER("Читач"), ETC("Працівник");
    private String ukr;
    Position (String ukr) {
        this.ukr = ukr;
    }
    @Override
    public String toString() {
        return ukr;
    }
}


