package com.live.todo.todo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.live.todo.todo.entites.Todo;

class TVATest {

	// 1 méthode un test = 1 assert par méthode
	@Test
	void TVA() {
		Todo t = new Todo();
		double tva = t.calculTVA(1);
		assertEquals(tva, 1.2);
	}
	@Test
	void TVANulle() {
		Todo t = new Todo();
		double tva = t.calculTVA(0);
		assertEquals(0, 0);
	}
}
