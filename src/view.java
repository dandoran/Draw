import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
class View extends Canvas implements MouseListener, MouseMotionListener{
 
	
	ArrayList<Shape> shape = new ArrayList<Shape>();
	public String buttonName= "";
	public int clickX, clickY,count = 0;

    public void paint(Graphics g) {

 //Make first item color black
    	if(shape.size()==0)
    		shape.add(new ShapeColor(0,0,0));
//Draw every shape in the array list   
    	for(Shape s:shape)
            s.draw(g);
    }
/*    public void update(Graphics g)
    {
    	BufferedImage image = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
    	Graphics g2 = image.getGraphics();
    	
    	paint(g2);
    	g.drawImage(image, 0,0,null);
    	g2.setColor(Color.white);
    	g2.drawRect(0, 0, 800, 800);
    }
*/
	@Override
	public void mouseClicked(MouseEvent event) {
	
	}


	@Override
	public void mouseEntered(MouseEvent event) {
	

		
	}


	@Override
	public void mouseExited(MouseEvent event) {

	}


	@Override
	public void mousePressed(MouseEvent event) {
		
	}


	@Override
	public void mouseReleased(MouseEvent event) {
		
		count = 0; 
		if(buttonName.equals("delete"))
		{
			
		
		for (int i = 0; i < shape.size(); i++) 
			if(shape.get(i).removeShape(event.getX(), event.getY()))
				shape.remove(i);
		

		this.repaint();
		
		}
	}


	@Override
	public void mouseDragged(MouseEvent event) {

/*Get current x,y location*/		
		int releaseX = event.getX();
		int releaseY = event.getY();
		
/*Calculate needed distances*/
		
		int distance = Math.abs(releaseX-clickX) + Math.abs(releaseY-clickY);
		int dx = Math.abs(clickX - releaseX);
		int dy = Math.abs(clickY -  releaseY);
		
/*Draw based on last button pressed*/
		
		if(buttonName.equals("brush"))
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Circle(clickX,clickY,10,true));
		}
		else if(buttonName.equals("circle") && count == 0)
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Circle(clickX,clickY,1,false));
			count++;
		}
		else if(buttonName.equals("circle"))
		{
			shape.set(shape.size()-1,new Circle(clickX,clickY,distance/2,false));
		}
		else if(buttonName.equals("filled circle") && count == 0)
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Circle(clickX,clickY,1,false));
			count++;
		}
		else if(buttonName.equals("filled circle"))
		{
			shape.set(shape.size()-1,new Circle(clickX,clickY,distance/2,true));
		}
		
		else if(buttonName.equals("square") && count == 0)
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Square(clickX,clickY,1,false));
			count++;
		}
		else if(buttonName.equals("square"))
		{
			shape.set(shape.size()-1,new Square(clickX,clickY,distance/2,false));
		}
		else if(buttonName.equals("filled square") && count == 0)
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Square(clickX,clickY,1,true));
			count++;
		}
		else if(buttonName.equals("filled square"))
		{
			shape.set(shape.size()-1,new Square(clickX,clickY,distance/2,true));
		}
		
		else if(buttonName.equals("rectangle") && count == 0)
		{
			
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Rectangle(clickX,clickY,dx,dy, false));
			count++;
		}
		else if(buttonName.equals("rectangle"))
		{
			shape.set(shape.size()-1,new Rectangle(clickX,clickY,dx,dy, false));
		}
		
		else if(buttonName.equals("filled rectangle") && count == 0)
		{
			
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Rectangle(clickX,clickY,dx,dy, true));
			count++;
		}
		else if(buttonName.equals("filled rectangle"))
		{
			shape.set(shape.size()-1,new Rectangle(clickX,clickY,dx,dy, true));
		}
		else if(buttonName.equals("line") && count == 0)
		{
			clickX = event.getX();
			clickY = event.getY();
			shape.add(new Line(clickX,clickY,releaseX,releaseY));
			count++;
		}
		else if(buttonName.equals("line"))
		{
			shape.set(shape.size()-1,new Line(releaseX,releaseY,clickX,clickY));
		}
		
		
		
		
		this.repaint();
	}


	@Override
	public void mouseMoved(MouseEvent event) {

		
	}
}
