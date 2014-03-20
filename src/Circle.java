import java.awt.Graphics;


public class Circle extends Shape {

	int x, y, radius;
	boolean filled;

	
	Circle(int x, int y, int radius, boolean filled)
	{
		this.x = x;
		this.y=y;
		this.radius=radius;
		this.filled=filled;
	}
	
	public void draw(Graphics g)
	{
		if(filled)
			g.fillOval(x-radius, y-radius, 2*radius, 2*radius);	
		else
			g.drawOval(x-radius, y-radius, 2*radius, 2*radius);	

	}

	@Override
	public boolean removeShape(int screenX, int screenY) 
	{
		return Math.abs(x-screenX)<=radius && Math.abs(y-screenY)<=radius;
	}

	@Override
	public String saveString() {
		if(filled)
			return "filledcircle " + x + " " + y + " " + radius + ""; 
		return "circle " + x + " " + y + " " + radius + ""; 
	}


}
