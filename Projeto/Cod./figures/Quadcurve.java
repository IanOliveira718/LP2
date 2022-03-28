package figures;

import java.awt.*;
import java.awt.geom.*;

public class Quadcurve extends Figure{

	int cx,cy;
	

	public Quadcurve(int x,int y,int cx,int cy,int w,int h,int r,int g,int b){
	this.x=x;
	this.y=y;	
	this.cx=cx; 
	this.cy=cy; 
	this.w=w; 
	this.h=h;
     this.b=b;
	this.g=g;
	this.r=r;

	}
	public void print(){
	  System.out.format("begin (%d,%d)/ control points (%d,%d)/ final (%d,%d)", this.x, this.y, this.cx, this.cy, this.w, this.h);
	}
	public void paint (Graphics g) {
	   Graphics2D g2d = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();
	  q.setCurve(this.x, this.y, this.cx, this.cy, this.w, this.h);
	  g.setColor(new Color(this.r,this.g,this.b));
	  g2d.draw(q);
    }
    
	public void local(){
	System.out.format("Local %d %d %d %d",this.x,this.y,this.w,this.h);
	}
	public void drag(int x,int y){
		this.x=this.x+x;
		this.y=this.y+y;
	}


}
