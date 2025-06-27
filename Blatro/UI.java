package Blatro;
import sas.*;
import java.awt.Color;
import sasio.*;

public class UI
{
    Text UI_t,TMult,TAdd,TScore,TNeeded;
    Rectangle LeftSide,BgScore,BgMult,BgAdd,BgNeeded;
    double Mult, Add,Score,NeededScore,Round,LSideMove;
    Sprite LSide,LSideT;
    Button DiscardB,PlayB;
    public UI()
    {
        NeededScore=300000;
        UI_t=new Text(500,20,"Pokellatro");
        LeftSide=new Rectangle(0,100,200,700);
        BgMult=new Rectangle(110,300,90,30);
        BgAdd=new Rectangle(0,300,90,30);
        BgScore=new Rectangle(0,250,90,30);
        BgNeeded=new Rectangle(110,250,90,30);
        LeftSide.setColor(Color.GRAY);
        BgMult.setColor(Color.RED);
        BgAdd.setColor(Color.BLUE);
        BgScore.setColor(Color.WHITE);
        BgNeeded.setColor(Color.GREEN);
        TMult=new Text(110,300,"Mult:"+Mult);
        TAdd=new Text(0,300,"Base:"+Add);
        TScore=new Text(0,250,"Score:"+Add*Mult);
        TNeeded=new Text(110,250,"get:"+NeededScore);
        LSide=new Sprite();
        LSideT=new Sprite();
        LSide.add(LeftSide); LSide.add(BgMult); LSide.add(BgAdd);LSide.add(BgScore);LSide.add(BgNeeded);LSideT.add(TMult);LSideT.add(TAdd);LSideT.add(TScore);LSideT.add(TNeeded);
        LSideMove=0.0001;
        DiscardB = new Button(10, 10, 100, 40, "euw", Color.BLUE);

    }

    public void mach()
    {
        while(true){
            
            TMult.setText("Mult:"+Mult);
            TAdd.setText("Base:"+Add);
            TScore.setText("Score:"+Add*Mult);
            TNeeded.setText("get:"+Round); //muss noch festgelegt werden wie viel der Score steigt
            
        }
    }
}