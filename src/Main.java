import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Main {


	public static void main(String[] args) 
	{

//Create new frame
		Frame app = new Frame("Draw");
		View view = new View();


		app.add(view);
		view.setSize(800,800);
		
//Create side bar buttons
		ImageIcon colorImage = new ImageIcon("images/color.png");
		ImageIcon circle = new ImageIcon("images/circle.jpg");
		ImageIcon filledCircleImage = new ImageIcon("images/filledcircle.jpg");
		ImageIcon squareImage = new ImageIcon("images/square.jpg");
		ImageIcon filledSquareImage = new ImageIcon("images/filledsquare.jpg");
		ImageIcon rectangleImage = new ImageIcon("images/rect.jpg");
		ImageIcon filledrectangleImage = new ImageIcon("images/filledrect.jpg");
		ImageIcon lineImage = new ImageIcon("images/line.jpg");
		ImageIcon deleteImage = new ImageIcon("images/delete.png");	
		ImageIcon brushImage = new ImageIcon("images/brush.png");	
		
		JButton removeShape = new JButton(deleteImage);
		JButton color = new JButton(colorImage);
		JButton circleButton = new JButton(circle);
		JButton filledCircle = new JButton(filledCircleImage);
		JButton square = new JButton(squareImage);
		JButton filledSquare = new JButton(filledSquareImage);
		JButton rectangle = new JButton(rectangleImage);
		JButton filledRectangle = new JButton(filledrectangleImage);
		JButton line = new JButton(lineImage);
		JButton brush = new JButton(brushImage);
		
		BoxLayout horizontal = new BoxLayout(app,BoxLayout.X_AXIS);
		app.setLayout(horizontal);
		
		Container buttons = new Container();
		BoxLayout vertical = new BoxLayout(buttons,BoxLayout.Y_AXIS);
		buttons.setLayout(vertical);
		
		buttons.add(removeShape);
		buttons.add(color);
		buttons.add(circleButton);
		buttons.add(filledCircle);
		buttons.add(square);
		buttons.add(filledSquare);
		buttons.add(rectangle);
		buttons.add(filledRectangle);
		buttons.add(line);
		buttons.add(brush);
		
		buttons.setSize(100, 800);
		app.add(buttons);
		
//Create menubar and items		
		MenuBar bar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem open = new MenuItem("Import project");
		MenuItem save = new MenuItem("Export project");
		MenuItem saveImage = new MenuItem("Save image");

//Add listeners
		
		color.addActionListener(new colorSelect(view));
		
		removeShape.addActionListener(new shapeSelect("delete",view));		
		circleButton.addActionListener(new shapeSelect("circle",view));
		filledCircle.addActionListener(new shapeSelect("filled circle",view));
		square.addActionListener(new shapeSelect("square",view));
		filledSquare.addActionListener(new shapeSelect("filled square",view));
		rectangle.addActionListener(new shapeSelect("rectangle",view));		
		filledRectangle.addActionListener(new shapeSelect("filled rectangle",view));	
		line.addActionListener(new shapeSelect("line",view));
		brush.addActionListener(new shapeSelect("brush",view));
		
		open.addActionListener(new Control(app, view));
		save.addActionListener(new SaveFile(app,view));
		saveImage.addActionListener(new SaveImage(app,view));
		view.addMouseListener(view);
		view.addMouseMotionListener(view);
        app.addWindowListener(new Closer());

//Add elements to frame	
        
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveImage);
		bar.add(fileMenu);
		app.setMenuBar(bar);
		
		app.pack();
		app.setVisible(true);


	
		

	}

}
