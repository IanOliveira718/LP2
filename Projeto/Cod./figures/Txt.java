package figures;

import java.awt.*;

public class Txt extends Figure{
    String word;

    public Txt (int x, int y,int r, int g, int b,String word){
        this.x = x;
        this.y = y;
	   this.r = r;
        this.g = g;
        this.b = b;
	   this.word = word;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	   g.setColor(new Color(this.r,this.g,this.b));
        g.drawString(word, this.x, this.y);
    }
    public void local(){
	System.out.format("Local %d %d ",this.x,this.y);
	}
    public void drag(int x,int y){
	this.x=this.x+x;
	this.y=this.y+y;
	}


}
