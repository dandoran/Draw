import java.awt.Graphics;


public class Rectangle extends Shape {

	int x, y, width, height;
	boolean filled;

	
	Rectangle(int x, int y, int width, int height,  boolean filled)
	{
		this.x = x;
		this.y=y;
		this.width=width;
		this.height=height;

		this.filled=filled;
	}
	
	public void draw(Graphics g)
	{
		if(filled)
			g.fillRect(x-width/2, y-height/2, width, height);
		else
			g.drawRect(x-width/2, y-height/2, width, height);
		
	}

	@Override
	public boolean removeShape(int screenX, int screenY) {

		return Math.abs(screenX - x) <= width/2 && Math.abs(screenY - y) <= height/2 ; 
	}

	@Override
	public String saveString() 
	{
		if(filled)
			return "filledrectangle " + x + " " + y + " " + width + " " + height; 
		
		return "rectangle " + x + " " + y + " " + width + " " + height;  
	}
}
