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
    int x,y;


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
                public void keyPressed (KeyEvent evt) {//2 fs.add(new Txt(50, 50,255, 0, 0, "Haha"));
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
                        fs.add(new Rect(x, y, w, h,r, g, b, ir, ig, ib));
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
                        fs.add(new Ellipse(x, y, w, h,r, g, b, ir, ig, ib));
                        repaint(); 
                    }//1
if (evt.getKeyChar() == 'c') {//1
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int cx = rand.nextInt(350);
                        int cy = rand.nextInt(350);
				  int r = rand.nextInt(255);
				  int g = rand.nextInt(255);
				  int b = rand.nextInt(255);
				  int x2 = rand.nextInt(350);
				  int y2 = rand.nextInt(350);
				  
                        fs.add(new Quadcurve(x, y, cx, cy, x2, y2, r, g, b));
                        repaint();
                    }//1


                }//2
            }//3
        );//4

	this.addMouseListener(
	new MouseAdapter(){
		public void  mousePressed (MouseEvent evt){
	save=null;
	x=evt.getX();
	y=evt.getY();
	for (Figure fig: fs){
		if(x>=fig.x && x<=fig.x + fig.w &&  y>=fig.y && y<=fig.y + fig.h){
		save=fig;
		z=1;
		}
	if(z==1){save.local(); z=0;}
	}
}


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
