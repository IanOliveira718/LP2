import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipses");
        this.setSize(350, 350);
        
     	  this.e1 = new Ellipse(50,50, 100,150,0,0,0,255,0,0);
	  this.e2 = new Ellipse(170,50, 50,50,255,0,0,0,0,0);
	  this.e3 = new Ellipse(250,50,50,200,0,255,0,255,0,255);

    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
	  this.e3.paint(g);
    }
}


class Ellipse {
    int x, y;
    int w, h;
    int r,g,b;
    int ir,ig,ib;

    Ellipse (int x, int y, int w, int h, int r, int g, int b, int ir, int ig, int ib) {
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
         Graphics2D g2d = (Graphics2D) g;
	       g.setColor(new Color(this.r,this.g,this.b));
         g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	       g.setColor(new Color(this.ir,this.ig,this.ib));
	       g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
