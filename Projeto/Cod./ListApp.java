import figures.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import button.Button;
import buttonextra.Button2;


class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}
@SuppressWarnings("unchecked")
class ListFrame extends JFrame {
    ArrayList<Figure> fs = new ArrayList<Figure>();
    ArrayList<Button> fb = new ArrayList<Button>();
    ArrayList<Button2> fb2 = new ArrayList<Button2>();
    Random rand = new Random();
    Figure save=null;
    Figure save2=null;
    Button auxb=null;
    Button2 auxb2=null;
 
    boolean b=false;
    int x=350/2;
    int y=350/2;
    int z=0;
    int i=0;
    int k=0;

    ListFrame () {
        fb.add(new Button(1, new Rect(1, 2, 3, 4, 0, 0, 0, 0, 0, 0, false)));
        fb.add(new Button(2, new Circle(1, 2, 3, 4, 0, 0, 0,0, 0, 0, false)));
        fb.add(new Button(3, new Ellipse(1, 2, 3, 1, 0, 0, 0,0, 0, 0, false)));
        fb.add(new Button(4, new Trian(1, 2, 3, 4, 0, 0, 0, 0, 0, 0, false)));
        fb2.add(new Button2(5, "Erase"));
        fb2.add(new Button2(6, "Clean"));

        repaint();
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
                        }if (evt.getKeyChar() == 'g') {
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
                                save = fs.get(i);
                                fs.remove(i);
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
				  
                        fs.add(new Circle(x-w/2, y-h/2, w, w, r, g, b, ir, ig, ib,false));
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
                                repaint();
                            }
                        }


                        if(b!=true){
                            x = evt.getX();
                            y = evt.getY();
                            for (Button b : fb) {
                                if(b.clicked(x,y)){
                                    auxb=b;
                                    z=1;
                                }
                            }
                            
                            if(z!=1){
                                if(auxb!=null){
                                    if(auxb.idx==1){
                                        fs.add(new Rect(evt.getX(),evt.getY(), 30, 40, 0, 0, 0, 255, 255, 255, false));
                                        k=k+1; 
                                    }
                                    if(auxb.idx==2){
                                        fs.add(new Circle(evt.getX(),evt.getY(), 30, 30, 0, 0, 0,255, 255, 255, false));
                                        k=k+1; 
                                    }
                                    if(auxb.idx==3){
                                        fs.add(new Ellipse(evt.getX(),evt.getY(), 40, 10, 0, 0, 0,255, 255, 255, false));
                                        k=k+1; 
                                    }
                                    if(auxb.idx==4){
                                        fs.add(new Trian(evt.getX(),evt.getY(), 30, 40, 0, 0, 0, 255, 255, 255, false));
                                        k=k+1; 
                                    }
                                    auxb=null;
                                }
                                for (Button2 b2 : fb2) {
                                    if(b2.clicked(x,y)){
                                        auxb2=b2;
                                    }
                                }
                                if(auxb2!=null){
                                    if(auxb2.idx==5){
                                        if(save!=null){
                                            save=null;
                                            fs.remove(i);
                                            k=k-1;
                                        }
                                    }
                                    if(auxb2.idx==6){
                                        save=null;
                                        fs.clear();
                                        k=0;
                                    }
                                    auxb2=null;
                                }
                                save = null;
                                for (Figure fig : fs) {
                                    if (fig.clicked(x,y)) {
                                        save = fig;
                                        i=fs.indexOf(fig);
                                        z = 1;
                                    }
                                } 
                            }
                            repaint();
                            if (save!=null) {
                                fs.remove(i);
                                fs.add(save);
                                for (Figure fig : fs) {
                                    if(fig==save){
                                    i=fs.indexOf(fig);
                                    }
                                }
                            }
                            if (z == 1) {
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
        this.setSize(750, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure f: this.fs) {
            f.paint(g,save==f);
        }
        for (Button b: this.fb) {
            b.paint(g,auxb==b);
        }
        for (Button2 b2: this.fb2) {
            b2.paint(g,auxb2==b2);
        }
    }
    

}
