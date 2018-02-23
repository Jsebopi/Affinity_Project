package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Solution;
import controller.Controller;

public class JFWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jbView, jbAgree, jbAbout;

	public JFWindow(Controller controller) {
		setTitle(Constants.NAME_WINDOW);
		setSize(Constants.DIALOG_ANCHO, Constants.DIALOG_ALTO);
		setMinimumSize(new Dimension(Constants.DIALOG_ANCHO,
				Constants.DIALOG_ALTO));
		Image image = Toolkit.getDefaultToolkit().getImage("img/logo.png");
		setIconImage(image);
		setIconImage(image);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();

		jbAgree = new JButton(Constants.NAME_AGREE_PERSON, new ImageIcon(
				"img/agree.png"));
		jbAgree.setActionCommand(Constants.C_AGREE_NEW_PERSON);
		jbAgree.addActionListener(controller);
		jbAgree.setBackground(Color.decode("#1F1D1D"));
		jbAgree.setForeground(Color.WHITE);
		jbAgree.setToolTipText("Agregar Persona");
		jbAgree.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		
		jbAbout = new JButton(Constants.NAME_INFO, new ImageIcon(
				"img/help.png"));
		jbAbout.setActionCommand(Constants.C_INFO);
		jbAbout.addActionListener(controller);
		jbAbout.setBackground(Color.decode("#1F1D1D"));
		jbAbout.setForeground(Color.WHITE);
		jbAbout.setToolTipText("Acerca de");
		jbAbout.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		
		jbView = new JButton(Constants.NAME_VIEW_LIST, new ImageIcon(
				"img/view_list.png"));
		jbView.setActionCommand(Constants.C_LIST_PERSON);
		jbView.addActionListener(controller);
		jbView.setBackground(Color.decode("#1F1D1D"));
		jbView.setForeground(Color.WHITE);
		jbView.setToolTipText("Calcular Afinidad");
		jbView.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.fill = GridBagConstraints.CENTER;
		add(jbAgree, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.fill = GridBagConstraints.CENTER;
		add(jbView, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.fill = GridBagConstraints.CENTER;
		add(jbAbout, c);
	}
}
