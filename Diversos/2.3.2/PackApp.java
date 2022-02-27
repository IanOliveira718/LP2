import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Quadcurve q1;
    Quadcurve q2;


    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,0,255,0,0);
        this.e1 = new Ellipse(100,100, 100,30,255,0,150,255,0,255);
	  this.q1 = new Quadcurve(50,150,75,200,100,150,255,0,255);
	  this.q2 = new Quadcurve(50,200,75,100,100,200,0,255,255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
	  this.q1.paint(g);
	  this.q2.paint(g);
    }
}