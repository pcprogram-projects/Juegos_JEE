public class Celda {
  private final int x, y;
  private Figure figura;
 
  public Celda(int x, int y,Figure figura) {
	  this.x=x;
	  this.y=y;
	 this.figura=figura;
  }
  
  public Celda(int x, int y) {
	  this.x=x;
	  this.y=y; 
	  figura=null;
	  
  }

public Figure getFigura() {
	return figura;
}

public void setFigura(Figure figura) {
	this.figura = figura;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}
  
}
