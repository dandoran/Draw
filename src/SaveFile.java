import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveFile implements Ac/Users/danzdoran/Desktop/OLD Before Fall 2012/Draw/src/SaveFile.javationListener {


	Frame app;
	View v;
	String filename, directory;
	public SaveFile(Frame app, View v) {
		this.app = app;
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

//Create file save dialog
		
		FileDialog saveFile = new FileDialog(app, "Save File", FileDialog.SAVE);

//Set default save file name
		
		saveFile.setFile("Document.txt");
        saveFile.setDirectory(saveFile.getDirectory());
        saveFile.setVisible(true);
        filename = saveFile.getFile();
        directory = saveFile.getDirectory();
        outputFile(directory + filename);
	}

	private void outputFile(String location) 
	{
		try 
		{
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(location)));
			for(int i = 0; i < v.shape.size(); i++)
			{
				output.println(v.shape.get(i).saveString());
				output.checkError();
			}
		}
		catch(IOException ex)
		{
			System.err.println("Error writing to: " + location);
		}  
	}
}
