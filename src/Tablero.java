import java.awt.Color;

public class Tablero {
	
	public static final int maxColumnas = 7;
	public static final int minColumnas = 0;
	static Pieza[][] casillas = new Pieza[8][8];
	
	public Tablero(){
		
		for(int i=0; i<=maxColumnas; i++){
			//Torres
			if(i==0 || i==7){
				casillas[0][i] = new Torre(0,i,"N");
				casillas[7][i] = new Torre(7,i,"B");
			}
			//Caballos
			if(i==1 || i==6){
				casillas[0][i] = new Caballo(0,i,"N");
				casillas[7][i] = new Caballo(7,i,"B");
			}
			//Alfiles
			if(i==2 || i==5){
				casillas[0][i] = new Alfil(0,i,"N");
				casillas[7][i] = new Alfil(7,i,"B");
			}
			//Reina/Dama
			if(i==3) {
				casillas[0][i] = new Reina(0,i,"N");
				casillas[7][i] = new Reina(7,i,"B");
			}
			//Rey
			if(i==4){
				casillas[0][i] = new Rey(0,i,"N");
				casillas[7][i] = new Rey(7,i,"B");
			}
			//Peones Blancos
			casillas[6][i] = new Peon(6,i,"B");
			
			//Peones Negros
			casillas[1][i] = new Peon(1,i,"N");
		}		
	}
	
	public String toString(){
		String cadena="";
		cadena+="	_________________________________________________________________\n";
		for(int i=0; i<casillas.length; i++){
			cadena+="	|	|	|	|	|	|	|	|	|\n";
			cadena+=""+i+"	|";
			for(int j=0; j<casillas[i].length; j++){
				if(casillas[i][j]==null){
					cadena+="	|";
				}
				else{
					cadena+="   "+casillas[i][j]+"	|";
				}
			}
			cadena+="\n	|_______|_______|_______|_______|_______|_______|_______|_______|\n";
		}
		cadena+="y    x	";
		for(int k=0; k<casillas.length; k++){
			cadena+="    "+k+"	";
		}
		return cadena;
	}
	
	public int[][]movsPosibles(Pieza p){
		int[][] movs = p.posiblesMovimientos();
		
		if(p instanceof Caballo || p instanceof Rey){
			for(int i=0; i<movs.length; i++){
				if(movs[i][0] != -1 && movs[i][0] != -1){
					if( llenaYMismoColor(p, movs[i][0], movs[i][1]) ){
						movs[i][0]=-1;
						movs[i][1]=-1;
					}
				}
			}
		}
		
		if(p instanceof Peon){
			for(int i=0; i<movs.length; i++){
				if(movs[i][0] != -1 && movs[i][0] != -1){
					if( llenaYMismoColor(p, movs[i][0], movs[i][1]) || peonNoAtaque(p, movs[i][0], movs[i][1]) ){
						movs[i][0]=-1;
						movs[i][1]=-1;
					}
				}
			}
		}
		
		if (p instanceof Torre || p instanceof Reina){
			for(int i=0; i<movs.length; i++){
				if(movs[i][0] != -1 && movs[i][1] != -1){
					
					//Arriba
					if(movs[i][0]==p.getPosX() && movs[i][1]<p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]==p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]==p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					
					//Derecha
					if(movs[i][0]>p.getPosX() && movs[i][1]==p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]==p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]==p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					
					//Abajo
					if(movs[i][0]==p.getPosX() && movs[i][1]>p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]==p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]==p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					
					//Derecha
					if(movs[i][0]<p.getPosX() && movs[i][1]==p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]==p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]==p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
				}	
			}
		}
		
		if(p instanceof Alfil || p instanceof Reina){
			for(int i=0; i<movs.length; i++){
				if(movs[i][0] != -1 && movs[i][1] != -1){
					//arriba izquierda
					if(movs[i][0]<p.getPosX() && movs[i][1]<p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					//arriba derecha
					if(movs[i][0]>p.getPosX() && movs[i][1]<p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]<p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					//abajo derecha
					if(movs[i][0]>p.getPosX() && movs[i][1]>p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]>p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
					//abajo izquierda
					if(movs[i][0]<p.getPosX() && movs[i][1]>p.getPosY()){
						if(llenaYMismoColor(p, movs[i][0], movs[i][1])){
							for(int j=i; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						} else if(llenaYDistintoColor(p, movs[i][0], movs[i][1])){
							for(int j=i+1; j<movs.length; j++){
								if(movs[j][0]<p.getPosX() && movs[j][1]>p.getPosY()){
									movs[j][0]=-1;
									movs[j][1]=-1;
								}
							}
						}
					}
				}
			}
		}
		
		return movs;
	}
	
	private boolean llenaYMismoColor(Pieza p, int x, int y){
		if( casillas[y][x] != null && p.getColor().equals(casillas[y][x].getColor()) ){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean llenaYDistintoColor(Pieza p, int x, int y){
		if( casillas[y][x] != null && !p.getColor().equals(casillas[y][x].getColor()) ){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean peonNoAtaque(Pieza p, int x, int y){
		if( casillas[y][x] == null && x != p.getPosX() ){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean puedeMover(int num, int[][] movs) {
		
		if(movs[num][0] != -1 && movs[num][1] != -1){
			return true;
		}
		else{
			System.out.println("Numero incorrecto");
			return false;
		}
	}

	public static void moverMatar(int x, int y, Pieza p) {
		
		//Creo la pieza que se mueve en la casilla que toca
		if(p instanceof Peon){
			casillas[y][x] = new Peon(y ,x ,p.getColor());
		}else{
			if(p instanceof Torre){
				casillas[y][x] = new Torre(y ,x ,p.getColor());
			}else{
				if(p instanceof Caballo){
					casillas[y][x] = new Caballo(y ,x ,p.getColor());
				}else{
					if(p instanceof Alfil){
						casillas[y][x] = new Alfil(y ,x ,p.getColor());
					}else{
						if(p instanceof Reina){
							casillas[y][x] = new Reina(y ,x ,p.getColor());
						}else{
							casillas[y][x] = new Rey(y ,x ,p.getColor());
						}
					}
				}
			}
		}
		//Borrar pieza
		casillas[p.getPosY()][p.getPosX()] = null;
		
		
	}
	
	
}
