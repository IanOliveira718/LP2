public class quadcurve{

	public static void main (String[] args){
		quadricurve c = new quadricurve (3,6,4,7,5,8,255,255,0);
		c.print();
		}
}

class quadricurve{

	int x,y,cx,cy,x2, y2,r,g,b;

	quadricurve(int x,int y,int cx,int cy,int x2,int y2,int r,int  g,int b){
	this.x=x;
	this.y=y;	
	this.cx=cx; 
	this.cy=cy; 
	this.x2=x2; 
	this.y2=y2;
	this.r=r;
	this.g=g;
	this.b=b;
	
	}
	void print(){
	System.out.format("begin (%d,%d)/ control points (%d,%d)/ final (%d,%d)/RGB color(%d,%d,%d)\n", this.x=x, this.y=y, this.cx=cx, this.cy=cy, this.x2=x2, this.y2=y2, this.r=r, this.g=g, this.b=b
);
	}
}