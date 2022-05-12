package figures;

import ivisible.iVisible;

public abstract class Figure implements iVisible,Serializable{
   protected int x, y,w,h;
   protected int r,g,b;
   protected boolean foco;
   
   public abstract void local();
   public abstract void drag(int x,int y);
   public abstract void mdrag(int x, int y);
   
   public abstract boolean clicked(int x,int y, Figure f){
   return(this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
   }
   
   public boolean clickdrag(int x, int y){
      return(x<=this.x+this.w && x>=this.x+this.w-7 && y<= this.y+ this.h && y>= this.y+ this.h-7);
   }
   public int getx(){
      return (this.x);
   }
    
   public int gety(){
      return (this.y);
   }

   public void setf(boolean b){
      this.foco=b;
   }
   
   public abstract void psize(int h, int w);
   public abstract void changeC(int g, int r, int b);
   public abstract void changeCi(int g, int r, int b);
}
