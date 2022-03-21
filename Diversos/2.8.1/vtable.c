#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef void  (* Figure_Drag)  (struct Figure*,int x, int y);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    void (* drag)	(struct Figure*,int x, int y);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Tri;

void tri_print (Tri* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de base e altura (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int tri_area (Tri* this) {
    Figure* sup = (Figure*) this;
    return (this->w * this->h)/2;
}

void tri_drag(Tri* this,int x, int y){
	Figure* sup = (Figure*) this;
	sup->x=sup->x+x;
	sup->y=sup->y+y;
}

Figure_vtable tri_vtable = {
    (Figure_Print) tri_print,
    (Figure_Area)  tri_area,
    (Figure_Drag)  tri_drag
};

Tri* tri_new (int x, int y, int w, int h) {
    Tri*   this  = malloc(sizeof(Tri));
    Figure* sup = (Figure*) this;
    sup->vtable = &tri_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}



///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int cx, cy,x2,y2;
} Qcurve;

void qcurve_print (Qcurve* this) {
    Figure* sup = (Figure*) this;
    printf("Curva quadratica com control points em (%d,%d), x e y em (%d,%d) e pontos finais em (%d,%d).\n",
           this->cx, this->cy, sup->x, sup->y,this->x2, this->y2);
}

int qcurve_area (Qcurve* this) {
    Figure* sup = (Figure*) this;
    int a,b;
    if(this->cy-this->y2<0){
    	a=(this->cy-this->y2)*(-1);
	}else{
		a=this->cy-this->y2;
	}
	if(sup->x-this->x2<0){
    	b=(sup->x-this->x2)*(-1);
	}else{
		b=sup->x-this->x2;
	}
    
    return  a*b;
}

void qcurve_drag(Qcurve* this,int x, int y){
	Figure* sup = (Figure*) this;
	sup->x=sup->x+x;
	sup->y=sup->y+y;
	this->cx=this->cx+x;
	this->cy=this->cy+y;
	this->x2=this->x2+x;
	this->y2=this->y2+y;
}

Figure_vtable qcurve_vtable = {
    (Figure_Print) qcurve_print,
    (Figure_Area)  qcurve_area,
    (Figure_Drag)  qcurve_drag
};

Qcurve* qcurve_new (int x, int y,int cx, int cy,int x2, int y2) {
    Qcurve*   this  = malloc(sizeof(Qcurve));
    Figure* sup = (Figure*) this;
    sup->vtable = &qcurve_vtable;
    sup->x = x;
    sup->y = y;
    this->cx = cx;
    this->cy = cy;
    this->x2 = x2;
    this->y2 = y2;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void rect_drag(Rect* this,int x, int y){
	Figure* sup = (Figure*) this;
	sup->x=sup->x+x;
	sup->y=sup->y+y;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Drag)  rect_drag
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void ellipse_drag(Ellipse* this,int x, int y){
	Figure* sup = (Figure*) this;
	sup->x=sup->x+x;
	sup->y=sup->y+y;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Drag)  ellipse_drag
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
	int i;
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) qcurve_new(20,40,150,170,50,60),
        (Figure*) tri_new(237,117,365,180)
    };
   	///	
   	
    for ( i=0; i<6; i++) {
        figs[i]->vtable->print(figs[i]);
    }

	///
	
	figs[0]->vtable->drag(figs[0],345,90); figs[1]->vtable->drag(figs[1],220,-50);
	figs[2]->vtable->drag(figs[2],-50,220);	figs[3]->vtable->drag(figs[3],90,345);
	figs[4]->vtable->drag(figs[4],-50,220);	figs[5]->vtable->drag(figs[5],90,345);

	
	
    ///
	printf("\n\n apos drag \n\n");
    for ( i=0; i<6; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for ( i=0; i<6; i++) {
        free(figs[i]);
    }
}
