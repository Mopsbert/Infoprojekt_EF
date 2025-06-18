package Blatro;
import sas.*;
import java.awt.Color;
import java.util.ArrayList;

public class Player extends Level {

    Sprite figur;
    Rectangle mouseArea;
    double speed = 0.5;
    ArrayList<Schuss> schuesse;
    int ticks;
    double mxx,myy,deltaX,deltaY,winkelInGrad,winkel;
    public Player() {

        mouseArea = new Rectangle(0, 0, 1200, 900, new Color(0, 0, 0, 0));     
        figur = new Sprite();
        schuesse = new ArrayList<>();
        Rectangle r = new Rectangle(495, 500, 10, 50);                
        Circle c = new Circle(480, 480, 20);                          
        Ellipse e = new Ellipse(487, 495, 25, 15, Color.RED);         
        figur.add(r);
        figur.add(c);
        figur.add(e);
        ticks = 0;
        while (true) {
            v.wait(1);
            ticks ++;
            if (v.keyPressed('a') && figur.getCenterX() > 50)     figur.move(-speed, 0);
            if (v.keyPressed('d') && figur.getCenterX() < 1150)   figur.move(speed, 0);
            if (v.keyPressed('w') && figur.getCenterY() > 50)     figur.move(0, -speed);
            if (v.keyPressed('s') && figur.getCenterY() < 850)    figur.move(0, speed);
            if (mouseArea.mouseClicked()) {
                double mx = mouseArea.getMouseX();
                double my = mouseArea.getMouseY();
                mxx = mx;
                myy = my;
                deltaX = mx-c.getCenterX();
                deltaY = my-c.getCenterY();
                double winkelInBogenmass = Math.atan2(deltaY, deltaX);
                winkelInGrad = Math.toDegrees(winkelInBogenmass);
                winkel = winkelInGrad;
                figur.turnTo(mx, my);
                figur.turn(-90);
            }
            if (v.keyPressed(' ')&&ticks%20== 0) {
                schuesse.add(new Schuss(c.getCenterX(),c.getCenterY(),winkel ));

            }
            for (Schuss schuss : schuesse) {
                schuss.bewegen();

            }
        }
    }
}
