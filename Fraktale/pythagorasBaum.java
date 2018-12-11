package core;

import turtle.Turtle;

public class pythagorasBaum {
    static Turtle turtle;
    public static void main(String[] args) {
        turtle = new Turtle(1900,900);
        //turtle.setSpeed(10);
        turtle.turn(-90);
        baum(100, 45);
    }

    public static void baum(double laenge, double winkel){
        for (int i = 0; i<4; i++){
            turtle.vor(laenge);
            turtle.drehe(90);
        }
        if(laenge > 0.1){
            turtle.vor(laenge);
            turtle.drehe(-winkel);
            baum(Math.cos(Math.toRadians(winkel))*laenge, winkel);
            turtle.turn(90);
            turtle.vor(Math.cos(Math.toRadians(winkel))*laenge);
            baum(Math.sin(Math.toRadians(winkel))*laenge, winkel);
            turtle.vor(-(Math.cos(Math.toRadians(winkel))*laenge));
            turtle.turn(-(180-(winkel+90)));
            turtle.vor(-laenge);
        }
    }
}
