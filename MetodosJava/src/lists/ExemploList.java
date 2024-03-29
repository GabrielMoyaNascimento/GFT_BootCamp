package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {

	public static void main(String [] args) {
		//Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], fa�a:
		
		System.out.println("Crie uma lista e adicione as 7 notas:");
		List<Double> notas = new ArrayList<Double>();
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);

		System.out.println(notas.toString());
		
		System.out.println("Exiba a posi��o da nota 5.0: " + notas.indexOf(5d));
		
		System.out.println("Adicione a nota 8.0 na posi��o 4: ");
		notas.add(4, 8d);
		System.out.println(notas.toString());
	
		System.out.println("Substituir a nota 5.0 por 6.0: ");
		notas.set(notas.indexOf(5d), 6.0);
		System.out.println(notas.toString());
		
		System.out.println("Confira se a nota 5.0 est� na lista: " + notas.contains(5d));
		
		for(Double nota : notas) {
			System.out.println(nota);
		}
		
		System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
		
		System.out.println("Exiba a menor nota: " + Collections.min(notas));
		
		System.out.println("Exiba a maior nota: " + Collections.max(notas));
		
		System.out.println("Exiba a soma das notas: " );
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0d;
		
		while(iterator.hasNext()) {
			Double next = iterator.next();
			soma+=next;
		}
		System.out.println( soma );
		
		System.out.println("Exiba a m�dia das notas:" + soma/notas.size() );
		
		System.out.println("Remova a nota 0:" );
		notas.remove(0d);
		System.out.println(notas.toString());
		
		System.out.println("Remova as notas menores que 7 e exiba a lista:" );
		Iterator<Double> iterator1 = notas.iterator();
		while(iterator1.hasNext()) {
			Double next = iterator1.next();
			if(next < 7) iterator1.remove();
		}
		System.out.println(notas);
		
		System.out.println("Apague toda a lista:");
		notas.clear();
		System.out.println(notas);
		System.out.println("Confira se a lista est� vazia: " + notas.isEmpty());
		
	}
}
