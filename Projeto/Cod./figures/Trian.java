package figures;
import java.awt.*;
public class Trian extends Figure {
    private int  ir,ig,ib;
    public Trian(int x, int y, int w, int h, int r,int g,int b, int ir,int ig,int ib){
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
    public boolean clicked(int x, int y){
	boolean b=false;
        if(y>=this.y && y<=this.y+this.h){
            float newW=this.w*(y-this.y)/this.h;
            if(x>=this.x+(this.w/2)-(newW/2) && x<=this.x+(this.w/2)+(newW/2)){
                b=true;
            }
        }
        return(b);
     }


    public void paint(Graphics g,boolean b) {
        g.setColor(new Color(this.r, this.g, this.b));
        g.drawPolygon(new int[]{this.x+this.w,(2*this.x+this.w)/2,this.x},new int[] {this.y+this.h,this.y,this.y+this.h},3);
        g.setColor(new Color(this.ir, this.ig, this.ib));
        g.fillPolygon(new int[]{this.x+this.w,(2*this.x+this.w)/2,this.x},new int[] {this.y+this.h,this.y,this.y+this.h},3);
        if(b){
            g.setColor(new Color(0, 0, 0));
            g.drawRect(this.x-1, this.y-1, this.w+2, this.h+2);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(this.x+this.w, this.y+ this.h, -7, -7);
        }
        
    }
    public boolean clickdrag(int x, int y){
        return(x<=this.x+this.w && x>=this.x+this.w-7 && y<= this.y+ this.h && y>= this.y+ this.h-7);
     }
     public int getx(){
        return (this.x);
     }
      
     public int gety(){
        return (this.y);
     }
  
    public void local() {
        System.out.format("Local %d %d %d %d", this.x, this.y, this.w, this.h);
    }

    public void drag(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public  void mdrag(int x, int y){
        this.x=x-(this.w)/2;
        this.y=y-(this.h)/2;
    }
    public boolean VerP(int x,int y, Figure f){
        if (x >= f.x && x <= f.x + f.w && y >= f.y && y <= f.y + f.h){
            return true;
        }
        return false;
	}
    public  void psize(int w, int h){
        this.h = h;
        this.w = w;
     }

     public void changeC(int r, int g, int b){
        if(this.r+r<255){ 
            if(this.r+r<0){ this.r=0;}
            else{this.r=this.r+r;}
            
        }
        else{ this.r=255;}

        if(this.g+g<255){
            if(this.g+g<0){this.g=0;}
            else{this.g=this.g+g;}
        }
        else{this.g=255;}

        if(this.b+b<255){
            if(this.b+b<0){this.b=0;}
            else{this.b=this.b+b;}
        }
        else{this.b=255;}
     
    }
    public void changeCi(int r, int g, int b){

        if(this.ir+r<255){ 
            if(this.ir+r<0){ this.ir=0;}
            else{this.ir=this.ir+r;}
            
        }
        else{ this.ir=255;}

        if(this.ig+g<255){
            if(this.ig+g<0){this.ig=0;}
            else{this.ig=this.ig+g;}
        }
        else{this.ig=255;}

        if(this.ib+b<255){
            if(this.ib+b<0){this.ib=0;}
            else{this.ib=this.ib+b;}
        }
        else{this.ib=255;}
    }

}

