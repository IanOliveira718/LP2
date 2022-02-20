public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.drag(2,2);
	   System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", r1.w, r1.h, r1.x, r1.y);
        System.out.format("Area do Retangulo eh %d.\n", r1.area());
    }
}
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
 	void drag(int dx,int dy){
		  this.x=this.x+dx;
		  this.y=this.y+dy;
}
	int area(){
		  return (this.w)*(this.h);
}
}
