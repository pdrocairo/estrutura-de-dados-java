package main;
import queues.Queue;
import queues.QueueDoubleLinkedList;

import stacks.Stack;
import stacks.StackLinkedList;
import java.util.*;



public class Main {

	static int testsOk = 0;
	static int testsFail = 0;

	public static void main(String[] args) {
		testStackArray();
		testStackLinkedList();
		testQueueArray();
		testQueueLinkedList();

		System.out.println("\n===================================");
		System.out.println("Total: " + (testsOk + testsFail)
				+ " | OK: " + testsOk + " | FALHOU: " + testsFail);
		System.out.println("===================================");
	}

	// ---------- utilitarios de asserção ----------

	static void check(String descricao, boolean condicao) {
		if (condicao) {
			testsOk++;
			System.out.println("[OK]    " + descricao);
		} else {
			testsFail++;
			System.out.println("[FALHOU] " + descricao);
		}
	}

	static void checkThrows(String descricao, Runnable acao) {
		try {
			acao.run();
			testsFail++;
			System.out.println("[FALHOU] " + descricao + " (esperava exceção, nenhuma foi lançada)");
		} catch (RuntimeException e) {
			testsOk++;
			System.out.println("[OK]    " + descricao + " (" + e.getClass().getSimpleName() + ": " + e.getMessage() + ")");
		}
	}

	// ---------- testes da Stack (array) ----------

	static void testStackArray() {
		System.out.println("\n--- Stack (array) ---");
		Stack pilha = new Stack(2, 0);

		check("pilha nova deve estar vazia", pilha.isEmpty());
		check("tamanho inicial deve ser 0", pilha.size_() == 0);

		pilha.push(10);
		pilha.push(20);
		check("após 2 push, tamanho deve ser 2", pilha.size_() == 2);
		check("topo deve ser 20", pilha.top_() == 20);
		check("pilha não deve estar vazia", !pilha.isEmpty());

		// força o crescimento (capacidade inicial era 2)
		pilha.push(30);
		check("após crescer, tamanho deve ser 3", pilha.size_() == 3);
		check("topo após crescimento deve ser 30", pilha.top_() == 30);
		check("contains(10) deve ser true", pilha.contains(10));
		check("contains(999) deve ser false", !pilha.contains(999));

		int removido = pilha.pop();
		check("pop deve remover 30 (LIFO)", removido == 30);
		check("tamanho após pop deve ser 2", pilha.size_() == 2);
		check("novo topo deve ser 20", pilha.top_() == 20);

		pilha.pop();
		pilha.pop();
		check("pilha deve ficar vazia após remover tudo", pilha.isEmpty());
		checkThrows("pop em pilha vazia deve lançar exceção", () -> pilha.pop());
	}

	// ---------- testes da StackLinkedList ----------

	static void testStackLinkedList() {
		System.out.println("\n--- StackLinkedList ---");
		StackLinkedList pilha = new StackLinkedList();

		check("pilha nova deve estar vazia", pilha.isEmpty());
		check("tamanho inicial deve ser 0", pilha.size_() == 0);
		checkThrows("top_ em pilha vazia deve lançar exceção", () -> pilha.top_());
		checkThrows("pop em pilha vazia deve lançar exceção", () -> pilha.pop());

		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		check("após 3 push, tamanho deve ser 3", pilha.size_() == 3);
		check("topo deve ser 3", pilha.top_() == 3);

		check("pop deve remover 3 (LIFO)", pilha.pop() == 3);
		check("pop deve remover 2 (LIFO)", pilha.pop() == 2);
		check("tamanho após 2 pops deve ser 1", pilha.size_() == 1);
		check("topo restante deve ser 1", pilha.top_() == 1);

		pilha.pop();
		check("pilha deve ficar vazia após remover tudo", pilha.isEmpty());
	}

	// ---------- testes da Queue (array) ----------

	static void testQueueArray() {
		System.out.println("\n--- Queue (array) ---");
		Queue fila = new Queue(2, 0);

		check("fila nova deve estar vazia", fila.isEmpty());
		check("tamanho inicial deve ser 0", fila.size_() == 0);

		fila.enqueue(10);
		fila.enqueue(20);
		check("após 2 enqueue, tamanho deve ser 2", fila.size_() == 2);
		check("front deve ser 10", fila.front() == 10);
		check("back deve ser 20", fila.back() == 20);

		// força o crescimento (capacidade inicial era 2)
		// BUG conhecido: o campo "length" nunca é inicializado no construtor
		// (o construtor só usa o parâmetro local "length", faltando "this.length = length;"),
		// então ele fica 0 e o array novo é criado com tamanho 0.
		try {
			fila.enqueue(30);
			check("após crescer, tamanho deve ser 3", fila.size_() == 3);
			check("back após crescimento deve ser 30", fila.back() == 30);
		} catch (ArrayIndexOutOfBoundsException e) {
			testsFail++;
			System.out.println("[FALHOU] após crescer, enqueue não deveria lançar exceção "
					+ "(BUG: campo 'length' nunca é inicializado no construtor -> " + e.getMessage() + ")");
		}

		// recria a fila (com capacidade suficiente) para continuar testando o restante do comportamento
		final Queue fila2 = new Queue(5, 0);
		fila2.enqueue(10);
		fila2.enqueue(20);
		fila2.enqueue(30);

		int removido = fila2.dequeue();
		check("dequeue deve remover 10 (FIFO)", removido == 10);
		check("tamanho após dequeue deve ser 2", fila2.size_() == 2);
		check("novo front deve ser 20", fila2.front() == 20);

		fila2.dequeue();
		fila2.dequeue();
		check("fila deve ficar vazia após remover tudo", fila2.isEmpty());
		checkThrows("dequeue em fila vazia deve lançar exceção", () -> fila2.dequeue());
	}

	// ---------- testes da QueueLinkedList ----------

	static void testQueueLinkedList() {
		System.out.println("\n--- QueueLinkedList ---");
		QueueDoubleLinkedList fila = new QueueDoubleLinkedList();

		check("fila nova deve estar vazia", fila.isEmpty());
		check("tamanho inicial deve ser 0", fila.size_() == 0);
		checkThrows("front em fila vazia deve lançar exceção", () -> fila.front());
		checkThrows("dequeue em fila vazia deve lançar exceção", () -> fila.dequeue());

		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		check("após 3 enqueue, tamanho deve ser 3", fila.size_() == 3);
		check("front deve ser 1", fila.front() == 1);
		check("back deve ser 3", fila.back() == 3);

		check("dequeue deve remover 1 (FIFO)", fila.dequeue() == 1);
		check("dequeue deve remover 2 (FIFO)", fila.dequeue() == 2);
		check("tamanho após 2 dequeues deve ser 1", fila.size_() == 1);
		check("front restante deve ser 3", fila.front() == 3);
		check("back restante deve ser 3", fila.back() == 3);

		fila.dequeue();
		check("fila deve ficar vazia após remover tudo", fila.isEmpty());
	}

}