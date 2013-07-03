package maze.logic;

import java.io.Serializable;

/**  
 * Jogo.java - classe que cria um objecto do tipo Jogo
 * @author  grupo 2
 */ 
public class Jogo implements Serializable{


	private static final long serialVersionUID = 1L;

	private  Tabuleiro tabuleiro;
	private Heroi heroi;
	private Espada espada;
	private Celula saida;
	private Dragao[] dragoes;
	private  int[] n;

	public Jogo(char[][] tabul, Heroi heroi, Espada espada, Dragao[] dragoes, Celula saida){
		this.dragoes = dragoes;
		this.espada = espada;
		this.heroi = heroi;
		this.saida = saida;
		int[] d = new int[dragoes.length];
		for(int i = 0; i < dragoes.length; i++)
			d[i] = 0;
		this.n = d;
		Tabuleiro t = new Tabuleiro(15);
		t.setTabuleiro(tabul);
		this.tabuleiro = t;
	}

	public Jogo(int comp, int num_dragao) {
		this.tabuleiro = new Tabuleiro(comp);
		boolean bool = true;
		int x, y;

		// HEROI
		while (bool) {
			x = (int) (Math.random() * comp);
			y = (int) (Math.random() * comp);
			if (tabuleiro.getCelula(x, y) == ' ') {
				this.heroi = new Heroi(x, y);
				tabuleiro.setCelula(x, y, 'H');
				bool = false;
			}
		}

		// DRAGAO
		Dragao[] d = new Dragao[num_dragao];
		int[] num = new int[num_dragao];
		for(int i = 0; i < num_dragao; i++){
			bool = true;
			while (bool) {
				x = (int) (Math.random() * comp);
				y = (int) (Math.random() * comp);
				if (tabuleiro.getCelula(x, y) == ' ') {
					Dragao dragao = new Dragao(x, y);
					d[i] = dragao;
					tabuleiro.setCelula(x, y, 'D');
					bool = false;
				}
			}
			num[i] = 0;
		}
		this.dragoes = d;
		this.n = num;

		bool = true;
		while (bool) {
			x = (int) (Math.random() * comp);
			y = (int) (Math.random() * comp);
			if (tabuleiro.getCelula(x, y) == ' ') {
				this.espada = new Espada(x, y);
				tabuleiro.setCelula(x, y, 'E');
				bool = false;
			}
		}

		bool = true;
		while (bool) {
			y = (int) (Math.random() * (comp - 2)) + 1;
			if (tabuleiro.getCelula(comp - 2, y) == ' ') {
				tabuleiro.setCelula(comp - 1, y, 'S');
				this.saida = new Celula(comp - 1, y);
				bool = false;
			}
		}

	}

	public void setTabuleiro(char[][] celulas){
		tabuleiro.setTabuleiro(celulas);
	}

	public void setHeroi(Heroi heroi)
	{
		this.heroi = heroi;
	}

	public void setDragao(Dragao dragao, int n)
	{
		this.dragoes[n] = dragao;
	}

	public void setEspada(Espada espada){
		this.espada = espada;
	}

	public Heroi getHeroi(){
		return heroi;
	}

	public Espada getEspada(){
		return espada;
	}

	public Dragao getDragao(int n)
	{
		return dragoes[n];
	}

	public Celula getSaida(){
		return saida;
	}

	public void setSaida(int x, int y){
		saida.setX(x);
		saida.setY(y);
	}

	public void mostra_tabuleiro(){
		tabuleiro.mostra_tabuleiro();
	}

	public char[][] getMatrix(){
		return tabuleiro.getCelulas();
	}





	/**
	 * Move o Heroi e verifica se ganhou ou perdeu, assim como se a nova posição é valida.
	 * Atualiza o tabuleiro e verifica se o heroi apanhou a espada. 
	 * @param decisao, string que indica a direção para onde o heroi irá se mover(cima,baixo...)
	 * @return 1, No caso do heroi ganhar
	 * @return 0, No caso do heroi perder
	 * @return -1, No caso da string nao for valida
	 */
	public int move_heroi(String decisao){
		int x = heroi.getX();
		int y = heroi.getY();
		boolean nao_move = false;
		if(x == saida.getX() && y == saida.getY())
			tabuleiro.setCelula(x, y, 'S');
		else
			tabuleiro.setCelula(x, y, ' ');
		switch (decisao.charAt(0)){
		case 'c':
			if(tabuleiro.getCelula(x, y-1) != 'X')
				heroi.setY(y-1);
			else 
				nao_move = true;
			if(heroi.getX() == espada.getX() && heroi.getY() == espada.getY() && espada.getForma() != ' ' ){
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),'A');
				heroi.setForma('A');
				espada.setForma(' ');
			}
			else 
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),heroi.getForma());
			break;

		case 'b':
			if(tabuleiro.getCelula(x, y+1) != 'X')
				heroi.setY(y+1);
			else 
				nao_move = true;
			if(heroi.getX() == espada.getX() && heroi.getY() == espada.getY() && espada.getForma() != ' ' ){
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),'A');
				heroi.setForma('A');
				espada.setForma(' ');
			}
			else 
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),heroi.getForma());
			break;

		case 'e':
			if(tabuleiro.getCelula(x-1, y) != 'X')
				heroi.setX(x-1);
			else 
				nao_move = true;
			if(heroi.getX() == espada.getX() && heroi.getY() == espada.getY() && espada.getForma() != ' '  ){
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),'A');
				heroi.setForma('A');
				espada.setForma(' ');
			}
			else 
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),heroi.getForma());
			break;

		case 'd':
			if(tabuleiro.getCelula(x+1, y) != 'X'){
				int j;
				if(tabuleiro.getCelula(x+1, y) == 'S'){
					for(j = 0; j < dragoes.length; j++){
						if(dragoes[j].getForma() != ' ')
							break;
					}
					if(j>= dragoes.length)
						return 1;
					else
						nao_move = true;
				}else
					heroi.setX(x+1);
			}
			else 
				nao_move = true;
			if(heroi.getX() == espada.getX() && heroi.getY() == espada.getY() && espada.getForma() != ' '){
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),'A');
				heroi.setForma('A');
				espada.setForma(' ');
			}
			else 
				tabuleiro.setCelula(heroi.getX(),heroi.getY(),heroi.getForma());
			break;

		case 'm':
			tabuleiro.setCelula(heroi.getX(),heroi.getY(),heroi.getForma());
			break;	
		}

		if(nao_move)
			return -1;


		int i = -1;
		if(heroi.getX() == saida.getX() && heroi.getY() == saida.getY()){
			for(i = 0; i < dragoes.length; i++){
				if(dragoes[i].getForma() != ' ')
					break;
			}}

		if(i >= dragoes.length)
			return 1;

		return 0;
	}

	/**
	 * Simula o confronto entre um Heroi e um Dragão
	 * @return 1, Se o Heroi não morrer
	 * @return 0, Se o Heroi morrer 
	 */
	public int fight() {
		for (int i = 0; i < dragoes.length; i++) {
			Dragao dragao = dragoes[i];
			if (dragao.getForma() != ' ') {

				if(heroi.getX() == dragao.getX() && heroi.getY() - 1 == dragao.getY()
						|| heroi.getX() + 1 == dragao.getX()
						&& heroi.getY() == dragao.getY()
						|| heroi.getX() == dragao.getX()
						&& heroi.getY() + 1 == dragao.getY()
						|| heroi.getX() - 1 == dragao.getX()
						&& heroi.getY() == dragao.getY())
					if (heroi.getForma() == 'A') {
						tabuleiro.setCelula(dragao.getX(), dragao.getY(), ' ');
						dragao.setForma(' ');

					} else if (n[i] == 0)
						return 0;
			}

		}
		return 1;
	}


	/**
	 * Simula o movimento aleatório do Dragão
	 * @param sleep, indica se o dragão está acordado ou não, mediante a indicação de true ou false.
	 */
	public void move_dragao(boolean sleep) {
		for (int i = 0; i < dragoes.length; i++) {
			Dragao dragao = dragoes[i];

			// se o dragao estiver morto
			if (dragao.getForma() == ' ')
				continue;

			if (sleep) {

				// se o dragao tiver a dormir
				if (n[i] != 0) {
					n[i]--;
					continue;
				}
				int aleat = (int) (Math.random() * 7);
				if (aleat == 2) {
					n[i] = (int) (Math.random() * 4) + 1;
					tabuleiro.setCelula(dragao.getX(), dragao.getY(), 'd');
					continue;
				}
			}

			int x = dragao.getX();
			int y = dragao.getY();
			if (dragao.getForma() == 'F') {
				dragao.setForma('D');
				tabuleiro.setCelula(x, y, 'E');
			} else
				tabuleiro.setCelula(x, y, ' ');
			boolean ciclo = true;
			while (ciclo) {
				int aleat = (int) (Math.random() * 4);
				switch (aleat) {
				// cima
				case 0:
					if (tabuleiro.getCelula(x, y - 1) != 'X'
						&& tabuleiro.getCelula(x, y - 1) != 'S'
							&& tabuleiro.getCelula(x, y - 1) != 'B'
								&& tabuleiro.getCelula(x, y - 1) != 'b') {
						dragao.setY(y - 1);
						ciclo = false;
					}
					break;

					// baixo
				case 1:
					if (tabuleiro.getCelula(x, y + 1) != 'X'
						&& tabuleiro.getCelula(x, y + 1) != 'S'
							&& tabuleiro.getCelula(x, y + 1) != 'B'
								&& tabuleiro.getCelula(x, y + 1) != 'b') {
						dragao.setY(y + 1);
						ciclo = false;
					}

					break;

					// direita
				case 2:
					if (tabuleiro.getCelula(x + 1, y) != 'X'
						&& tabuleiro.getCelula(x + 1, y) != 'S'
							&& tabuleiro.getCelula(x + 1, y) != 'b'
								&& tabuleiro.getCelula(x + 1, y) != 'B') {
						dragao.setX(x + 1);
						ciclo = false;
					}

					break;

					// esquerda
				case 3:
					if (tabuleiro.getCelula(x - 1, y) != 'X'
						&& tabuleiro.getCelula(x - 1, y) != 'S'
							&& tabuleiro.getCelula(x - 1, y) != 'b'
								&& tabuleiro.getCelula(x - 1, y) != 'B') {
						dragao.setX(x - 1);
						ciclo = false;
					}

					break;


				}
			}
			if (dragao.getX() == espada.getX()
					&& dragao.getY() == espada.getY()
					&& espada.getForma() != ' ') {
				tabuleiro.setCelula(dragao.getX(), dragao.getY(), 'F');
				dragao.setForma('F');
			} else
				tabuleiro.setCelula(dragao.getX(), dragao.getY(),
						dragao.getForma());
		}

	}

	/**
	 * Se o Dragão e o Heroi se encontrarem na mesma posição...
	 * @return 1, Se o Heroi estiver armado e matar o Dragão
	 * @return 0, Se o Heroi morrer
	 */
	public int encontro() {
		for (int i = 0; i < dragoes.length; i++) {
			Dragao dragao = dragoes[i];
			if (dragao.getForma() != ' ') {
				if (heroi.getX() == dragao.getX()
						&& heroi.getY() == dragao.getY()) {
					if (heroi.getForma() == 'A') {
						tabuleiro.setCelula(dragao.getX(), dragao.getY(), 'A');
						dragao.setForma(' ');
						return 1;
					} else if (n[i] == 0) {
						tabuleiro.setCelula(dragao.getX(), dragao.getY(), 'N');
						return 0;
					}
				}

			}
		}
		return 1;
	}



};