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
    ArrayList<Figure> fs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure save=null;
    Figure save2=null;
    int x,y,z,i;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);	    
			                    }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
			
			if (evt.getKeyChar() == '7') {
                            if (save != null) {
                                save.changeCi(10,0, 0);
                                repaint();
                            }
                        }if (evt.getKeyChar() == '4') {
                            if (save != null) {
                                save.changeCi(-10,0, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == '8') {
                            if (save != null) {
                                save.changeCi(0,10, 0);
                                repaint();
                            }
                        }if (evt.getKeyChar() == '5') {
                            if (save != null) {
                                save.changeCi(0,-10, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == '9') {
                            if (save != null) {
                                save.changeCi(0,0,10);
                                repaint();
                            }
                        }if (evt.getKeyChar() == '6') {
                            if (save != null) {
                                save.changeCi(0,0,-10);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 'a') {
                            if (save != null) {
                                save.drag(-10, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 'd') {
                            if (save != null) {
                                save.drag(10, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 'w') {
                            if (save != null) {
                                save.drag(0, -10);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 's') {
                            if (save != null) {
                                save.drag(0, 10);
                                repaint();
                            }
                        }
                        
                        if (evt.getKeyChar() == '+') {
                            if (save != null) {
                                save.psize(10, 10);
                                repaint();
                            }
                        }

                        if (evt.getKeyChar() == '-') {
                            if (save != null) {
                                save.psize(-10, -10);
                                repaint();
                            }
                        }

                        if(evt.getKeyChar() == 'l') {
                            if (save != null) {
                                save=null;
                                fs.remove(i);
                                repaint();
                            }
                        }

                    if (evt.getKeyChar() == 'r') {
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
                        fs.add(new Rect(x, y, w, h,r, g, b, ir, ig, ib));
                        repaint();
                    }
			    
                    if (evt.getKeyChar() == 'e') {
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
                        fs.add(new Ellipse(x, y, w, h,r, g, b, ir, ig, ib));
                        repaint(); 
                    }
		   if (evt.getKeyChar() == 'c') {
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
				  
                        fs.add(new Circle(x, y, w, h, r, g, b, ir, ig, ib));
                        repaint();
                    }
		  if (evt.getKeyChar() == 't') {
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
                            fs.add(new Trian(x, y, w, h, r, g, b, ir, ig, ib));
                            repaint(); 
                        }

                }
            }
        );
this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent evt) {
                        save = null;
                        x = evt.getX();
                        y = evt.getY();
                        for (Figure fig : fs) {
                            if (fig.VerP(x,y,fig)) {
                                save = fig;
                                i=fs.indexOf(fig);
                                z = 1;
                            }
                        }
                        if (save!=null) {
                            fs.remove(i);
                            fs.add(save);
                        }
                        if (z == 1) {
                            save.local();
                            repaint();
                            z = 0;
                        }
                    }

                });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {

                save2 = null;
                for (Figure fig : fs) {
                    if (fig.VerP(e.getX(),e.getY(),fig)) {
                        save2 = fig;
                        z=1;
                    }  
                }
                if(z==1){
                    z=0;
                    save2.mdrag(e.getX()-(save2.w)/2,e.getY()-(save2.h)/2);
                    repaint();
                }
            }
        });


        this.setTitle("Lista Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure f: this.fs) {
            f.paint(g);
        }
    }
}
