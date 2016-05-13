import java.awt.Color;
import java.util.Scanner;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		Scanner lector = new Scanner (System.in);
		
		String turno = "B";
		int[][] movs = null;
		int x,y,contador = 0;
		
		//Crear tablero
		Tablero t = new Tablero();
		System.out.println("Empiezan blancas");
		do{
			//Mostrar tablero
			System.out.println(t+"\n");
			
			//Do-While para controlar que la posicion indicada no este vacia
			//que el jugador coja la pieza de su color
			//y que la pieza seleccionada tenga movimientos posibles
			do{
				//Pedir coordenadas
				System.out.println("Coordenadas de la pieza a mover (x,y):");
				System.out.print("- x: ");
				x=Utilidades.pedirCoordenadas();
				System.out.print("- y: ");
				y=Utilidades.pedirCoordenadas();
				
				if(t.casillas[y][x]==null){
					System.out.println(t);
					System.out.println("No has seleccionado ninguna pieza.");
				}else{
					if(!t.casillas[y][x].getColor().equals(turno)){
						System.out.println(t);
						System.out.println("La pieza no es tuya. Vuelve a insertar las coordenadas.");
					}else{
						//Guarda movimientos posibles
						movs = t.movsPosibles(t.casillas[y][x]);
						
						contador = Utilidades.contarMovimientos(movs);
						if(contador==0){
							System.out.println(t);
							System.out.println("Esta pieza no se puede mover");
						}else{
							System.out.println("Pieza seleccionada -> "+t.casillas[y][x]);
							//Muestra los movimientos posibles	
							System.out.println("Movimientos posibles");
							Utilidades.pintarMovimientos(movs, t.casillas);
						}
					}
				}
				//Vuelve a preguntar si la posicion elegida esta vacia, si la pieza no es tuya o si no se puede mover
			}while(t.casillas[y][x]==null || !t.casillas[y][x].getColor().equals(turno) || contador==0);
		
			
			int num;
			boolean puede;
			System.out.println("Numero de la lista \"Movimientos posibles\" donde quieres mover");
			do{
				num = Utilidades.pedirNum(movs);
				puede = Tablero.puedeMover(num, movs);
			}while(!puede);//Comprueba si el numero de la lista introducido se corresponde a las posiciones donde puede mover
			
			//Mover pieza o matar
			Tablero.moverMatar(movs[num][0],movs[num][1], t.casillas[y][x]);
			
			
			
			//Condicion para cambiar el turno si los 2 reyes estan vivos
			if(reyesVivos(t)){
				turno = cambioTurno(turno);
			}
		}while(reyesVivos(t));//Comprueba que los 2 reyes esten vivos
		
		mostrarMensajeGanador(turno);
		
	}
	
	public static void mostrarMensajeGanador(String turno){
		System.out.println("La partida ha acabado! Ha ganado "+turno);
	}
	
	public static String cambioTurno(String turno){
		if(turno.equals("B")){
			return "N";
		}
		else{
			return "B";
		}
	}
	
	public static boolean reyesVivos(Tablero t) {
		int numReyesVivos=0;
		
		for(int y=0; y<t.casillas.length; y++){
			for(int x=0; x<t.casillas[y].length; x++){
				if(t.casillas[y][x]!=null){
					if(t.casillas[y][x] instanceof Rey){
						numReyesVivos++;
					}
				}
			}
		}
		if(numReyesVivos==2){
			return true;
		}
		return false;
	}
	
} 