package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.DAO;

public class Principal extends JFrame {
	DAO dao = new DAO();
	private Connection con;
	@SuppressWarnings("unused")
	private PreparedStatement pst;
	@SuppressWarnings("unused")
	private ResultSet rs;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblData;
	public JLabel lblUsuario;
	public JPanel panelRodape;
	public JButton btnUsuarios;
	public JButton btnFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("TeramachiTech - Serviços de Montagem de PC Gamer");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/note.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				setarData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnSobre = new JButton("");
		btnSobre.setBorder(null);
		btnSobre.setContentAreaFilled(false);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(714, 11, 48, 48);
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/sobre.png")));
		contentPane.add(btnSobre);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setBounds(47, 65, 135, 128);
		contentPane.add(btnUsuarios);
		
		panelRodape = new JPanel();
		panelRodape.setBackground(new Color(128, 128, 128));
		panelRodape.setBounds(0, 490, 784, 71);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);
		
		lblData = new JLabel("New label");
		lblData.setBounds(10, 26, 382, 20);
		panelRodape.add(lblData);
		lblData.setForeground(SystemColor.text);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblUsuario2 = new JLabel("Usuário: ");
		lblUsuario2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario2.setForeground(new Color(255, 255, 255));
		lblUsuario2.setBounds(396, 23, 116, 27);
		panelRodape.add(lblUsuario2);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(491, 26, 243, 20);
		panelRodape.add(lblUsuario);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(705, 11, 48, 48);
		panelRodape.add(lblStatus);
		lblStatus.setToolTipText("StatusOff");
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dboff.png")));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(SystemColor.desktop);
		lblLogo.setBounds(533, 415, 241, 207);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/img/pc gamer edit 2323414141.png")));
		
		JButton btnservicoOS = new JButton("");
		btnservicoOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos servicos = new Servicos();
					servicos.setVisible(true);	
			}
		});
		btnservicoOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnservicoOS.setIcon(new ImageIcon(Principal.class.getResource("/img/os.png")));
		btnservicoOS.setToolTipText("Ordem de Serviços");
		btnservicoOS.setContentAreaFilled(false);
		btnservicoOS.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnservicoOS.setBounds(47, 279, 135, 128);
		contentPane.add(btnservicoOS);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/ClienteGRANDE2.png")));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnClientes.setBounds(291, 65, 135, 128);
		contentPane.add(btnClientes);
		
		JButton btnRelatorios = new JButton("");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
				
			}
		});
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/RELATÓRIOGRANDE1.png")));
		btnRelatorios.setToolTipText("Relatórios");
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnRelatorios.setBounds(291, 279, 135, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/img/produtos.png")));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnProdutos.setBounds(537, 65, 135, 128);
		contentPane.add(btnProdutos);
		
		btnFornecedor = new JButton("");
		btnFornecedor.setEnabled(false);
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedor.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedor.png")));
		btnFornecedor.setToolTipText("Fornecedor");
		btnFornecedor.setContentAreaFilled(false);
		btnFornecedor.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnFornecedor.setBounds(537, 279, 135, 128);
		contentPane.add(btnFornecedor);
		
		JLabel lblNewLabel = new JLabel("ORDEM DE SERVIÇO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(47, 241, 154, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblRelatrios = new JLabel("RELATÓRIOS");
		lblRelatrios.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRelatrios.setBounds(313, 241, 102, 27);
		contentPane.add(lblRelatrios);
		
		JLabel lblFornecedores = new JLabel("FORNECEDORES");
		lblFornecedores.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFornecedores.setBounds(547, 241, 116, 27);
		contentPane.add(lblFornecedores);
		
		JLabel lblUsurios = new JLabel("USUÁRIOS");
		lblUsurios.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsurios.setBounds(75, 32, 78, 27);
		contentPane.add(lblUsurios);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblClientes.setBounds(319, 32, 78, 27);
		contentPane.add(lblClientes);
		
		JLabel lblProdutos = new JLabel("PRODUTOS");
		lblProdutos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblProdutos.setBounds(565, 32, 78, 27);
		contentPane.add(lblProdutos);
	}
	
	/**
	 * Método responsável por exibir o status da conexão
	 */
	private void status(){
		try {
			con = dao.conectar();
			if(con == null) {
					System.out.println("Erro de conexão");
					lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dboff.png")));
			} else {
				System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/dbon.png")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	/**
	 * Método responsável por setar a data no rodapé
	 */
	private void setarData() {

		Date data = new Date();

		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

		lblData.setText(formatador.format(data));
	}
}
