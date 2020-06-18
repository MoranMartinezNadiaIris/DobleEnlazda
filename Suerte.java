/*
 * El número de la suerte
 * 
 * Realice un programa que permita al usuario agregar
 * numeros enteros a voluntad con la restriccion de que
 * al menos deben ser 5 numeros.
 * 
 * Imprima al derecho y al reves dichos números.
 * 
 * Luego con un generador de numeros aleatorios simulen
 * el lanzamiento de una moneda. (Sugiero usar nextBoolean)
 * 
 * Si la moneda cae cara eliminan un numero del principio
 * Si la moneda cae cruz eliminan un numero del final
 * 
 * Este proceso continua hasta que solo quede un numero
 * dicho numero sera deplegado como el numero de la suerte.
 * 
 * Corrida de escritorio
 * ///////////////////////////////////////////////////////
 * Bienvenido a este programa que calcula tu numero de la
 * Suerte.
 * 
 * Por favor dame un numero entero:
 * 1
 * Por favor dame un numero entero:
 * 45
 * Por favor dame un numero entero:
 * 63
 * Por favor dame un numero entero:
 * 68
 * Por favor dame un numero entero:
 * 128
 * Deseas agregar otro numero S / N
 * S
 * Por favor dame un numero entero:
 * 343
 * Deseas agregar otro numero S / N
 * N
 * Tus numeros:
 * 1 45 63 68 128 343
 * 343 128 68 63 45 1
 * Procesado ....
 * Se lanzo la moneda 5 Veces
 * Tu numero de la suerte es: 128
 */ 

import java.util.Random;
import java.util.Scanner;

public class Suerte {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String Respuesta = "",tmp="";
		int Valor = 0, Res = 0,num =0,tam=0;
		boolean cara = false, cruz = false;
		ListaDobleEnlazada L = new ListaDobleEnlazada();
		System.out.println("Bienvenido a este programa que calcula tu numero de la suerte");
		for (int i = 0; i < 5; i++) {
			System.out.println("Por favor dame un numero entero:");
			Valor = sc.nextInt();
			L.agregarAlInicio(new NodoGen<Integer>(Valor,1));
		}
		do {
			System.out.println("Deseas agregar otro numero? S/N");
			Respuesta = sc.next();			
			if (Respuesta.compareToIgnoreCase("S") == 0) {
				System.out.println("Por favor dame un numero entero:");
				Valor = sc.nextInt();
				L.agregarAlInicio(new NodoGen<Integer>(Valor,1));
			}		
		} while (Respuesta.compareToIgnoreCase("S") == 0);
			tam = L.getNoElementos()-1;
			System.out.println("Tus numeros");
			System.out.println(L.toStringReverse());
			System.out.println(L);
			System.out.println("Procesando...");
			System.out.println("\nSe lanzo la moneda "+tam+" veces");
			for (int i = 0; i < tam; i++) {
			num = r.nextInt(2)+1;			
			if (num == 1) {
				cara = true;
				cruz = false;
				L.eliminarAlInicio();
			}else {
				if (num == 2) {
					cara = false;
					cruz = true;
					L.eliminarAlFin();
				}
	   	    }
		}			
			System.out.println("Tu numero de la suerte es: "+L);
			}
}
