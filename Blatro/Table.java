package Blatro;

import java.awt.Color;
import java.util.Random;
import sas.*;

public class Table extends Card
{
    Circle[] k;
    Text b;
    Random dealer;
    boolean[] picked;
    int[] memory;
    int count=0,check=0;
    public Table()
    {
        b = new Text(400,700,"Discard by pressing Space");
        v.setBackgroundColor(Color.GREEN);
        dealer = new Random();
        picked = new boolean[9];
        memory = new int [9];
        k = new Circle[9];
        for(int i = 0; i<9;i++)
        {
            k[i] = new Circle(20+i*130,50,50,Color.YELLOW);
            k[i].setHidden(true);
            memory[i]=52;
            picked[i]=true;
        }
        scramble(picked);
        while(true){
            if(v.keyPressed(' ')){
                scramble(picked);
                v.wait(200);
            }
            if(v.keyPressed('a')&&count>0){
                count--;
                v.wait(200);
            }
            if(v.keyPressed('d')&&count<9){
                count++;
                v.wait(200);
            }
            s[memory[count]].moveTo(s[memory[count]].getShapeX(),150);
            if(count!=check){
                s[memory[check]].moveTo(s[memory[check]].getShapeX(),200);
            }
            check = count;
            if(v.keyEnterPressed()){
                if(picked[count]){
                    picked[count]=false;
                    k[count].setHidden(true);
                    v.wait(200);
                }
                else{
                    picked[count]=true;
                    k[count].setHidden(false);
                    v.wait(200);
                }
            }
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
            k[i].setHidden(true);
        }
    }
}
