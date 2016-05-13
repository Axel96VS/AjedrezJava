public class Rey extends Pieza {
	
	public Rey(){
		
	}
	public Rey(int y,int x, String color){
		super.setColor(color);
		super.setPosX(x);
		super.setPosY(y);
	}

	
	public int[][] posiblesMovimientos(){
		
		int movimientos[][] = new int[8][2];
		
		for(int i=0; i<movimientos.length; i++)
		{
			movimientos[i][0]=-1;
			movimientos[i][1]=-1;
		}
		
		int cont=0;
		
		for( int y=super.getPosY()-1; y<=super.getPosY()+1; y++ ){
			for( int x=super.getPosX()-1; x<=super.getPosX()+1; x++ ){
				//Condicion para mirar todas las posiciones alrededor del rey
				if(x>=Tablero.minColumnas && x<=Tablero.maxColumnas && y>=Tablero.minColumnas && y<=Tablero.maxColumnas && ( (y!=super.getPosY() && x==super.getPosX()) || (y==super.getPosY() && x!=super.getPosX()) || (y!=super.getPosY() &&x!=super.getPosX()))){
					movimientos[cont][0]=x;
					movimientos[cont][1]=y;
					cont++;
				}
			}
		}
		
		return movimientos;
	}
	
	public String toString(){
		if(super.getColor().equals("B")){
			return "♔";
		}
		else{
			return "♚";
		}
	}
	
	
}