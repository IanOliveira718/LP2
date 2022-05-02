#include "rect.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct Rect{
    int w, h, x, y;
} Rect;

Rect* rect_new (void) {
    Rect*   r  = (Rect*)malloc(sizeof(Rect));
    r->x = 10;
    r->y = 10;
    r->w = 100;
    r->h = 100;
}

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, this->x, this->y, this->w * this->h);
}


void rect_drag(Rect* this,int x, int y){
	this->x=this->x+x;
	this->y=this->y+y;
}
