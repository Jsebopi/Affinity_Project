package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import model.Person;
import controller.Controller;

public class JDViewList extends JDialog {
	private static final long serialVersionUID = 1L;
	private JMenuItem jmAgree, jmExit, jmInfo;
	private JComboBox<String> personOne, personTwo;
	private JButton jbAgree, jbAffinity;
	private JProgressBar jProgressBar;
	private JLabel jlInfo;
	private JTable jtTable;
	private DefaultTableModel dtable;
	private JPanel jpanel;
	private JMenuBar menu;
	private JMenu jInfo, jArchive;
	private JToolBar signUp;
	String[] columnas = { "Nombre", "Apellido", "Identificacion",
			"Primer Item", "Segundo Item", "Tercer Item" };

	public JDViewList(Controller controller) {
		setTitle(Constants.NAME_VIEW_LIST);
		setSize(Constants.DIALOG_ANCHO_LIST, Constants.DIALOG_ALTO_LIST);
		setMinimumSize(new Dimension(Constants.DIALOG_ANCHO,
				Constants.DIALOG_ALTO));
		setModal(true);
		Image image = Toolkit.getDefaultToolkit().getImage("img/view_list.png");
		setIconImage(image);
		setLocationRelativeTo(null);

		jpanel = new JPanel(new BorderLayout());
		this.getContentPane().add(jpanel);
		jpanel.setBackground(Color.WHITE);

		menu = new JMenuBar();
		menu.setBackground(Color.decode("#1F1D1D"));
		jArchive = new JMenu("Archivo");
		jArchive.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jArchive.setForeground(Color.WHITE);
		jInfo = new JMenu("Acerca de ");
		jInfo.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jInfo.setForeground(Color.WHITE);
		menu.add(jArchive);
		menu.add(jInfo);

		jmAgree = new JMenuItem(Constants.TITLE_AGREE, new ImageIcon(
				"img/agree.png"));
		jmAgree.setActionCommand(Constants.C_AGREE_NEW_PERSON);
		jmAgree.addActionListener(controller);
		jmAgree.setBackground(Color.decode("#1F1D1D"));
		jmAgree.setForeground(Color.WHITE);
		jmAgree.setToolTipText("Agregar");
		jmAgree.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jmAgree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_DOWN_MASK));

		jmExit = new JMenuItem(Constants.NAME_EXIT, new ImageIcon(
				"img/exit.png"));
		jmExit.setActionCommand(Constants.C_EXIT);
		jmExit.addActionListener(controller);
		jmExit.setBackground(Color.decode("#1F1D1D"));
		jmExit.setForeground(Color.WHITE);
		jmExit.setToolTipText("Salir");
		jmExit.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_DOWN_MASK));

		jmInfo = new JMenuItem(Constants.NAME_INFO, new ImageIcon(
				"img/help.png"));
		jmInfo.setActionCommand(Constants.C_INFO);
		jmInfo.addActionListener(controller);
		jmInfo.setBackground(Color.decode("#1F1D1D"));
		jmInfo.setForeground(Color.WHITE);
		jmInfo.setToolTipText("Informacion");
		jmInfo.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jmInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_DOWN_MASK));

		dtable = new DefaultTableModel(columnas, 5);
		jtTable = new JTable(dtable);
		jtTable.getTableHeader().setReorderingAllowed(false);
		jtTable.setEnabled(false);
		JScrollPane sp = new JScrollPane(jtTable);
		jpanel.add(sp, BorderLayout.PAGE_START);
		getContentPane().setBackground(Color.WHITE);

		personOne = new JComboBox<String>();
		personTwo = new JComboBox<String>();
		jbAffinity = new JButton("  ", new ImageIcon("img/affinity.png"));
		jbAffinity.setActionCommand(Constants.C_CALCULATE_AFFINITY);
		jbAffinity.addActionListener(controller);
		jbAffinity.setBackground(Color.decode("#1F1D1D"));
		jbAffinity.setForeground(Color.WHITE);
		jbAffinity.setToolTipText("Agregar");
		jbAffinity.setBorder(null);

		signUp = new JToolBar();
		signUp.setBackground(Color.decode("#1F1D1D"));
		signUp.setFloatable(false);
		signUp.setBorder(null);

		jbAgree = new JButton("  ", new ImageIcon("img/agree.png"));
		jbAgree.setActionCommand(Constants.C_AGREE_NEW_PERSON);
		jbAgree.addActionListener(controller);
		jbAgree.setBackground(Color.decode("#1F1D1D"));
		jbAgree.setForeground(Color.WHITE);
		jbAgree.setToolTipText("Agregar");
		jbAgree.setBorder(null);

		jlInfo = new JLabel("Su Porcentaje de Afinidad es:");
		jlInfo.setToolTipText("Afinidad");
		jlInfo.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 16));
		jpanel.add(jlInfo, BorderLayout.CENTER);

		jProgressBar = new JProgressBar();
		jProgressBar.setStringPainted(true);
		jProgressBar.setForeground(Color.BLACK);
		jProgressBar.setBackground(Color.white);
		jpanel.add(jProgressBar, BorderLayout.PAGE_END);

		setJMenuBar(menu);
		jArchive.add(jmAgree);
		jArchive.add(jmExit);
		jInfo.add(jInfo);
		add(personOne, BorderLayout.PAGE_END);
		add(personTwo, BorderLayout.PAGE_END);
		add(signUp, BorderLayout.PAGE_END);
		signUp.add(jbAgree);
		signUp.add(personOne);
		signUp.add(jbAffinity);
		signUp.add(personTwo);

	}

	public void agreeRowPerson(Person agree) {
		dtable.insertRow(0, agree.toStringVector());
	}

	public String namePersonOne() {
		return personOne.getSelectedItem().toString();
	}

	public String namePersonTwo() {
		return personTwo.getSelectedItem().toString();
	}

	public void insertInfoCombo(String name) {
		personOne.insertItemAt(name, 0);
		personTwo.insertItemAt(name, 0);
	}

	public void CountProgress(int affinity) {
		jProgressBar.setValue(affinity);

	}

}
