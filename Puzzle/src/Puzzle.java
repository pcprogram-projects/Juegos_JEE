import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Puzzle extends JFrame {
public static Container contenedor;
public static Board board;
private BufferedImage img;

	public Puzzle() {
		this.setTitle("Puzzle");
		this.setSize(650,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		contenedor =this.getContentPane();
				try {
			img= ImageIO.read(new File("C:\\Users\\PcProgram\\Desktop\\Puzzle\\Puzzle\\IMG\\FF8.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				board = new Board(4, img);
				contenedor.add(board);
				this.setVisible(true);
	}
	


}
