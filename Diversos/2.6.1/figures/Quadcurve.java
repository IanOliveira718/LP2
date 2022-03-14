package figures;

import java.awt.*;
import java.awt.geom.*;

public class Quadcurve extends Figure{

	int x,y,cx,cy,x2, y2;
	int r,g,b;

	public Quadcurve(int x,int y,int cx,int cy,int x2,int y2,int r,int g,int b){
	this.x=x;
	this.y=y;	
	this.cx=cx; 
	this.cy=cy; 
	this.x2=x2; 
	this.y2=y2;
     this.b=b;
	this.g=g;
	this.r=r;

	}
	public void print(){
	  System.out.format("begin (%d,%d)/ control points (%d,%d)/ final (%d,%d)", this.x, this.y, this.cx, this.cy, this.x2, this.y2);
	}
	public void paint (Graphics g) {
	   Graphics2D g2d = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();
	  q.setCurve(this.x, this.y, this.cx, this.cy, this.x2, this.y2);
	  g.setColor(new Color(this.r,this.g,this.b));
	  g2d.draw(q);
    }

}