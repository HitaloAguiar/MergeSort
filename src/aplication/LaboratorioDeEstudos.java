package aplication;

import unitins.ArrayTins;

public class LaboratorioDeEstudos {
	
	public static void main(String[] args) {
		
		ArrayTins<Integer> lista = new ArrayTins<>();
		
		lista.add(4);
		lista.add(9);
		lista.add(2);
		lista.add(11);
		lista.add(27);
		lista.add(13);
		lista.add(17);
		lista.add(8);
		lista.add(30);
		lista.add(15);
		
		System.out.println(lista);
		
		System.out.println(mergeSort(lista));
	}

	public static ArrayTins<Integer> mergeSort(ArrayTins<Integer> lista) {
		
		if (lista.isEmpty() || lista == null)
			throw new NullPointerException("lista vazia");
		
		if (lista.size() == 1)
			return lista;
		
		int indice = (lista.size()/2);
		
		ArrayTins<Integer> lista1 = new ArrayTins<>();
		
		ArrayTins<Integer> lista2 = new ArrayTins<>();
		
		for (int i = 0; i < indice; i++) {
			
			lista1.add(lista.get(i));
		}
		
		for (int i = indice; i < lista.size(); i++) {
			
			lista2.add(lista.get(i));
		}
		
		lista1 = mergeSort(lista1);
		
		lista2 = mergeSort(lista2);
		
		return merge(lista1, lista2);
	}
	
	public static ArrayTins<Integer> merge(ArrayTins<Integer> lista1, ArrayTins<Integer> lista2) {
		
		ArrayTins<Integer> listaAux = new ArrayTins<>();
		
		while (!lista1.isEmpty() && !lista2.isEmpty()) {
			
			if (lista1.getFirst() < lista2.getFirst())
				listaAux.add(lista1.removeFirst());
			
			else
				listaAux.add(lista2.removeFirst());
		}
		
		while (!(lista1.isEmpty())) {
			
			listaAux.add(lista1.removeFirst());
		}
		
		while (!(lista2.isEmpty())) {
			
			listaAux.add(lista2.removeFirst());
		}
		
		return listaAux;
	}
}
