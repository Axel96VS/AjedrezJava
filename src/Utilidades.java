import java.util.Scanner;

public abstract class Utilidades {
	
	public static void pintarMovimientos(int[][] movs, Pieza[][] casillas){
		for(int i=0; i<movs.length; i++){
			if(movs[i][0] != -1 && movs[i][1] != -1){
				System.out.println(i+": ("+movs[i][0]+","+movs[i][1]+") "+comprobarSiMata(movs, movs[i][0], movs[i][1], casillas));
			}
		}
	}
	
	public static String comprobarSiMata(int[][] movs, int x, int y, Pieza[][] casillas){
		if(casillas[y][x] != null){
			return "Puedes matar";
		}
		return "";
	}
	
	public static int contarMovimientos(int[][] movs){
		int contador=0;
		for(int i=0; i<movs.length; i++){
			if(movs[i][0] != -1 && movs[i][1] != -1){
				contador++;
			}
		}
		return contador;
	}
	
	public static int pedirCoordenadas(){
		int c = -1;
		do{
			Scanner lector = new Scanner(System.in);
			
			if(lector.hasNextInt()){
				c=lector.nextInt();
				if(c<Tablero.minColumnas || c>Tablero.maxColumnas){
					mostrarErrorFueraRango();
				}
			}
			else{
				mostrarErrorEntero();
			}
			
		}while(c<Tablero.minColumnas || c>Tablero.maxColumnas);
		return c;
	}
	public static void mostrarErrorEntero(){
		System.out.println("No es un entero");
	}
	
	public static void mostrarErrorFueraRango(){
		System.out.println("Fuera de rango");
	}
	public static void mostrarErrorNumIncorrecto(){
		System.out.println("Numero incorrecto");
	}
	
	public static int pedirNum(int[][] movs){
		Scanner lector = new Scanner(System.in);
		int n = -1;
		do{
			lector = new Scanner(System.in);
			if(lector.hasNextInt()){
				n=lector.nextInt();
				if(n>movs.length){
					mostrarErrorNumIncorrecto();
				}
			}
			else{
				mostrarErrorEntero();
			}
			
		}while( n<0 || n>movs.length);
		return n;
	}
	
}
