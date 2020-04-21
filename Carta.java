package com.iteso.juegos;


public class Carta {

	private final int NUM_DE_PALOS = 4;	
	private final int NUM_DE_FIGURAS = 10;
	private final int MAX_NUM_CARTAS = 40;

	public enum Figura {UNO,DOS,TRES,CUATRO,CINCO,SEIS,SIETE,Sota,Caballo,Rey}
	public enum Palo {Espadas, Bastos, Oros, Copas}


	private Figura figura;
	private Palo palo;
	
	/*Se tiene que inicializar el array de objetos, de lo contrario regresará la 
	 * máquina virtual de java un (" NullPointerException"). De tal suerte que 
	 * se agrega (new Carta[MAX_NUM_CARTAS]) para que no apunte a null al principio*/
	private Carta mazoCartas[] = new Carta[MAX_NUM_CARTAS];
//	private Carta mazoCartas[] = new Carta[10];
	private Carta singleCarta;

	public Carta() {
		Figura figuras[] = Figura.values(); //Obtengo el enum de Figuras en un array.
		Palo palos[] = Palo.values();//Obtengo el enum de Palos en un array.
		mazoCartas[0] = new Carta( palos[0],figuras[0]);
	}

	public Carta(Palo palo, Figura figura) {
		setPalo (palo);
		setFigura (figura);
		
	}

	public void setFirstCard() {
		this.mazoCartas[0] = new Carta(Palo.Espadas,Figura.UNO);
	}
	Carta totalCartas[]=new Carta[MAX_NUM_CARTAS];
	public Carta[] CrearCartas() {

		Figura figuras[] = Figura.values(); //Obtengo el enum de Figuras en un array.
		Palo palos[] = Palo.values();//Obtengo el enum de Palos en un array.

		
		int contadorCartas = 0;
		for ( int i = 0; i < NUM_DE_PALOS; i++) {
			for (int j = 0; j < NUM_DE_FIGURAS;j++) {

//				addCartaToArr( new Carta( palos[i] , figuras[j] ));
				totalCartas[contadorCartas] = new Carta( palos[i] , figuras[j] );
//				singleCarta = new Carta( palos[0] , figuras[0] );
				contadorCartas++;
			}
		}	
		this.mazoCartas = totalCartas;
		return totalCartas;
//		return singleCarta;
	}

	public Palo getPalo( ) { return palo; }
	public Figura getFigura( ) { return figura; }
	public void setPalo(Palo palo) { this.palo = palo; }
	public void setFigura(Figura figura) { this.figura = figura; }

	public void desplegar() {
		for (int i=0; i <MAX_NUM_CARTAS; i++)
			System.out.println(mazoCartas[i]);
	}

	
	public String toString() {
		
		return "Carta:" + mazoCartas[0]; 
//		return palo + " de " + figura;
		
	}
}
