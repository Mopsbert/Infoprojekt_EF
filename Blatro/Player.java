package Blatro;
import sas.*;
import java.util.Random;
import java.awt.Color;

public class Player extends Level
{

    
    Circle c, c1;
    Ellipse e;
    Rectangle r, schuss;
    boolean start;
    double speed;
    Sprite figur; 
    public Player()
    {
        figur = new Sprite();
        //schuss = new Rectangle (500,500,10,50);
        r = new Rectangle (500,500,10,50);

        c= new Circle(480,480,20);
        e= new Ellipse(487,495,25,15,Color.RED);
        start = false;
        speed = 0.5;
        figur.add(r);
        figur.add(c);
        while(true){

            v.wait(1);
            if(v.keyPressed('a')&&c.getCenterX()>50){ c.move(-speed, 0);e.move(-speed, 0);r.move(-speed, 0);}
            if(v.keyPressed('d')&&c.getCenterX()<1150){ c.move(+speed, 0);e.move(+speed, 0);r.move(+speed, 0); }
            if(v.keyPressed('w')&&c.getCenterY()>50){ c.move(0, -speed);e.move(0,-speed);r.move(0, -speed);}
            if(v.keyPressed('s')&&c.getCenterY()<850){ c.move(0, speed);e.move(0,speed); r.move(0, speed);}
            if(v.keyPressed('e')){c.turn(1);r.turn(c.getCenterX(),c.getCenterY(),1);e.turn(c.getCenterX(),c.getCenterY(),1);};
            if(v.keyPressed('q')){c.turn(-1);r.turn(c.getCenterX(),c.getCenterY(),-1);e.turn(c.getCenterX(),c.getCenterY(),-1);}
            

        }
    }

        
}

