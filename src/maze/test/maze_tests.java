package maze.test;

import maze.logic.Dragao;
import maze.logic.Espada;
import maze.logic.Heroi;
import maze.logic.Jogo;
import junit.framework.TestCase;


/**  
 * maze_tests.java - classe responsável pelos testes unitários do nosso programa
 * @author  Grupo 2
 */ 
public class maze_tests extends TestCase {

	
	/**
	 * Testa o movimento do Heroi
	 */
	public void testMoveHeroi(){
		char[][] celulas = {{'X','X','X','X','X','X','X','X','X','X'},
				{'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','E','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','D','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	
		Heroi h = new Heroi(1, 1 );
		Espada esp = new Espada(1, 3);
		Dragao drag = new Dragao(1,8);
		Jogo j = new Jogo(10, 1);
		j.setTabuleiro(celulas);
		j.setHeroi(h);
		j.setDragao(drag, 0);
		j.setEspada(esp);
		j.move_heroi("baixo");
		assertEquals(1, j.getHeroi().getX());
		assertEquals(2, j.getHeroi().getY());
		j.move_heroi("cima");
		assertEquals(1, j.getHeroi().getX());
		assertEquals(1, j.getHeroi().getY());
		j.move_heroi("direita");
		assertEquals(2, j.getHeroi().getX());
		assertEquals(1, j.getHeroi().getY());
		j.move_heroi("esquerda");
		assertEquals(1, j.getHeroi().getX());
		assertEquals(1, j.getHeroi().getY());
		j.move_heroi("cima");
		assertEquals(1, j.getHeroi().getX());
		assertEquals(1, j.getHeroi().getY());
		j.move_heroi("baixo");
		j.move_heroi("baixo");
		assertEquals(1, j.getHeroi().getX());
		assertEquals(3, j.getHeroi().getY());
		assertEquals('A', j.getHeroi().getForma());

	}

	/**
	 * Testa o confronto do Dragão com o Heroi
	 */
	public void testFight() {
		char[][] celulas = {{'X','X','X','X','X','X','X','X','X','X'},
				{'X','H','E',' ',' ',' ',' ',' ',' ','X'},
				{'S',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','D','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	
		Heroi h = new Heroi(1, 1 );
		Espada esp = new Espada(2, 1);
		Dragao drag = new Dragao(1,3);
		Jogo j = new Jogo(10, 1);
		j.setTabuleiro(celulas);
		j.setHeroi(h);
		j.setDragao(drag, 0);
		j.setEspada(esp);
		j.setSaida(0, 2);

		//Testa o encontro do heroi  desarmado com o dragao
		j.move_heroi("baixo");
		assertEquals(0, j.fight());


		//Testa o encontro do heroi armado com o dragao
		h.setForma('A');
		j.setHeroi(h);
		assertEquals(1, j.fight());

		//Testar quando o dragao encontra a saida estando o dragao morto
		assertEquals(1, j.move_heroi("esquerda"));

		//Testar quando o dragao encontra a saida com o dragao vivo
		j.move_heroi("direita");
		drag.setForma('D');
		j.setDragao(drag, 0);
		assertEquals(0, j.move_heroi("esquerda"));

	}	

	/**
	 * Testa o movimento do Dragão
	 */
	public void testMoveDragao() {
		char[][] celulas = {{'X','X','X','X','X','X','X','X','X','X'},
				{'X','D','X',' ',' ',' ',' ',' ',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X','E','X','X',' ','X',' ','X',' ','X'},
				{'X','X','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	

		Heroi h = new Heroi(3, 1);
		Espada esp = new Espada(1, 3);
		Dragao drag = new Dragao(1,1);
		Jogo j = new Jogo(10, 1);
		j.setTabuleiro(celulas);
		j.setHeroi(h);
		j.setDragao(drag, 0);
		j.setEspada(esp);

		j.move_dragao(false);
		assertEquals(1, j.getDragao(0).getX());
		assertEquals(2, j.getDragao(0).getY());

		char[][] celulas_1 = {{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','X',' ',' ',' ',' ',' ',' ','X'},
				{'X','D','X','X',' ','X',' ','X',' ','X'},
				{'X','E','X','X',' ','X',' ','X',' ','X'},
				{'X','X','X','X',' ','X',' ','X',' ','X'},
				{'X',' ',' ',' ',' ',' ',' ','X',' ','S'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ','X',' ','X',' ','X'},
				{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};	
		j.setTabuleiro(celulas_1);
		j.move_dragao(false);
		assertEquals(1, j.getDragao(0).getX());
		assertEquals(3, j.getDragao(0).getY());
		assertEquals('F', j.getDragao(0).getForma());

		j.move_dragao(false);
		assertEquals(1, j.getDragao(0).getX());
		assertEquals(2, j.getDragao(0).getY());
		assertEquals('D', j.getDragao(0).getForma());

	}
};