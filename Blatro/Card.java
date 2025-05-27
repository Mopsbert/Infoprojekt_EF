package Blatro;

import sas.*;
import java.awt.Color;
public class Card extends Main
{
    Sprite[] s;
    public Card()
    {
        s = new Sprite[52];
        for(int i = 0; i<52;i++){
            s[i]= new Sprite();
            cardConstruct(i,0.5);
            s[i].setHidden(true);
        }
    }

    public void cardConstruct(int z,double multiplier)
    {
        Polygon m;
        Circle c1,c2,c3,c4;
        Text t;
        c1 = new Circle(100*multiplier,50*multiplier,50*multiplier);
        c2 = new Circle(250*multiplier,50*multiplier,50*multiplier);
        c3 = new Circle(250*multiplier,400*multiplier,50*multiplier);
        c4 = new Circle(100*multiplier,400*multiplier,50*multiplier);
        m = new Polygon(150*multiplier,50*multiplier,Color.WHITE);
        t = new Text(215*multiplier,260*multiplier,"Null");
        m.add(150*multiplier,0);
        m.add(150*multiplier,50*multiplier);
        m.add(200*multiplier,50*multiplier);
        m.add(200*multiplier,400*multiplier);
        m.add(150*multiplier,400*multiplier);
        m.add(150*multiplier,450*multiplier);
        m.add(0,450*multiplier);
        m.add(0,400*multiplier);
        m.add(-50*multiplier,400*multiplier);
        m.add(-50*multiplier,50*multiplier);
        m.add(0,50*multiplier);
        switch(z){
            case 0,13,26,39:
                t.setText("A");
                break;
            case 1,14,27,40:
                t.setText("2");
                break;
            case 2,15,28,41:
                t.setText("3");
                break;
            case 3,16,29,42:
                t.setText("4");
                break;
            case 4,17,30,43:
                t.setText("5");
                break;
            case 5,18,31,44:
                t.setText("6");
                break;
            case 6,19,32,45:
                t.setText("7");
                break;
            case 7,20,33,46:
                t.setText("8");
                break;
            case 8,21,34,47:
                t.setText("9");
                break;
            case 9,22,35,48:
                t.setText("10");
                break;
            case 10,23,36,49:
                t.setText("J");
                break;
            case 11,24,37,50:
                t.setText("Q");
                break;
            case 12,25,38,51:
                t.setText("K");
                break;
        }
        if(z<13){
            c1.setColor(Color.RED);
            c2.setColor(Color.RED);
            c3.setColor(Color.RED);
            c4.setColor(Color.RED);
            t.setFontColor(Color.RED);
        }
        else if(z<26){
            c1.setColor(Color.PINK);
            c2.setColor(Color.PINK);
            c3.setColor(Color.PINK);
            c4.setColor(Color.PINK);
            t.setFontColor(Color.PINK);
        }
        else if(z<39){
            c1.setColor(Color.BLUE);
            c2.setColor(Color.BLUE);
            c3.setColor(Color.BLUE);
            c4.setColor(Color.BLUE);
            t.setFontColor(Color.BLUE);
        }
        else{
            c1.setColor(Color.BLACK);
            c2.setColor(Color.BLACK);
            c3.setColor(Color.BLACK);
            c4.setColor(Color.BLACK);
            t.setFontColor(Color.BLACK);
        }
        s[z].add(c1);
        s[z].add(c2);
        s[z].add(c3);
        s[z].add(c4);
        s[z].add(m);
        s[z].add(t);
    }
}
