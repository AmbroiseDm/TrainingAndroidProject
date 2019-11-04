package com.example.javarecyclerviewapp;

public class ListItems {
    private String image;
    private String text;
    private int color;

    public ListItems(String img, String txt, int clr) {
        image = img;
        text = txt;
        color = clr;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public int getColor() {
        return color;
    }
}
