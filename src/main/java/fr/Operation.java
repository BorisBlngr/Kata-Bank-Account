package fr;

public enum Operation {
    WITHDRAWAL("-"),
    DEPOSIT("+");

    final String sign;

    Operation(String sign) {
        this.sign = sign;
    }
}
