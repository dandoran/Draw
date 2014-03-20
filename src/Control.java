import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Control implements ActionListener  {



		Frame app;
		View v;
		String file,dir,loc;
		public Control(Frame app,View v)
		{
			this.app = app;
			this.v = v;
		}
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
	
//Create file open dialog
		
		FileDialog open = new FileDialog(app);
		open.setVisible(true);
		String filename = open.getFile();
		String directory = open.getDirectory();
//Check if it is .txt 
		if(filename.contains(".txt"))
			Draw(directory + filename);
		else
			System.out.println("Error must be .txt");
	}
	
	
	public void Draw(String loc){
		
//Create file reader
		
		FileReader read = null;
		try {
			read = new FileReader(loc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner scan = new Scanner(read);

//Break each line into an array and find the shape 
		while (scan.hasNextLine())
		{
			String shapeLine = scan.nextLine();

			
			String[] shapeElement = shapeLine.split("  *");

			if(shapeElement[0].equals("color"))
			{
				ShapeColor sc = new ShapeColor(new Integer(shapeElement[1]),new Integer(shapeElement[2]),new Integer(shapeElement[3]));
				v.shape.add(sc);
			}
			if(shapeElement[0].equals("circle"))
			{
				Circle circ = new Circle(new Integer(shapeElement[1]), new Integer(shapeElement[2]),
						new Integer(shapeElement[3]), false);
				v.shape.add(circ);
			}
			else if(shapeElement[0].equals("filledcircle"))
			{
				Circle circ = new Circle(new Integer(shapeElement[1]), new Integer(shapeElement[2]),
						new Integer(shapeElement[3]), true);
				v.shape.add(circ);
			}
			else if(shapeElement[0].equals("rectangle"))
			{
				Rectangle rect = new Rectangle(new Integer(shapeElement[1]),
						new Integer(shapeElement[2]), new Integer(shapeElement[3]),
						new Integer(shapeElement[4]),  false);
				v.shape.add(rect);
			}

			else if(shapeElement[0].equals("filledrectangle"))
			{
				Rectangle rect = new Rectangle(new Integer(shapeElement[1]),
						new Integer(shapeElement[2]), new Integer(shapeElement[3]),
						new Integer(shapeElement[4]),  true);
				v.shape.add(rect);
			}
			else if(shapeElement[0].equals("square"))
			{
				Square sqr = new Square(new Integer(shapeElement[1]),
						new Integer(shapeElement[2]), new Integer(shapeElement[3]),
						 false);
				v.shape.add(sqr);
			}
			else if(shapeElement[0].equals("filledsquare"))
			{
				Square sqr = new Square(new Integer(shapeElement[1]),
						new Integer(shapeElement[2]), new Integer(shapeElement[3]),
						  true);
				v.shape.add(sqr);
			}
			else if(shapeElement[0].equals("line"))
			{
				int x1 = new Integer(shapeElement[1]);
				int y1 = new Integer(shapeElement[2]);
				int x2 = new Integer(shapeElement[3]);
				int y2 = new Integer(shapeElement[4]);
				
				Line ls = new Line(x1, y1, x2, y2);
				v.shape.add(ls);
			}

			v.repaint();
		}
	}
	
	
	
	
	
	
}
