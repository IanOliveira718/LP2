import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RectApp {
    public static void main (String[] args) {
        RectFrame frame = new RectFrame();
        frame.setVisible(true);
    }
}

class RectFrame extends JFrame {
    Rect r1,r2,r3;
    

    RectFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rects");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,150,0,0,0,255,0,0);
	  this.r2 = new Rect(170,50, 50,50,255,0,0,0,0,0);
	  this.r3 = new Rect(250,50, 50,200,0,255,0,255,0,255);
      
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
	  this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r,g,b;
    int ir,ig,ib;

    Rect (int x, int y, int w, int h,int r, int g, int b, int ir, int ig, int ib) {
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
    void paint (Graphics g) {
	  g.setColor(new Color(this.r,this.g,this.b));
        g.drawRect(this.x,this.y, this.w,this.h);
	  g.setColor(new Color(this.ir,this.ig,this.ib));
	  g.fillRect(this.x,this.y, this.w,this.h);
    }
}
