package Blatro;
import sas.*;
import java.awt.Color;
public class UI extends Main
{
    Text UI_t;
    Rectangle LeftSide,Mult,Adder,Score;
    
    public UI()
    {
        
    UI_t=new Text(500,20,"Pokellatro");
    LeftSide=new Rectangle(0,100,200,700);
    LeftSide.setColor(Color.GRAY);
    
    }

    public void mach()
    {

    }
}