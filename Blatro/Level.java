package Blatro;
import sas.*;
import java.awt.Color;
import java.util.Random;

public class Level extends Main 
{
    Random random;
    int scene;
    public Level()
    {
        random = new Random();
        v.setBackgroundColor(new Color (136,215,170));
        for( int i = 0; i<100;i++){
            tree(random.nextInt(50,1150),random.nextInt(50,850),random.nextDouble(0.8,1.2));
        }
    
    }

    public void tree(int x, int y, double multiplier)
    {
        Circle c;
        Rectangle r;
        c = new Circle(x,y,10*multiplier,new Color (0,128,0));
        r = new Rectangle(x+8*multiplier,y+20*multiplier,4*multiplier,12*multiplier,new Color (102,51,0));
    }

    public void switchscene(int scene)
    {

    }
}
