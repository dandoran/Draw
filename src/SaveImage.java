import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SaveImage implements ActionListener {

	Frame app;
	View c;

	String filename, directory, location;


	public SaveImage(Frame app, View c) {
		this.app = app;
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		FileDialog savePNG = new FileDialog(app, "Save PNG File", FileDialog.SAVE);
		savePNG.setFilenameFilter(new FilenameFilter() {
 			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".png") || name.endsWith(".jpg");
			}
        });
        savePNG.setFile("Document.png");
        savePNG.setDirectory(savePNG.getDirectory());
        savePNG.setVisible(true);
        filename = savePNG.getFile();
        directory = savePNG.getDirectory();
        location = directory + filename;
		
		RenderedImage rendImage = myCreateImage(c);
		
		try {
		    // Save as PNG
		    File file = new File(location);
		    ImageIO.write(rendImage, "png", file);
		    
		    file = new File("newimage.jpg");
		    ImageIO.write(rendImage, "jpg", file);
		    
		} catch (IOException e) {
		}

	}

	private static RenderedImage myCreateImage(View c) {
		
		BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g2 = image.createGraphics();
		
		g2.setColor(Color.WHITE);
    	g2.fillRect(0, 0, c.getWidth(), c.getHeight());
		
		for(int i = 0; i < c.shape.size(); i++)
	    {
			Shape s = c.shape.get(i);
			s.draw(g2);
	    }

    	g2.dispose();
		return image;
	}

}