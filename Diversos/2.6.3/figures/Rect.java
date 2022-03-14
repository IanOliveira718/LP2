package figures;

import java.awt.*;

public class Rect extends Figure  {
    int w, h;
    int ir,ig,ib;


    public Rect (int x, int y, int w, int h,int r, int g, int b, int ir, int ig, int ib){
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
        g.drawRect(this.x,this.y, this.w,this.h);
	  g.setColor(new Color(this.ir,this.ig,this.ib));
	  g.fillRect(this.x,this.y, this.w,this.h);

    }
}