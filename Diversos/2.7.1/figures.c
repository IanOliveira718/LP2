#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
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

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////NEW////////////////////////
typedef struct {
    Figure super;
    char w[50];
} Texto;

void Texto_print (Texto* this) {
    Figure* sup = (Figure*) this;
    printf("Texto %s na posicao (%d,%d).\n",this->w, sup->x, sup->y);
}

Texto* Texto_new (int x, int y, char w[]) {
    Texto* this = malloc(sizeof(Texto));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Texto_print;
    sup->x = x;
    sup->y = y;
    strcpy(this->w,w);
}

///////////////////////////////////////////////////////////////////////////////NEW//////////////////////
typedef struct {
    Figure super;
    int cx, cy,x2,y2;
} CubCurve;

void CubCurve_print (CubCurve* this) {
    Figure* sup = (Figure*) this;
    printf("Curva quadratica com control points em (%d,%d), x e y em (%d,%d) e pontos finais em (%d,%d).\n",
           this->cx, this->cy, sup->x, sup->y,this->x2, this->y2);
}

CubCurve* CubCurve_new (int x, int y,int cx, int cy,int x2, int y2) {
    CubCurve* this = malloc(sizeof(CubCurve));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) CubCurve_print;
    sup->x = x;
    sup->y = y;
    this->cx = cx;
    this->cy = cy;
    this->x2 = x2;
    this->y2 = y2;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
	char str[]="testing";
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) CubCurve_new(10,10,100,100,20,10),
        (Figure*) Texto_new(210,110,str)
    };

    ///
	int i;
    for (i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
