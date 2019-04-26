package fr;

public enum OPERATION {
    WITHDRAWAL("-"),
    DEPOSIT("+");

    final String sign;

    OPERATION(String sign) {
        this.sign = sign;
    }
}
