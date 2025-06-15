package Blatro;
import sas.*;
import java.awt.Color;

public class Player extends Level {

    Sprite figur;
    Rectangle mouseArea;
    double speed = 0.5;

    public Player() {
   
        mouseArea = new Rectangle(0, 0, 1200, 900, new Color(0, 0, 0, 0));     
        figur = new Sprite();
        Rectangle r = new Rectangle(500, 500, 10, 50);                
        Circle c = new Circle(480, 480, 20);                          
        Ellipse e = new Ellipse(487, 495, 25, 15, Color.RED);         
        figur.add(r);
        figur.add(c);
        figur.add(e);
         
        while (true) {
            v.wait(1);
            if (v.keyPressed('a') && figur.getCenterX() > 50)     figur.move(-speed, 0);
            if (v.keyPressed('d') && figur.getCenterX() < 1150)   figur.move(speed, 0);
            if (v.keyPressed('w') && figur.getCenterY() > 50)     figur.move(0, -speed);
            if (v.keyPressed('s') && figur.getCenterY() < 850)    figur.move(0, speed);
            if (mouseArea.mouseClicked()) {
                double mx = mouseArea.getMouseX();
                double my = mouseArea.getMouseY();

                figur.turnTo(mx, my);
                figur.turn(-90);
            }
        }
    }
}
