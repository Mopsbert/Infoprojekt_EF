package Blatro;
import sas.*;
import java.awt.Color;
import java.util.ArrayList;

public class Schuss {
    Rectangle schuss;

    double vx;
    int x, y;
    double winkel;
    double winkelInGrad;
    double deltaY;
    double deltaX;
    double  vy;
    public Schuss(double x, double y, double w) {
        schuss = new Rectangle(x, y, 20, 5);
        schuss.turn(w);
         
    }

    public void bewegen() {
        schuss.move(5,0);
    }

    public  void beruehrt(int rx,int ry){
        rx = x;
        ry = y;
        if (schuss.getCenterX() > rx &&schuss.getCenterY() == ry){
            schuss.setHidden(true);
        }
    }

    public double getX() {
        return schuss.getCenterX();
    }

    public double getY() {
        return schuss.getCenterY();
    }
}
