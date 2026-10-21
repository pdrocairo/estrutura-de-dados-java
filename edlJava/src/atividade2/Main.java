package atividade2;

public class Main {

	public static void main(String[] args) {
		BinarySearch arvore = new BinarySearch();

		arvore.insert(10);
		arvore.insert(5);
		arvore.insert(15);
		arvore.insert(2);
		arvore.insert(8);
		arvore.insert(22);

		System.out.println("Arvore inicial:");
		arvore.show();

		System.out.println("\nInserir 25:");
		arvore.insert(25);
		arvore.show();

		System.out.println("\nRemover 5:");
		arvore.remove(5);
		arvore.show();

		System.out.println("\nBuscar 8: " + arvore.search(8));
		System.out.println("Buscar 5: " + arvore.search(5));
	}
}