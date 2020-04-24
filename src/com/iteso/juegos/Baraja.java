package com.iteso.juegos;

import java.util.*;

public class Baraja {

	public Carta cartas[]; //Agregación de la clase Carta.
	public Carta cartasRepartir[]; //Utilizado x el método repartirCartas().
	public Carta cartasTmp2[];//Utilizado x el método []repartirCartas(). 
	public Carta cartasDspnb[];//Utilizado x el método []mazo().

	public Baraja () {
		cartas = new Carta().CrearCartas();
		cartasRepartir = new Carta().CrearCartas();

	}//Fin de Constructor.

	public void desplegar() {
		for (int i=0; i <cartas.length; i++)
			System.out.println(cartas[i].getFigura()+" de "
					+cartas[i].getPalo());
	}// Fin de desplegar.


	public void barajar() {
		ArrayList<Integer>  listNum = new ArrayList<>(cartas.length);

		//Se llena con números [ 0 - 40 ].
		for(int i = 0; i < cartas.length; i ++) {
			listNum.add(i);
		}
		//Se revuelven los 40 números.
		Collections.shuffle(listNum);

		//Convierte un Objecto a arreglo.
		Object[] array = listNum.toArray();
		int arrNumAleat[] = new int[cartas.length];
		int indxArrNum = 0;
		//Itera y convierte al tipo de dato deseado "Integer".
		for(Object o : array) {
			Integer s = (Integer) o;
			arrNumAleat[indxArrNum] = s;
			//           System.out.println("posición: " + 
			//            					indxArrNum +" = "+ 
			//            					arrNumAleat[indxArrNum]);
			indxArrNum++;
		}

		// Se asigna las nuevas posiciones. 
		for ( int i = 0; i < cartas.length; i++) {
			cartas[i] = cartas[arrNumAleat[i]];
		}
	}// Fin de Barjar.

	//Cuenta las veces que se llama al método repartirCarta();
	int contRepartir = 0;

	public Carta repartirCarta() {

		//Si las veces que se ha repartido carta < al número de cartas.
		if( contRepartir < cartas.length ) {
			//Si se está repartiendo la primer carta.
			if (contRepartir == 0) {
				cartasRepartir[0] = cartas[0];
				cartas[0] = null;
				System.out.println(contRepartir);
				contRepartir++;	
				return cartasRepartir[0];	
			}

			else {
				//Se guarda la carta repartida en un arr temp.  
				cartasRepartir[contRepartir] = cartas[contRepartir];
				//Se elimina la carta repartida del mazo.
				cartas[contRepartir] = null;
				System.out.println(contRepartir);
				contRepartir++;
				//Condicional para evitar excepción en límite del arreglo.
				if (contRepartir == cartas.length)  
					return cartasRepartir[contRepartir - 1];
				else 
					return cartasRepartir[contRepartir];
			} //Fin else.
		}//Fin if contRepartir.

		/*Imprimir las cartas repartidas en orden*/ 
		//		for(Carta i: cartasTmp) {
		//			System.out.println(i.getFigura()+" de "+ i.getPalo());
		//		}

		System.out.println("¡NO HAY MÁS CARTAS!.");
		return null; // no se reparte ninguna carta.
	}//Fin repartirCarta.

	int accN = 0;
	public Carta[] repartirCarta(int n) {
		cartasTmp2 = new Carta [n];
		int j = 0;
		if( accN < cartas.length) {
			for ( int i = accN; i < (accN + n); i++) {
				cartasTmp2[j] = cartas[i];
				cartas[i] = null;
				j++;
			}
			accN += n;
		}else {
			System.out.println("¡NO HAY MÁS CARTAS!.");
			return null;
		}
		return cartasTmp2;
	}//Fin de repartirCarta[].

	public Carta[] mazo() {
		int contCartDspnb = 0;
		int idexCartasDsonbl = 0;
		for( Carta i: cartas) {
			if (i != null) {
				contCartDspnb++;
				System.out.println(i.getFigura()+" de "+i.getPalo());
			}
		}

		cartasDspnb = new Carta[contCartDspnb];

		for( int i = 0; i < cartas.length; i++) {
			if (cartas[i] != null) {
				cartasDspnb[idexCartasDsonbl] = cartas[i];
				idexCartasDsonbl++;
			}
		}

		System.out.println("\n\n");

		/*//Muestra las cartas disponibles a retornar
		 * for ( int i = 0; i < contCartDspnb; i++) { System.out.println(
		 * cartasDspnbl[i].getPalo()+" de " +cartasDspnbl[i].getFigura() ); }
		 */

		return cartasDspnb;
	}

	public int cartasDisponibles() {
		int contCartDspnb = 0;
		for( Carta i: cartas) {
			if (i != null) contCartDspnb++;
		}
		
		return contCartDspnb;
	}
}
