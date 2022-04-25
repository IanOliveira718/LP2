package figures;

import ivisible.iVisible;

public abstract class Figure{
   public int x, y,w,h;
   protected int r,g,b;
   public boolean foco; 
   public abstract void local();
   public abstract void drag(int x,int y);
   public abstract void mdrag(int x, int y);
   
   public abstract boolean clicked(int x,int y, Figure f){
   return(this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
   }
   
   public abstract void psize(int h, int w);
   public abstract void changeC(int g, int r, int b);
   public abstract void changeCi(int g, int r, int b);
}
