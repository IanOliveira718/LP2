package figures;

import java.io.Serializable;

import ivisible.iVisible;


public abstract class  Figure implements iVisible,Serializable{
   
   public int x, y, w, h;
   protected int r, g, b;
   protected boolean foco;

   public abstract void local();

   public abstract void drag(int x, int y);

   public abstract void mdrag(int x, int y);

///////////////////a mudar
   public abstract boolean clickdrag(int x, int y);

   public abstract int getx();
    
   public abstract int gety();

   public abstract void setf(boolean b);
///////////////////  

   public abstract boolean VerP(int x, int y, Figure f);
   
   public abstract void psize(int h, int w);

   public abstract void changeC(int g, int r, int b);

   public abstract void changeCi(int g, int r, int b);

}
