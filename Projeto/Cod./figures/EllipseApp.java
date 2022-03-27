package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
    int w, h;
    int ir,ig,ib;

    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int ir, int ig, int ib)  {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	   this.r = r;
        this.g = g;
        this.b = b;
	   this.ir = ir;
        this.ig = ig;
        this.ib = ib;

    }

    public void paint (Graphics g) {
	   Graphics2D g2d = (Graphics2D) g;
	   g.setColor(new Color(this.r,this.g,this.b));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	   g.setColor(new Color(this.ir,this.ig,this.ib));
	   g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
public void local(){
	System.out.format("Local %d %d %d %d",this.x,this.y,this.w,this.h);
	}
}
