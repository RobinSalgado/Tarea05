package com.iteso.juegos;

public class Carta {

	private final int MAX_NUM_CARTAS = 40;

	public enum Figura {Uno,Dos,Tres,Cuatro,Cinco,Seis,Siete,Sota,Caballo,Rey}
	public enum Palo {Espadas, Bastos, Oros, Copas}

	private Figura figura;
	private Palo palo;

	/*Se tiene que inicializar el array de objetos, de lo contrario regresará la 
	 * JVM (" NullPointerException "). De tal suerte que se agrega 
	 * ( "new Carta[MAX_NUM_CARTAS]" ) para que NO apunte a null al principio*/
	private Carta mazoCartas[] = new Carta[MAX_NUM_CARTAS];

	public Carta() {
	
	}

	public Carta(Palo palo, Figura figura) {
		setPalo (palo);
		setFigura (figura);
	}
	
	public Carta[] CrearCartas() {

		Figura figuras[] = Figura.values(); //Obtengo el enum de Figuras en un array.
		Palo palos[] = Palo.values();//Obtengo el enum de Palos en un array.


		int contadorCartas = 0;
		for ( int i = 0; i < palos.length; i++) {
			for (int j = 0; j < figuras.length; j++) {
				mazoCartas[contadorCartas] = new Carta( palos[i] , figuras[j] );
				contadorCartas++;
			}
		}	

		return this.mazoCartas;
	}// Fin de CrearCartas.

	public void desplegar() {
		for (int i=0; i <MAX_NUM_CARTAS; i++)
			System.out.println(mazoCartas[i].getFigura()+" de "
					+mazoCartas[i].getPalo());
	}// Fin de desplegar

	public Palo getPalo () { return palo; }
	public Figura getFigura () { return figura; }
	public void setPalo ( Palo palo ) { this.palo = palo; }
	public void setFigura ( Figura figura ) { this.figura = figura; }




}
