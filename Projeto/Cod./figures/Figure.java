package figures;
import java.awt.Graphics;
public abstract class Figure{
   public int x, y,w,h;
   public int r,g,b;
   public abstract void paint(Graphics g);
   public abstract void local();
   public abstract void drag(int x,int y);
}
