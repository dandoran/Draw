import java.awt.Graphics;


public class Line extends Shape{
    int x1, x2, y1, y2;

    Line(int x1, int y1, int x2, int y2) {
       	this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

	@Override
	public boolean removeShape(int screenX, int screenY) {
		return Math.abs(x1 - screenX) + Math.abs(y1 - screenY) + Math.abs(x2 - screenX) + Math.abs(y2 - screenY)
				<= Math.abs(x1 - x2) + Math.abs(y1 - y2) + 1 ;
		
	}

	@Override
	public String saveString()
	{
		return "line " + x1 + " " + y1 + " " + x2  + " " + y2;
	}

}
