public class Pieza {
	
	private int posX;
	private int posY;
	private String color;
	
	
	public Pieza(){
		
	}
	
	public Pieza(int y,int x, String color){
		this.setColor(color);
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public int[][] posiblesMovimientos(){
		return null;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		if( posX>=Tablero.minColumnas && posX<=Tablero.maxColumnas ){
			this.posX = posX;
		}
	}
	
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		if( posY>=Tablero.minColumnas && posY<=Tablero.maxColumnas ){
			this.posY = posY;
		}
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}