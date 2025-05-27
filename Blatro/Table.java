package Blatro;

import java.awt.Color;
import java.util.Random;
import sas.*;

public class Table extends Card
{
    Text b;
    Random dealer;
    int[] memory;
    public Table()
    {
        b = new Text(400,700,"Scramble by pressing Space");
        v.setBackgroundColor(Color.GREEN);
        dealer = new Random();
        memory = new int [5];
        for(int i = 0; i<5;i++)
        {
            memory[i]=52;
        }
        scramble(true,true,true,true,true);
        while(true){
            if(v.keyPressed(' ')){
                scramble(true,true,true,true,true);
                v.wait(1000);
            }
        }
    }

    public void scramble(boolean a,boolean b,boolean c,boolean d,boolean e)
    {
        while((memory[0]==52||memory[0]==memory[1]||memory[0]==memory[2]||memory[0]==memory[3]||memory[0]==memory[4])||a)
        {
            memory[0]=dealer.nextInt(0,51);
            a = false;
        }
        while((memory[1]==52||memory[1]==memory[0]||memory[1]==memory[2]||memory[1]==memory[3]||memory[1]==memory[4])||b)
        {
            memory[1]=dealer.nextInt(0,51);
            b = false;
        }
        while((memory[2]==52||memory[2]==memory[1]||memory[2]==memory[0]||memory[2]==memory[3]||memory[2]==memory[4])||c)
        {
            memory[2]=dealer.nextInt(0,51);
            c = false;
        }
        while((memory[3]==52||memory[3]==memory[1]||memory[3]==memory[2]||memory[3]==memory[0]||memory[3]==memory[4])||d)
        {
            memory[3]=dealer.nextInt(0,51);
            d = false;
        }
        while((memory[4]==52||memory[4]==memory[1]||memory[4]==memory[2]||memory[4]==memory[3]||memory[4]==memory[0])||e)
        {
            memory[4]=dealer.nextInt(0,51);
            e = false;
        }
        for(int i = 0; i<52;i++)
        {
            s[i].setHidden(true);
        }
        s[memory[0]].moveTo(60,200);
        s[memory[0]].setHidden(false);
        s[memory[1]].moveTo(240,200);
        s[memory[1]].setHidden(false);
        s[memory[2]].moveTo(420,200);
        s[memory[2]].setHidden(false);
        s[memory[3]].moveTo(600,200);
        s[memory[3]].setHidden(false);
        s[memory[4]].moveTo(780,200);
        s[memory[4]].setHidden(false);
    }
}
