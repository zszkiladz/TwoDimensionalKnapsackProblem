package com.company;

public class Roman {
    int supplies;
    int entertainment;
    int temp;

    public Roman(int supplies, int entertainment) {
        this.supplies = supplies;
        this.entertainment = entertainment;
        temp = supplies * 100 + entertainment;
    }
}
