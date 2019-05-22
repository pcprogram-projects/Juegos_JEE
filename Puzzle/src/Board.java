import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel{

	public static Celda [][] board;
	private ArrayList<Celda> completeboard = new ArrayList<Celda>();
	private int dimension;
	private int x,y;
	private int figWidth, figHeight;
	private JLabel empty;
	
	public Board(int dimension, BufferedImage rompecabezas) {
	this.dimension=dimension;
	board = new Celda[dimension][dimension];
	this.setBackground(Color.black);
	x=0;
	y=0;
	
	figWidth =rompecabezas.getWidth()/ dimension;
	figHeight=rompecabezas.getHeight() /dimension;
	
	this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
	for(int i=0;i<dimension;i++) {
		for(int j=0;j<dimension;j++) {
			
			if(i==dimension -1 && j== dimension-1) {
				continue;
			}
			completeboard.add(new Celda(i,j, new Figure(i,j,new ImageIcon(rompecabezas.getSubimage(x, y,figWidth,figHeight)),dimension)));
		  
			x += figWidth;
		
		}
		
		x=0;
		y += figHeight;
	}
	Desordenar();
	
	Remover();
	}
	
	private void Desordenar() {
		Random generador =new Random();
		ArrayList<Celda> copia=new ArrayList<Celda>(completeboard);
		
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				
				if(i==dimension -1 && j== dimension-1) {
					board[i][j]=new Celda(i,j);
					continue;
				}
				int aleatorio=generador.nextInt(completeboard.size());
				completeboard.get(aleatorio).getFigura().setxPos(i);
				completeboard.get(aleatorio).getFigura().setyPos(j);
				board[i][j]=new Celda(i,j, completeboard.get(aleatorio).getFigura());
				completeboard.remove(aleatorio);
			}
			
			
		}
		completeboard=copia;
		Remover();
		
	}
	private void Actualizar() {
		
		for(int i=0;i<dimension;i++) {
			for(int j=0;j<dimension;j++) {
				if(board[i][j].getFigura()== null) {
					empty= new JLabel();
					empty.setPreferredSize(new Dimension(figWidth,figHeight));
					this.add(empty);
					continue;
				}
				this.add(board[i][j].getFigura());
				
			}}
		Puzzle.contenedor.validate();
		
		
		
	}
	public void Remover() {
		this.removeAll();
		Actualizar();
	}
}
