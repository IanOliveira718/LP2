#include<stdlib.h>
struct el{
	int x,y;
	int e1, e2;
	int r,g,b;
	int ir,ig,ib;
	float rot;
}elipse;


 void print(struct el e){
 	printf("Ponto inicial:(%d,%d)\nEixo 1: %d\nEixo 2:%d",e.x,e.y,e.e1,e.e2);
 	printf("Cor interna RGB: (%d,%d,%d) Cor Externa RGB: (%d,%d,%d)",e.ir,e.ig,e.ib,e.r,e.g,e.b);
 	printf("\nRotacao em graus: %.2f",e.rot);
 }
 
 int main(void){
 	struct el e;
 	e.x=1;
 	e.y=1;
 	e.e1=25;
 	e.e2=45;
 	e.r=255;
 	e.g=0;
 	e.b=0;
 	e.ir=0;
 	e.ig=0;
 	e.ib=255;
 	e.rot=45;
 	print(e);
 }
