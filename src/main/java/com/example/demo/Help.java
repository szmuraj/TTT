package com.example.demo;

public class Help {
    public static void main(String[] args) {
        double height = 80.0;
        double layoutX = -50.0;
        double layoutY = 0.0;
        double width = 80.0;
        for(int y=0; y<10;y++) {
            layoutY += 80;
            for (int x = 0; x < 10; x++) {
                layoutX += 80;
                System.out.println("<Rectangle arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"WHITE\" height=\"" + height + "\" layoutX=\"" + layoutX + "\" layoutY=\"" + layoutY + "\"  smooth=\"false\" stroke=\"BLACK\" strokeType=\"INSIDE\" strokeWidth=\"3.0\" width=\"" + width + "\" />");

            }
            layoutX = -50.0;
        }
    }
}
