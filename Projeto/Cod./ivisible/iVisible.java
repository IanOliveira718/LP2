package ivisible;

import java.awt.Graphics;

public interface iVisible{

    public boolean clicked(int x, int y);
    public void paint (Graphics g);
    
    public boolean clickdrag(int x, int y);
    public void setf(boolean b);
    public int getx();
    public int gety();
}
