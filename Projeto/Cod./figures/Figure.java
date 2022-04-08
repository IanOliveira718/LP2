package figures;
import java.awt.Graphics;
public abstract class Figure{
   public int x, y,w,h;
   public int r,g,b;
   public boolean foco; 
   public abstract void paint(Graphics g);
   public abstract void local();
   public abstract void drag(int x,int y);
   public abstract void mdrag(int x, int y);
   public abstract boolean VerP(int x,int y, Figure f);
   public abstract void psize(int h, int w);
   public abstract void changeC(int g, int r, int b);
   public abstract void changeCi(int g, int r, int b);
}
