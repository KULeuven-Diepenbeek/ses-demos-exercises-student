package org.example;

public record Email(String address) {
    public Email {
        if (address == null) throw new NullPointerException();
        int count = 0;
        for (char c : address.toCharArray()) {
            if (c == '@') count++;
        }
        if (count != 1) throw new IllegalArgumentException();
        if (!address.endsWith(".com") &&
            !address.endsWith(".be"))
            throw new IllegalArgumentException();
    }
}
