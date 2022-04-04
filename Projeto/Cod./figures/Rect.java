package figures;

import java.awt.*;

public class Rect extends Figure  {
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
	public void local(){
	System.out.format("Local %d %d %d %d",this.x,this.y,this.w,this.h);
	}
  public void drag(int x,int y){
    this.x=this.x+x;
    this.y=this.y+y;
	}
  public  void mdrag(int x, int y){
        this.x=x;
        this.y=y;
    }
    public boolean VerP(int x,int y, Figure f){
        if (x >= f.x && x <= f.x + f.w && y >= f.y && y <= f.y + f.h){
            return true;
        }
        return false;
	}
    public void psize(int h, int w){
        this.h= this.h+h;
        this.w= this.w+w;
     }
     public void changeC(int r, int g, int b){
        if(this.r+r<255){ this.r=this.r+r;}
        if(this.g+g<255){this.g=this.g+g;}
        if(this.b+b<255){this.b=this.b+b;}
    }
    public void changeCi(int r, int g, int b){
        if(this.ir+r<255){ this.ir=this.ir+r;}
        if(this.ig+g<255){this.ig=this.ig+g;}
        if(this.ib+b<255){this.ib=this.ib+b;}
    }
}
