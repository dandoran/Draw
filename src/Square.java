import java.awt.Graphics;


public class Square extends Shape {

	int x, y, width;
	boolean filled;

	
	Square(int x, int y, int width, boolean filled)
	{
		this.x = x;
		this.y = y;
		this.width=width;
		this.filled=filled;
	}
	
	public void draw(Graphics g)
	{
		if(filled)
			g.fillRect(x-width/2, y-width/2, width, width);
		else
			g.drawRect(x-width/2, y-width/2, width, width);
	}

	@Override
	public boolean removeShape(int screenX, int screenY) {
		return Math.abs(screenX - x) <= width/2 && Math.abs(screenY - y) <= width/2 ; 
		// TODO Auto-generated method stub
		
	}

	@Override
	public String saveString() {
		
		if(filled)
			return "filledsquare " + x + " " + y + " " + width; 
		
		return "square " + x + " " + y + " " + width;
	}
}
