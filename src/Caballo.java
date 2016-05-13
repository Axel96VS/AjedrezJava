public class Caballo extends Pieza {
	
	

	
	public Caballo(){
		
	}
	public Caballo(int y,int x, String color){
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
		
		if( (super.getPosX()+1)<=Tablero.maxColumnas && (super.getPosY()-2)>=Tablero.minColumnas ){
			movimientos[0][0]=(super.getPosX()+1);
			movimientos[0][1]=(super.getPosY()-2);
		}
		
		if( (super.getPosX()+2)<=Tablero.maxColumnas && (super.getPosY()-1)>=Tablero.minColumnas ){
			movimientos[1][0]=(super.getPosX()+2);
			movimientos[1][1]=(super.getPosY()-1);
		}
		
		if( (super.getPosX()+2)<=Tablero.maxColumnas && (super.getPosY()+1)<=Tablero.maxColumnas ){
			movimientos[2][0]=(super.getPosX()+2);
			movimientos[2][1]=(super.getPosY()+1);
		}
		
		if( (super.getPosX()+1)<=Tablero.maxColumnas && (super.getPosY()+2)<=Tablero.maxColumnas ){
			movimientos[3][0]=(super.getPosX()+1);
			movimientos[3][1]=(super.getPosY()+2);
		}
		if( (super.getPosX()-1)>=Tablero.minColumnas && (super.getPosY()+2)<=Tablero.maxColumnas ){
			movimientos[4][0]=(super.getPosX()-1);
			movimientos[4][1]=(super.getPosY()+2);
		}
		
		if( (super.getPosX()-2)>=Tablero.minColumnas && (super.getPosY()+1)<=Tablero.maxColumnas ){
			movimientos[5][0]=(super.getPosX()-2);
			movimientos[5][1]=(super.getPosY()-1);
		}
		
		if( (super.getPosX()-2)>=Tablero.minColumnas && (super.getPosY()-1)>=Tablero.minColumnas ){
			movimientos[6][0]=(super.getPosX()-2);
			movimientos[6][1]=(super.getPosY()-1);
		}
		
		if( (super.getPosX()-1)>=Tablero.minColumnas && (super.getPosY()-2)>=Tablero.minColumnas ){
			movimientos[7][0]=(super.getPosX()-1);
			movimientos[7][1]=(super.getPosY()-2);
		}
		
		return movimientos;	
	}
	
	public String toString(){
		if(super.getColor().equals("B")){
			return "♘";
		}
		else{
			return "♞";
		}
	}
	
}