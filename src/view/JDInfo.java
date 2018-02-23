package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import controller.Controller;

public class JDInfo extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel autor,ubication;
	private JButton accept;

	public JDInfo(Controller controller) {
		setTitle(Constants.NAME_INFO);
		setSize(Constants.DIALOG_ALTO_ABOUT, Constants.DIALOG_ANCHO_ABOUT);
		setMinimumSize(new Dimension(Constants.DIALOG_ALTO_ABOUT,Constants.DIALOG_ANCHO_ABOUT));
		setModal(true);
		Image image = Toolkit.getDefaultToolkit().getImage("img/help.png");
		setIconImage(image);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		autor = new JLabel("JUAN SEBASTIAN BOCACHICA PINZON");
		autor.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		ubication = new JLabel("UNIVERSIDAD PEDAGOGICA Y TECNOLOGICA DE COLOMBIA");
		ubication.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		accept = new JButton("Aceptar", new ImageIcon("img/accept.png"));
		accept.setActionCommand(Constants.C_ACCEPT_INFO);
		accept.addActionListener(controller);
		accept.setBackground(Color.decode("#1F1D1D"));
		accept.setForeground(Color.WHITE);
		accept.setToolTipText("Aceptar");
		accept.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		
		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.CENTER;
		add(autor,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.fill = GridBagConstraints.CENTER;
		add(ubication,c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.fill = GridBagConstraints.CENTER;
		add(accept,c);
		

	}
}
