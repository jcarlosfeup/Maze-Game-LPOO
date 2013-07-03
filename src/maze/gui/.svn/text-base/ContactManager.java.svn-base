package maze.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import maze.logic.Jogo;





/**  
 * ContactManager.java - classe responsável pela interface gráfica do nosso jogo
 * @author  Grupo 2
 */ 
public class ContactManager {


	/**
	 * Membros-dado que representam paineis,frames,botões,imagens,etc
	 */
	private JFrame frame;
	private JButton new_game_button;
	private JButton exit_button;
	private JButton option_button;
	private JButton tabuleiro_button;
	private JButton ok_button;
	private JButton cancel_button;
	private JButton save_button;
	private JButton load_button;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JFrame frame_2;
	private JLabel n_dragoes;
	private JLabel n_quad;
	private JLabel teclas;
	private SpinnerNumberModel tex_n_dragoes;
	private SpinnerNumberModel tex_n_quad;	
	private JComboBox opcoes_jogo;
	private JComboBox opcoes_teclas;

	static BufferedImage parede;
	static BufferedImage dragao;
	static BufferedImage heroi;
	static BufferedImage dragao_adormecido;
	static BufferedImage espada;
	static BufferedImage heroi_armado;
	private BufferedImage dragao_espada;

	private int largura = 40;

	static int n_quadrados = new Integer(20);
	static int n_drag = new Integer(1);
	private int ind_tipo_jogo = new Integer(1);
	private int ind_tec = new Integer(0);
	private Jogo j1 = new Jogo(n_quadrados, n_drag); 
	static Jogo j= null;


	/**
	 * Classe que é responsável pelo controlo do jogo mediante teclas
	 */
	public class SimpleGraphicsPanel extends JPanel implements KeyListener {
		private static final long serialVersionUID = 1L;
		private int x_ini = 0;
		private int y_ini = 0;



		public SimpleGraphicsPanel(JFrame parent) {
			j1 = null;
			j1 = new Jogo(n_quadrados, n_drag);
			parent.addKeyListener(this);
			parent.pack();
			this.setPreferredSize(parent.getSize());
			parent.requestFocus();


		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			char[][] celulas = j1.getMatrix();

			// Define a cor de fundo
			setBackground(Color.GRAY);
			removeAll();

			for (int i = 0; i < celulas.length; i++) {
				for (int j = 0; j < celulas[0].length; j++) {
					if (celulas[i][j] == 'X') {

						g.drawImage(parede, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == ' ') {
						g.setColor(Color.WHITE);
						g.fillRect(x_ini + (largura * j),
								y_ini + (largura * i), largura, largura);
					}
					if (celulas[i][j] == 'H') {
						g.drawImage(heroi, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == 'D') {

						g.drawImage(dragao, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == 'E') {
						g.drawImage(espada, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == 'S') {
						g.setColor(Color.YELLOW);
						g.fillRect(x_ini + (largura * j),
								y_ini + (largura * i), largura, largura);

					}
					if (celulas[i][j] == 'A') {
						g.drawImage(heroi_armado, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == 'd') {
						g.drawImage(dragao_adormecido, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}
					if (celulas[i][j] == 'F') {
						g.drawImage(dragao_espada, x_ini + (largura * j), y_ini + (largura * i), largura, largura, null);
					}

				}
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			int n=-1;
			boolean perdeu = false;
			if(ind_tec == 0){
				if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
					n = j1.move_heroi("baixo");

				}
				if (arg0.getKeyCode() == KeyEvent.VK_UP) {
					n = j1.move_heroi("cima");
				}
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
					n = j1.move_heroi("esquerda");
				}
				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					n = j1.move_heroi("direita");
				}}
			else
			{
				if (arg0.getKeyCode() == KeyEvent.VK_Z) {
					n = j1.move_heroi("baixo");

				}
				if (arg0.getKeyCode() == KeyEvent.VK_W) {
					n = j1.move_heroi("cima");
				}
				if (arg0.getKeyCode() == KeyEvent.VK_A) {
					n = j1.move_heroi("esquerda");
				}
				if (arg0.getKeyCode() == KeyEvent.VK_D) {
					n = j1.move_heroi("direita");
				}
			} 
			if(n != -1){
				if(n == 1){
					JOptionPane.showMessageDialog(frame,
					"Parabens, ganhou o jogo!!");
					frame.setVisible(false);
					System.exit(1);
				}
				if(ind_tipo_jogo == 1)
					j1.move_dragao(false);
				if(ind_tipo_jogo == 2)
					j1.move_dragao(true);
				n = j1.encontro();
				if (n == 0){
					perdeu = true;
				}
				n = j1.fight();
				if(n == 0){
					perdeu = true;
				}

			}


			repaint();

			if(perdeu){
				JOptionPane.showMessageDialog(frame,
				"Perdeu o jogo!!");
				frame.setVisible(false);
				System.exit(2);
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Acção que provoca a saída do jogo
	 */ 
	public class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			int n = JOptionPane.showConfirmDialog(frame, "Tem a certeza que deseja sair?");
			if (n == JOptionPane.NO_OPTION || n == JOptionPane.CLOSED_OPTION || n == JOptionPane.CANCEL_OPTION)
				frame.setVisible(true);
			else{
				frame.setVisible(false);
				System.exit(0);	
			}

		}
	}

	/**
	 * Acção que permite começar a jogar
	 */ 
	private class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			j1 = null;
			j1 = new Jogo(n_quadrados, n_drag);
			if(panel_1.getWidth() < largura * n_quadrados)
				frame.setSize(new Dimension(largura * n_quadrados + 15,largura * n_quadrados + 65 ));
			else
				frame.setSize(new Dimension(panel_1.getWidth() + 15,largura * n_quadrados + 65 ));
			frame.repaint();
		}
	}


	/**
	 * Acção que grava um jogo
	 */
	private class LoadListener implements ActionListener
	{


		public void actionPerformed(ActionEvent paramActionEvent)
		{

			ObjectInputStream in = null;
			try
			{
				in = new ObjectInputStream(new FileInputStream("file.dat"));
				j1 = (Jogo) in.readObject();
				frame.repaint();
				frame.setVisible(true);
				JOptionPane.showMessageDialog(frame,
				"Jogo carregado com sucesso!!");

			} catch (IOException localIOException)
			{
				System.out.println("Problem making an input stream.");
				System.out.println(localIOException.getMessage());
				JOptionPane.showMessageDialog(frame,
				"Nao existe nenhum jogo gravado!!");

			} catch (ClassNotFoundException localClassNotFoundException){
			}
		}
	}


	/**
	 * Acçao que carrega um jogo
	 */
	private class SaveListener  implements ActionListener
	{



		public void actionPerformed(ActionEvent paramActionEvent)
		{
			ObjectOutputStream out = null;

			try
			{
				out = new ObjectOutputStream(new FileOutputStream("file.dat"));
				out.writeObject(j1);
				JOptionPane.showMessageDialog(frame,
				"Jogo gravado com sucesso!!");

			} catch (IOException localIOException)
			{
				System.out.println("Problem making or writing to an output stream.");
				System.out.println(localIOException.getMessage());
				JOptionPane.showMessageDialog(frame,
				"Falha a gravar!!");
			}
		}
	}


	/**
	 * 
	 * Classe que representa o painel de opções do nosso Jogo.
	 * Onde se pode alterar o numero de quadrados,dragões,definir o tipo de movimento do Dragao e escolher o tipo de teclas.
	 *
	 */
	private class OptionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame_2 = new JFrame("Opções do jogo");
			frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = frame_2.getContentPane();
			c.setLayout(new GridLayout(4, 1));

			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(3, 2));
			tex_n_quad = new SpinnerNumberModel(n_quadrados, 10, null, 1);
			JSpinner spinner1 = new JSpinner(tex_n_quad);
			n_quad = new JLabel("Numero de quadrados:  ");
			tex_n_dragoes = new SpinnerNumberModel(n_drag, 1, null, 1);
			JSpinner spinner2 = new JSpinner(tex_n_dragoes);
			n_dragoes = new JLabel("Numero de dragões:");
			panel_3.add(n_quad);
			panel_3.add(spinner1);
			panel_3.add(n_dragoes);
			panel_3.add(spinner2);
			c.add(panel_3);


			panel_4 = new JPanel();
			panel_4.setLayout(new GridLayout(3, 1));
			JLabel tipo_jogo = new JLabel("Escolha o tipo de jogo:");
			String[] opcoes = {"Dragao parado", "Dragao com movimeno aleatorio", "Dragão com movimentação aleatória intercalada com dormir"};
			opcoes_jogo = new JComboBox(opcoes);
			opcoes_jogo.setSelectedIndex(1);
			panel_4.add(tipo_jogo);
			panel_4.add(opcoes_jogo);
			c.add(panel_4);

			panel_5 = new JPanel();
			panel_5.setLayout(new GridLayout(3, 1));
			teclas = new JLabel("Escolha teclas: ");
			String[] opcao_teclas = {"Cursores", "Teclas (A, W, D, Z)"};
			opcoes_teclas = new JComboBox(opcao_teclas);
			opcoes_teclas.setSelectedIndex(0);
			panel_5.add(teclas);
			panel_5.add(opcoes_teclas);
			c.add(panel_5);

			panel_6 = new JPanel();
			panel_6.setLayout(new FlowLayout(FlowLayout.CENTER));
			ok_button = new JButton("OK");
			cancel_button = new JButton("Cancel");
			ok_button.setFocusable(false);
			cancel_button.setFocusable(false);
			ok_button.addActionListener(new OkListener());
			cancel_button.addActionListener(new CancelListener());
			panel_6.add(ok_button);
			panel_6.add(cancel_button);
			c.add(panel_6);

			frame_2.pack();
			frame_2.setVisible(true);

		}
	}

	private class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			n_drag = tex_n_dragoes.getNumber().intValue();
			n_quadrados = tex_n_quad.getNumber().intValue();
			ind_tec = opcoes_teclas.getSelectedIndex();
			ind_tipo_jogo = opcoes_jogo.getSelectedIndex();
			frame_2.setVisible(false);
		}
	}

	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame_2.setVisible(false);
		}
	}

	private class TabuleiroListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FazerTabuleiro(ContactManager.this);

		}
	}


	/**
	 * 
	 * Quando criamos manualmente um tabuleiro é necessário executar este método para actualizar o tabuleiro
	 */
	public void actualizar() {

		if(j != null){
			j1 = j;
			j = null;
			n_quadrados = 15;
			frame.repaint();
			frame.setSize(new Dimension(40 * n_quadrados+16,40 * n_quadrados + 65 ));
		}else
			JOptionPane.showMessageDialog(frame, "Tem de criar um novo tabuleiro!!");

	}


	/**
	 * 
	 * Criação dos botões principais do nosso Jogo
	 */
	private void criaBotao() {
		exit_button = new JButton("Sair");
		option_button = new JButton("Opções");
		new_game_button = new JButton("Jogar");
		save_button = new JButton("Guardar jogo");
		load_button = new JButton("Carregar jogo");
		tabuleiro_button = new JButton("Cria tabuleiro");
		exit_button.setFocusable(false);
		new_game_button.setFocusable(false);
		option_button.setFocusable(false);
		tabuleiro_button.setFocusable(false);
		save_button.setFocusable(false);
		load_button.setFocusable(false);
		exit_button.addActionListener(new ExitListener());
		option_button.addActionListener(new OptionListener());
		new_game_button.addActionListener(new PlayListener());
		tabuleiro_button.addActionListener(new TabuleiroListener());
		save_button.addActionListener(new SaveListener());
		load_button.addActionListener(new LoadListener());

	}


	/**
	 * 
	 * Cria as imagens que representam o Dragão, a Espada, o Heroi e as paredes.
	 */
	private void criaImagens() {
		try {
			parede = ImageIO.read(new File("parede.jpg"));
			dragao = ImageIO.read(new File("dragao.gif"));
			heroi = ImageIO.read(new File("heroi.gif"));
			espada = ImageIO.read(new File("espada.jpg"));
			dragao_adormecido = ImageIO.read(new File("dragao_adormecido.jpg"));
			heroi_armado = ImageIO.read(new File("heroi_armado.jpg"));
			dragao_espada = ImageIO.read(new File("dragao_espada.jpg"));
		} catch (IOException e) {
			System.out.println("Error:"+e.getMessage());
		}
	}

	/**
	 * Construtor da classe ContactManager que cria o frame principal onde se irá "passar" o jogo
	 */
	public ContactManager() {
		criaImagens();
		frame = new JFrame("Labirinto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(largura * n_quadrados + 16,largura * n_quadrados + 65 ));

		Container c = frame.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		criaBotao();
		panel_1.add(new_game_button);
		panel_1.add(option_button);
		panel_1.add(tabuleiro_button);
		panel_1.add(save_button);
		panel_1.add(load_button);
		panel_1.add(exit_button);
		c.add(panel_1);
		SimpleGraphicsPanel g = new SimpleGraphicsPanel(frame);
		frame.add(g);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Função main
	 * @param args
	 */
	public static void main(String args[]) {
		new ContactManager();
	}

}
