package Blatro;

import java.awt.Color;
import java.util.Random;
import sas.*;

public class Table extends Card
{
    Circle[] k;
    Text b,c;
    Random dealer;
    boolean[] picked;
    int[] memory;
    int count=0,check=0,select=0;
    public Table()
    {
        b = new Text(400,700,"Discard by pressing Backspace");
        c = new Text(400,600,select+"/5");
        v.setBackgroundColor(Color.GREEN);
        dealer = new Random();
        picked = new boolean[9];
        memory = new int [9];
        for(int i = 0; i<9;i++)
        {
            memory[i]=52;
            picked[i]=true;
        }
        scramble(picked);
        while(true){
            if(v.keyBackspacePressed()){
                scramble(picked);
                v.wait(200);
                select=0;
            }
            if(v.keyPressed('a')&&count>0){
                count--;
                v.wait(200);
            }
            if(v.keyPressed('d')&&count<8){
                count++;
                v.wait(200);
            }
            s[memory[count]].scaleTo(130,260);
            if(count!=check){
                s[memory[check]].scaleTo(115,230);
            }
            check = count;
            if(v.keyPressed(' ')){
                if(picked[count]){
                    picked[count]=false;
                    s[memory[count]].moveTo(s[memory[count]].getShapeX(),200);
                    select--;
                    v.wait(200);
                }
                else if(select<5){
                    picked[count]=true;
                    s[memory[count]].moveTo(s[memory[count]].getShapeX(),150);
                    select++;
                    v.wait(200);
                }
            }
            c.setText(select+"/5");
        } 
    }

    public void scramble(boolean a[])
    {
        for(int i = 0; i<9;i++)
        {
            while(a[i])
            {
                int temp =dealer.nextInt(0,51);
                if(temp==memory[0]||temp==memory[1]||temp==memory[2]||temp==memory[3]||temp==memory[4]||temp==memory[5]||temp==memory[6]||temp==memory[7]||temp==memory[8]){
                    a[i] = true;
                }
                else{
                    a[i] = false;
                    memory[i]=temp;
                }
            }
        }
        for(int i = 0; i<52;i++)
        {
           s[i].setHidden(true);
        }
        for(int i = 0; i<9;i++)
        {
            s[memory[i]].moveTo(20+i*130,200);
            s[memory[i]].setHidden(false);
        }
    }
}
