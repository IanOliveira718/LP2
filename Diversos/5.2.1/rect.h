#ifndef RECT_H
	#define RECT_H
		typedef struct Rect Rect;
		Rect* rect_new(void);
		void rect_drag(Rect* this, int x, int y);
		void rect_print(Rect* this);
#endif
