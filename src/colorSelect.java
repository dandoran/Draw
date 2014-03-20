import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;


public class colorSelect implements ActionListener {

	private View view;
	public JFrame colorFrame = new JFrame();
	public colorSelect(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		Color temp = JColorChooser.showDialog(colorFrame, "color", Color.black);
		
		if(temp != null)
		{
			int R = temp.getRed();
			int G = temp.getGreen();
			int B = temp.getBlue();
			view.shape.add(new ShapeColor(R, G, B));	
		}

		
	}

}
