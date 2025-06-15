package Blatro;
import sas.*;
import java.awt.Color;

public class Player extends Level {

    Sprite figur;
    Rectangle mouseArea;
    double speed = 0.5;

    public Player() {
        // Unsichtbare Fläche für Mausabfrage
        mouseArea = new Rectangle(0, 0, 1200, 900, new Color(0, 0, 0, 0));

        // Sprite erstellen und Figur zusammensetzen
        figur = new Sprite();

        // Bauteile: Rechteck (Körper), Kreis (Kopf), Ellipse (z. B. Visier)
        Rectangle r = new Rectangle(500, 500, 10, 50);                 // Körper
        Circle c = new Circle(480, 480, 20);                           // Kopf
        Ellipse e = new Ellipse(487, 495, 25, 15, Color.RED);         // Visier/Dekoration

        // Teile zum Sprite hinzufügen
        figur.add(r);
        figur.add(c);
        figur.add(e);
         
        while (true) {
            v.wait(1);

            // Bewegung mit WASD
            if (v.keyPressed('a') && figur.getCenterX() > 50)     figur.move(-speed, 0);
            if (v.keyPressed('d') && figur.getCenterX() < 1150)   figur.move(speed, 0);
            if (v.keyPressed('w') && figur.getCenterY() > 50)     figur.move(0, -speed);
            if (v.keyPressed('s') && figur.getCenterY() < 850)    figur.move(0, speed);

            // Maussteuerung: Figur dreht sich zum Klickpunkt
            if (mouseArea.mouseClicked()) {
                double mx = mouseArea.getMouseX();
                double my = mouseArea.getMouseY();

                figur.turnTo(mx, my);
                figur.turn(-90);
            }
        }
    }
}
