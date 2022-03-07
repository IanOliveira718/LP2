import figures.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (//4
            new KeyAdapter() {//3
                public void keyPressed (KeyEvent evt) {//2
                    if (evt.getKeyChar() == 'r') {//1
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
				  int r = rand.nextInt(255);
				  int g = rand.nextInt(255);
				  int b = rand.nextInt(255);
				  int ir = rand.nextInt(255);
				  int ig = rand.nextInt(255);
				  int ib = rand.nextInt(255);
                        rs.add(new Rect(x, y, w, h,r, g, b, ir, ig, ib));
                        repaint();  // outer.repaint()
                    }//1
			    
                    if (evt.getKeyChar() == 'e') {//1
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
				  int r = rand.nextInt(255);
				  int g = rand.nextInt(255);
				  int b = rand.nextInt(255);
				  int ir = rand.nextInt(255);
				  int ig = rand.nextInt(255);
				  int ib = rand.nextInt(255);
                        es.add(new Ellipse(x, y, w, h,r, g, b, ir, ig, ib));
                        repaint();  // outer.repaint()
                    }//1

                }//2
            }//3
        );//4

        this.setTitle("Lista de Retangulos e Ellipses");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }
    	   for (Ellipse e: this.es) {
            e.paint(g);
        }
    }
}
