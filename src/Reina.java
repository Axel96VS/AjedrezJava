public class Reina extends Pieza{
	
	public Reina(){
		
	}
	public Reina(int y,int x, String color){
		super.setColor(color);
		super.setPosX(x);
		super.setPosY(y);
	}
	
	public int[][] posiblesMovimientos(){
		
		int movimientos[][] = new int[27][2];
		
		for(int i=0; i<movimientos.length; i++)
		{
			movimientos[i][0]=-1;
			movimientos[i][1]=-1;
		}
		
		int x=super.getPosX(), y=super.getPosY(), cont=0;
		
		//Arriba
		y--;
		while( y>=Tablero.minColumnas ){
			movimientos[cont][0]=super.getPosX();
			movimientos[cont][1]=y;
			y--;
			cont++;
		}
		
		//Derecha
		y=super.getPosY();
		x++;
		while( x<=Tablero.maxColumnas ){
			movimientos[cont][0]=x;
			movimientos[cont][1]=super.getPosY();
			x++;
			cont++;
		}
		
		//Abajo
		x=super.getPosX();
		y++;
		while( y<=Tablero.maxColumnas ){
			movimientos[cont][0]=super.getPosX();
			movimientos[cont][1]=y;
			y++;
			cont++;
		}
		
		//Izquierda
		y=super.getPosY();
		x--;
		while( x>=Tablero.minColumnas ){
			movimientos[cont][0]=x;
			movimientos[cont][1]=super.getPosY();
			x--;
			cont++;
		}
		
		
		//----Diagonal----
		
		x=super.getPosX();
		y=super.getPosY();
		
		//arriba izquierda
		x--;
		y--;
		while(x>=Tablero.minColumnas && y>=Tablero.minColumnas)
		{
			movimientos[cont][0]=x;
			movimientos[cont][1]=y;
			x--;
			y--;
			cont++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//arriba derecha
		x++;
		y--;
		while(x<=Tablero.maxColumnas && y>=Tablero.minColumnas)
		{
			movimientos[cont][0]=x;
			movimientos[cont][1]=y;
			x++;
			y--;
			cont++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//abajo derecha
		x++;
		y++;
		while(x<=Tablero.maxColumnas && y<=Tablero.maxColumnas)
		{
			movimientos[cont][0]=x;
			movimientos[cont][1]=y;
			x++;
			y++;
			cont++;
		}
		
		x=super.getPosX();
		y=super.getPosY();
		//abajo izquierda
		x--;
		y++;
		while(x>=Tablero.minColumnas && y<=Tablero.maxColumnas)
		{
			movimientos[cont][0]=x;
			movimientos[cont][1]=y;
			x--;
			y++;
			cont++;
		}

		
		return movimientos;
	}
	
	public String toString(){
		if(super.getColor().equals("B")){
			return "♕";
		}
		else{
			return "♛";
		}
	}	
	
}