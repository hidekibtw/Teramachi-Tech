package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Relatorios extends JDialog {

	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Relatorios() {
		setTitle("Relatórios");
		setResizable(false);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		JButton btnClientes = new JButton("");
		btnClientes.setToolTipText("Clientes");
		btnClientes.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Client Icon.png")));
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Relatorios.class.getResource("/img/background grey.png")));
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setBounds(1, 530, 784, 30);
		getContentPane().add(lblNewLabel);
		btnClientes.setBounds(67, 106, 128, 128);
		getContentPane().add(btnClientes);

		JButton btnServicos = new JButton("");
		btnServicos.setToolTipText("Serviços");
		btnServicos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Serviços Icon.png")));
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioServicos();
			}
		});
		btnServicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos.setContentAreaFilled(false);
		btnServicos.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnServicos.setBounds(329, 106, 128, 128);
		getContentPane().add(btnServicos);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/background grey.png")));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setBounds(0, 0, 785, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CLIENTES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(82, 245, 105, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("SERVIÇOS");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(345, 237, 105, 22);
		getContentPane().add(lblNewLabel_2_1);

		JButton btnServicos_1 = new JButton("");
		btnServicos_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioEstoque();
			}
		});
		btnServicos_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/box.png")));
		btnServicos_1.setToolTipText("Estoque");
		btnServicos_1.setContentAreaFilled(false);
		btnServicos_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnServicos_1.setBounds(589, 106, 128, 128);
		getContentPane().add(btnServicos_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("ESTOQUES");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(610, 237, 98, 22);
		getContentPane().add(lblNewLabel_2_1_1);

		JButton btnServicos_1_1 = new JButton("");
		btnServicos_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioValidade();
			}
		});
		btnServicos_1_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/RELATÓRIOGRANDE2.png")));
		btnServicos_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos_1_1.setToolTipText("Serviços");
		btnServicos_1_1.setContentAreaFilled(false);
		btnServicos_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnServicos_1_1.setBounds(67, 332, 128, 128);
		getContentPane().add(btnServicos_1_1);

		JButton btnServicos_1_1_1 = new JButton("");
		btnServicos_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioPatrimonio();
			}
		});
		btnServicos_1_1_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Money Icon2.png")));
		btnServicos_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos_1_1_1.setToolTipText("Serviços");
		btnServicos_1_1_1.setContentAreaFilled(false);
		btnServicos_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnServicos_1_1_1.setBounds(329, 332, 128, 128);
		getContentPane().add(btnServicos_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("VALIDADES");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(82, 467, 105, 22);
		getContentPane().add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("PATRIMÔNIO");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_2.setBounds(331, 467, 128, 22);
		getContentPane().add(lblNewLabel_2_1_1_2);

		JButton btnServicos_1_1_1_1 = new JButton("");
		btnServicos_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnServicos_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos_1_1_1_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Supplier.png")));
		btnServicos_1_1_1_1.setToolTipText("Serviços");
		btnServicos_1_1_1_1.setContentAreaFilled(false);
		btnServicos_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnServicos_1_1_1_1.setBounds(589, 332, 128, 128);
		getContentPane().add(btnServicos_1_1_1_1);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("FORNECEDORES\r\n");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_2_1.setBounds(579, 467, 154, 22);
		getContentPane().add(lblNewLabel_2_1_1_2_1);

	}

	private void relatorioClientes() {

		Document document = new Document();

		document.setPageSize(PageSize.A4.rotate());

		try {

			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));

			document.open();

			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));

			document.add(new Paragraph("Clientes:"));
			document.add(new Paragraph(" "));
			String readClientes = "select nome,fone,email from cliente order by nome";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(readClientes);

				rs = pst.executeQuery();

				PdfPTable tabela = new PdfPTable(3);

				PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				while (rs.next()) {

					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
				}

				document.add(tabela);

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		document.close();
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioServicos() {

		Document document = new Document();

		document.setPageSize(PageSize.A4.rotate());

		try {

			PdfWriter.getInstance(document, new FileOutputStream("servicos.pdf"));

			document.open();

			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));

			document.add(new Paragraph("Serviços:"));
			document.add(new Paragraph(" "));

			String readServicos = "  select servicos.os,servicos.dataOS,servicos.servico,servicos.valor,cliente.nome from servicos inner join cliente on servicos.idcli= cliente.idcli;";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(readServicos);

				rs = pst.executeQuery();

				PdfPTable tabela = new PdfPTable(5);

				PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Data"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Serviço"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Valor"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Nome"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				while (rs.next()) {

					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

				document.add(tabela);

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		document.close();

		try {
			Desktop.getDesktop().open(new File("servicos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioEstoque() {

		Document document = new Document();

		document.setPageSize(PageSize.A4.rotate());

		try {

			PdfWriter.getInstance(document, new FileOutputStream("estoque.pdf"));

			document.open();

			Date dataEstoque = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataEstoque)));

			document.add(new Paragraph("Estoque:"));
			document.add(new Paragraph(" "));

			String readEstoque = "select codeproduto as código,produto,date_format(dataval, '%d/%m/%Y') as validade, estoque, estoquemin as estoque_mínimo from produtos where estoque < estoquemin";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(readEstoque);

				rs = pst.executeQuery();

				PdfPTable tabela = new PdfPTable(5);

				PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Estoque Mínimo"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				while (rs.next()) {

					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

				document.add(tabela);

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		document.close();

		try {
			Desktop.getDesktop().open(new File("estoque.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioValidade() {

		Document document = new Document();

		document.setPageSize(PageSize.A4.rotate());

		try {

			PdfWriter.getInstance(document, new FileOutputStream("validade.pdf"));

			document.open();

			Date dataValidade = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataValidade)));

			document.add(new Paragraph("Validade:"));
			document.add(new Paragraph(" "));

			String readValidade = "select codeproduto as código,produto,date_format(dataval, '%d/%m/%Y') as validade,date_format(dataent, '%d/%m/%Y')as entrada from produtos where dataval < dataent;";
			try {

				con = dao.conectar();

				pst = con.prepareStatement(readValidade);

				rs = pst.executeQuery();

				PdfPTable tabela = new PdfPTable(4);
				PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Entrada"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}
				document.add(tabela);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("validade.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioPatrimonio() {

		Document document = new Document();

		document.setPageSize(PageSize.A4.rotate());
		try {

			PdfWriter.getInstance(document, new FileOutputStream("patrimonio.pdf"));
			document.open();
			Date dataPatrimonio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataPatrimonio)));
			document.add(new Paragraph("Patrimônio:"));
			document.add(new Paragraph(" "));
			String readPatrimonio = "select sum(custo * estoque) as Total from produtos";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readPatrimonio);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(1);
				PdfPCell col1 = new PdfPCell(new Paragraph("Total"));
				tabela.addCell(col1);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
				}
				document.add(tabela);

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("patrimonio.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioFornecedores() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("fornecedores.pdf"));
			document.open();
			Date dataFornecedores = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataFornecedores)));
			document.add(new Paragraph("Fornecedores:"));
			document.add(new Paragraph(" "));
			String readFornecedores = "select codefornecedor, razaosocial as Nome from fornecedores";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readFornecedores);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(2);
				PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fornecedores"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
				}
				document.add(tabela);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("fornecedores.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
