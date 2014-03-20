import java.awt.Color;
import java.awt.Graphics;

public class ShapeColor extends Shape{
    int red, green, blue;

    ShapeColor(int red, int green, int blue) {
         this.red = red;
         this.green = green;
         this.blue = blue;
    }

 

    @Override
    public void draw(Graphics g) {
    	Color type = new Color(red, green, blue);
        g.setColor(type);
    }



	@Override
	public boolean removeShape(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String saveString() {
		// TODO Auto-generated method stub
		return "color " + red +" " + green + " " + blue;
	}



}
