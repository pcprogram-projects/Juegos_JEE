import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Figure extends JButton implements ActionListener{
	private final int  xTabPos,yTabPos;
	private int xPos, yPos;
	private int dimension;

	public Figure(int xTabPos, int yTabPos, ImageIcon subimagen, int dimension) {

		this.xTabPos=xTabPos;
		this.yTabPos=yTabPos;
		this.dimension=dimension;

		xPos=xTabPos;
		yPos=yTabPos;

		this.setIcon(subimagen);

		this.setPreferredSize(new Dimension(subimagen.getIconWidth(),subimagen.getIconHeight()));
		this.addActionListener(this);
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxTabPos() {
		return xTabPos;
	}

	public int getyTabPos() {
		return yTabPos;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Move();

	}


	private void Move() {
		Celda[][] board=  Board.board;
		/* 1  */
		try {
			if(board[xPos][yPos-1].getFigura()== null) {

				Board.board[xPos][yPos-1].setFigura(this);
				Board.board[xPos][yPos].setFigura(null);
				yPos--;
				Puzzle.board.Remover();
				ComprovarRespuesta();
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e) {

		}
		/*  2  */
		try {
			if(board[xPos][yPos+1].getFigura()== null) {

				Board.board[xPos][yPos+1].setFigura(this);
				Board.board[xPos][yPos].setFigura(null);
				yPos++;
				Puzzle.board.Remover();
				ComprovarRespuesta();
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e) {

		}
		/* 3  */
		try {
			if(board[xPos+1][yPos].getFigura()== null) {

				Board.board[xPos+1][yPos].setFigura(this);
				Board.board[xPos][yPos].setFigura(null);
				xPos++;
				Puzzle.board.Remover();
				ComprovarRespuesta();
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e) {

		}

		/*  4   */
		try {
			if(board[xPos-1][yPos].getFigura()== null) {

				Board.board[xPos-1][yPos].setFigura(this);
				Board.board[xPos][yPos].setFigura(null);
				xPos--;
				Puzzle.board.Remover();
				ComprovarRespuesta();
				return;
			}

		}catch(ArrayIndexOutOfBoundsException e) {

		}

	}

	private void ComprovarRespuesta() {
   Figure figura=null;
   
   for(int i = 0; i <dimension; i++) {
	   for(int j=0;j<dimension;j++) {
		   figura= Board.board[i][j].getFigura();
		   if(figura==null) {
			   continue;
		   }
		   if(figura.getxPos() != figura.getxTabPos() ||
		      figura.getyPos() != figura.getyTabPos()) {
			     return;
		   }  
	   }
   }
   
   JOptionPane.showMessageDialog(new JPanel(),"felicitaciones has acabado el rompecabezas", "Rompecbezas",JOptionPane.INFORMATION_MESSAGE);
	}

}
