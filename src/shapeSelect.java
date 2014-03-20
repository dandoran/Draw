import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class shapeSelect implements ActionListener {

	private String string;
	private View view;

	public shapeSelect(String string, View view) {
		this.string = string;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.buttonName = string;
		
	}

}
