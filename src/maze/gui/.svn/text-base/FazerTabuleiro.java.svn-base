package maze.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.*;



/**  
 * FazerTabuleiro.java - classe responsável pela opcção de o utilizador desenhar manualmente o seu proprio tabuleiro
 * @author  grupo 2
 */ 
public class FazerTabuleiro {

	/**
	 * Membros dados que represetam botoes,frames,etc
	 */
	private JFrame frame;
	private JPanel panel_1;
	private JButton tabuleiro_button;
	private JButton dragao_button;
	private JButton heroi_button;
	private JButton espada_button;
	private JButton saida_button;
	private JButton ok_button;
	private JButton cancel_button;
	private char forma = ' ';
	private Heroi heroi;
	private Vector<Dragao> dragoes = new Vector<Dragao>();
	private Espada espada;
	private Celula saida;
	private char[][] tabuleiro;
	private boolean heroi_criado = false;
	private boolean dragao_criado = false;
	private boolean espada_criado = false;
	private boolean saida_criado = false;
	private boolean tabuleiro_criado = false;
	private int nq = 15;
	private Jogo j;
	private ContactManager parent;



	/**
	 * Método que cria todos os botões que irão estar disponiveis na criação do nosso tabuleiro 
	 */
	public void cria_button(){
		tabuleiro_button = new JButton("Tabuleiro");
		dragao_button = new JButton("Dragão");
		heroi_button = new JButton("Heroi");
		espada_button = new JButton("Espada");
		saida_button = new JButton("Saida");
		ok_button = new JButton("OK");
		cancel_button = new JButton("Cancelar");
		tabuleiro_button.setFocusable(false);
		dragao_button.setFocusable(false);
		heroi_button.setFocusable(false);
		espada_button.setFocusable(false);
		saida_button.setFocusable(false);
		ok_button.setFocusable(false);
		cancel_button.setFocusable(false);
		tabuleiro_button.addActionListener(new TabuleiroListener());
		dragao_button.addActionListener(new DragaoListener());
		heroi_button.addActionListener(new HeroiListener());
		espada_button.addActionListener(new EspadaListener());
		saida_button.addActionListener(new SaidaListener());
		ok_button.addActionListener(new OKListener());
		cancel_button.addActionListener(new CancelListener());
	}


	/**
	 * Classe que conforme o "controlo" do rato vai ser responsável por criar o tabuleiro
	 * @author grupo 2
	 */
	public class SimpleGraphicsPanel extends JPanel implements MouseListener{
		private static final long serialVersionUID = 1L;
		private int largura = 40;
		private int x_ini = 0;
		private int y_ini = 0;

		public SimpleGraphicsPanel(JFrame g){
			g.addMouseListener(this);

		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			setBackground(Color.GRAY);

			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[0].length; j++) {
					if (tabuleiro[i][j] == 'X') {

						g.drawImage(ContactManager.parede, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (tabuleiro[i][j] == ' ') {
						g.setColor(Color.WHITE);
						g.fillRect(x_ini + (largura * j),
								y_ini + (largura * i), largura, largura);
					}
					if (tabuleiro[i][j] == 'H') {
						g.drawImage(ContactManager.heroi, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (tabuleiro[i][j] == 'D') {

						g.drawImage(ContactManager.dragao, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (tabuleiro[i][j] == 'E') {
						g.drawImage(ContactManager.espada, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (tabuleiro[i][j] == 'S') {
						g.setColor(Color.YELLOW);
						g.fillRect(x_ini + (largura * j),
								y_ini + (largura * i), largura, largura);

					}
					if (tabuleiro[i][j] == 'A') {
						g.drawImage(ContactManager.heroi_armado, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (tabuleiro[i][j] == 'd') {
						g.drawImage(ContactManager.dragao_adormecido, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}

				}
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = (e.getX()-frame.getX()-6) / largura;
			int y = (e.getY() - panel_1.getHeight()-30) / largura;
			if(forma == ' ' && x < nq-1 && y < nq-1 && x > 0 && y > 0){
				tabuleiro_criado = true;
				tabuleiro[y][x] = forma;
				repaint();
			}else if(forma == 'H' && x < nq-1 && y < nq-1 && x > 0 && y > 0 && !heroi_criado){
				heroi_criado = true;
				tabuleiro[y][x] = forma;
				heroi = new Heroi(x, y);
				repaint();
			}else if(forma == 'E' && x < nq-1 && y < nq-1 && x > 0 && y > 0 && !espada_criado){
				espada_criado = true;
				tabuleiro[y][x] = forma;
				espada = new Espada(x, y);
				repaint();
			}else if(forma == 'D' && x < nq-1 && y < nq-1 && x > 0 && y > 0){
				dragao_criado = true;
				tabuleiro[y][x] = forma;
				dragoes.addElement(new Dragao(x, y));
				repaint();
			}else if(forma == 'S' && y != 0 && y != nq && x ==nq-1 && !saida_criado){
				saida_criado = true;
				tabuleiro[y][x] = forma;
				saida = new Celula(x, y);
				repaint();
			}	

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class TabuleiroListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			forma = ' ';
		}
	}

	private class DragaoListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			forma = 'D';
		}
	}

	private class HeroiListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			forma = 'H';
		}
	}

	private class EspadaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			forma = 'E';
		}
	}

	private class SaidaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			forma = 'S';
		}
	}

	private class OKListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(tabuleiro_criado && heroi_criado && dragao_criado
					&& espada_criado && saida_criado){
				Dragao[] d = new Dragao[dragoes.size()];
				for(int i = 0; i < dragoes.size(); i++)
					d[i] = dragoes.elementAt(i);
				ContactManager.j = new Jogo(tabuleiro, heroi, espada, d, saida);
				frame.setVisible(false);
				parent.actualizar();

			}
			else 
			{
				JOptionPane.showMessageDialog(frame,
				"Tabuleiro não completo!!");
			}
		}
	}

	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
		}
	}

	public Jogo getTabuleiro()
	{
		return j;
	}




	/**
	 * Construtor da classe FazerTabuleiro que cria uma nova janela onde iremos poder criar o nosso labirinto
	 * @param parent
	 */
	public FazerTabuleiro(ContactManager parent){
		this.parent = parent;
		frame = new JFrame("Cria o teu próprio tabuleiro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		frame.setFocusable(false);
		panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		cria_button();
		panel_1.add(tabuleiro_button);
		panel_1.add(dragao_button);
		panel_1.add(heroi_button);
		panel_1.add(espada_button);
		panel_1.add(saida_button);
		panel_1.add(ok_button);
		panel_1.add(cancel_button);
		c.add(panel_1);

		char [][] t = new char[15][15];

		for(int i = 0; i < 15;i++)
			for(int j = 0; j < 15 ; j++)
				t[i][j] = 'X';

		this.tabuleiro = t;

		c.add(new SimpleGraphicsPanel(frame));
		frame.setPreferredSize(new Dimension(40 * 15 + 15,40 * 15 + 65 ));

		frame.pack();
		frame.setVisible(true);


	}

}
