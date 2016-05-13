public class Alfil extends Pieza{
		
	public Alfil(){
		
	}
	public Alfil(int y,int x, String color){
		super.setColor(color);
		super.setPosX(x);
		super.setPosY(y);
	}
	
	public int[][] posiblesMovimientos(){
		
		int movimientos[][] = new int[13][2];
		
		for(int j=0; j<movimientos.length; j++)
		{
			movimientos[j][0]=-1;
			movimientos[j][1]=-1;
		}
		
		int i=0, x=super.getPosX(), y=super.getPosY();
		
		//arriba izquierda
		x--;
		y--;
		while(x>=Tablero.minColumnas && y>=Tablero.minColumnas)
		{
			movimientos[i][0]=x;
			movimientos[i][1]=y;
			x--;
			y--;
			i++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//arriba derecha
		x++;
		y--;
		while(x<=Tablero.maxColumnas && y>=Tablero.minColumnas)
		{
			movimientos[i][0]=x;
			movimientos[i][1]=y;
			x++;
			y--;
			i++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//abajo derecha
		x++;
		y++;
		while(x<=Tablero.maxColumnas && y<=Tablero.maxColumnas)
		{
			movimientos[i][0]=x;
			movimientos[i][1]=y;
			x++;
			y++;
			i++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//abajo izquierda
		x--;
		y++;
		while(x>=Tablero.minColumnas && y<=Tablero.maxColumnas)
		{
			movimientos[i][0]=x;
			movimientos[i][1]=y;
			x--;
			y++;
			i++;
		}
		
		return movimientos;
	}
	
	public String toString(){
		if(super.getColor().equals("B")){
			return "♗";
		}
		else{
			return "♝";
		}
	}
}