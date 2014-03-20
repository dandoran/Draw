import java.awt.Graphics;

abstract public class Shape {

	abstract public void draw(Graphics g);
	abstract public boolean removeShape(int x, int y);
	abstract public String saveString();
	
}