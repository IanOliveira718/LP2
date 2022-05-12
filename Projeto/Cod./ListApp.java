import figures.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}
@SuppressWarnings("unchecked")
class ListFrame extends JFrame {
    ArrayList<Figure> fs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure save=null;
    Figure save2=null;
    boolean b=false;
    int x=350/2;
    int y=350/2;
    int z=0;
    int i=0;
    int k=0;

    ListFrame () {
	    try{
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o =new ObjectInputStream(f);
            this.fs = (ArrayList<Figure>) o.readObject();
            o.close();
            k=fs.size();

            }catch(Exception x){
                System.out.println("Erro!");}
	   
	
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
			
			try{
                            FileOutputStream f = new FileOutputStream("proj.bin");
                            ObjectOutputStream o =new ObjectOutputStream(f);
                            o.writeObject(fs);
                            o.flush();
                            o.close();
                        }catch(Exception x){}
			
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
			
		        if (evt.getKeyChar() == 'g') {
                            if (save != null) {
                                save.changeC(10,0, 0);
                                repaint();
                            }
                        }if (evt.getKeyChar() == 'b') {
                            if (save != null) {
                                save.changeC(-10,0, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 'h') {
                            if (save != null) {
                                save.changeC(0,10, 0);
                                repaint();
                            }
                        }if (evt.getKeyChar() == 'n') {
                            if (save != null) {
                                save.changeC(0,-10, 0);
                                repaint();
                            }
                        }
                        if (evt.getKeyChar() == 'j') {
                            if (save != null) {
                                save.changeC(0,0,10);
                                repaint();
                            }
                        }if (evt.getKeyChar() == 'm') {
                            if (save != null) {
                                save.changeC(0,0,-10);
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
                        
                        if(evt.getKeyChar() == 'l') {
                            if (save != null) {
                                save=null;
                                fs.remove(i);
                                repaint();
				k=k-1;
                            }
                        }
			
			if(evt.getKeyChar() == 'f') {
                            if(k>0){
                                if(i>=k-1){
                                    i=0;
                                }
                                else{
                                    i=i+1;
                                }
                                if(save!=null){
                                    save.setf(false);
                                } 
                                save = fs.get(i);
                                
                                fs.remove(i);
                                save.setf(true);
                                fs.add(save);
                                for (Figure fig : fs) {
                                	if(fig==save){
                                            i=fs.indexOf(fig);
                                        }
                                    } 
                                repaint();                           
                            }
                        }
			
                    if (evt.getKeyChar() == 'r') {
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
		 	int b = rand.nextInt(255);
			int ir = rand.nextInt(255);
			int ig = rand.nextInt(255);
			int ib = rand.nextInt(255);
                        fs.add(new Rect(x-w/2, y-h/2, w, h,r, g, b, ir, ig, ib,false));
			k=k+1;
                        repaint();
                    }
			    
                    if (evt.getKeyChar() == 'e') {
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			int ir = rand.nextInt(255);
			int ig = rand.nextInt(255);
			int ib = rand.nextInt(255);
                        fs.add(new Ellipse(x-w/2, y-h/2, w, h,r, g, b, ir, ig, ib,false));
			k=k+1;
                        repaint(); 
                    }
		   if (evt.getKeyChar() == 'c') {
                            int w = rand.nextInt(50);
                            int h = rand.nextInt(50);
                            int r = rand.nextInt(255);
                            int g = rand.nextInt(255);
                            int b = rand.nextInt(255);
                            int ir = rand.nextInt(255);
                            int ig = rand.nextInt(255);
                            int ib = rand.nextInt(255);
				  
                        fs.add(new Circle(x-w/2, y-h/2, w, h, r, g, b, ir, ig, ib,false));
			k=k+1;   
                        repaint();
                    }
		  if (evt.getKeyChar() == 't') {
                            int w = rand.nextInt(50);
                            int h = rand.nextInt(50);
                            int r = rand.nextInt(255);
                            int g = rand.nextInt(255);
                            int b = rand.nextInt(255);
                            int ir = rand.nextInt(255);
                            int ig = rand.nextInt(255);
                            int ib = rand.nextInt(255);
                            fs.add(new Trian(x-w/2, y-h/2, w, h, r, g, b, ir, ig, ib,false));
			    k=k+1;
                            repaint(); 
                        }

                }
            }
        );

		this.addMouseListener(
                	new MouseAdapter() {
                    	public void mousePressed(MouseEvent evt) {
                        	if(save!=null){
                            		if(save.clickdrag(evt.getX(),evt.getY())){
                                	b=true;
                            	}
                            	else{
                               		b=false;
                                	save.setf(false);
                                	repaint();
                            	}
                        }
                        if(b!=true){
                            save = null;
                            x = evt.getX();
                            y = evt.getY();
                            for (Figure fig : fs) {
                                if (fig.clicked(x,y)) {
                                    save = fig;
                                    i=fs.indexOf(fig);
                                    z = 1;
                                }
                            }
                            if (save!=null) {
                                fs.remove(i);
                                save.setf(true);
                                fs.add(save);
                                for (Figure fig : fs) {
                                    if(fig==save){
                                    i=fs.indexOf(fig);
                                    }
                                }
                            }
                            if (z == 1) {
                                save.local();
                                repaint();
                                z = 0;
                            }
                        }
                    }
                });

        	this.addMouseMotionListener(new MouseMotionAdapter() {
            	public void mouseMoved(MouseEvent ev) {
                	x=ev.getX();
                	y=ev.getY();
             	}
            	public void mouseDragged(MouseEvent e) {
                	if(b){
                    	if(e.getX()-save.getx()>0 && e.getY()-save.gety()>0){
                        	save.psize(e.getX()-save.getx(), e.getY()-save.gety());
                        	repaint();
                    	}
                    
                	}
                	if(b==false && save!=null){
                    	save2 = null;
                    	

                    	for (Figure fig : fs) {
                        	if (fig.clicked(e.getX(),e.getY())) {
                        	save2 = fig;
                        	z=1; 
                        	}  
                   	 }
                    	if(z==1){
                        	z=0;
                        	save2.mdrag(e.getX(),e.getY());
                        	repaint();
                    			}
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
