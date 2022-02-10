import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import  java.awt.geom.*; 
public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
		this.getContentPane().setBackground( new Color(0,0,0));
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.green);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine((w/2)-w*4/100, 3*h/4, w/4, h/2);
        g2d.drawLine((w/2)+w*4/100, 3*h/4, w*3/4, h/2);

		
	g2d.setPaint(Color.red);//elipses
	g2d.fillOval(w/4,h/4,w/2,h/4);
	g2d.setPaint(Color.black);
	g2d.drawOval(w/4,h/4,w/2,h/4);

	g2d.setPaint(Color.yellow);
	g2d.fillOval((w*5/16),(h*9/32),3*w/8,h*3/16);
	
	g2d.setPaint(Color.black);//olhos
	g2d.fillOval((w/2)-w*6/100,3*h/8,w*3/100,h/10);
	
	g2d.setPaint(Color.black);
	g2d.fillOval((w/2)+w*6/100-w*3/100,3*h/8,w*3/100,h/10);

	g2d.setPaint(Color.green);// retangulo
	g2d.fillRect((w/2)-w*4/100,h/2,w*8/100,h/4);
	
	QuadCurve2D q = new QuadCurve2D.Float();//Curva quadrica("folhas")
	q.setCurve((w/2)-w*4/100, 3*h/4, w/2, h/2, w/4, h/2);
	g2d.draw(q);

	
	q.setCurve((w/2)-w*4/100, 3*h/4, w*3/8, h*3/4, w/4, h/2);
	g2d.draw(q);


	q.setCurve((w/2)+w*4/100, 3*h/4, w/2, h/2, w*3/4, h/2);
	g2d.draw(q);

	
	q.setCurve((w/2)+w*4/100, 3*h/4, w*5/8, h*3/4, w*3/4, h/2);
	g2d.draw(q);

		
	}

}
