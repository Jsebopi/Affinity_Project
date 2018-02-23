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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import controller.Controller;
import model.Person;
import model.Solution;

public class JDNewPerson extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel jlname, jlastName, jlid, jlCity_live, jlTravell, jlsong;
	private JTextField jtname, jtLastName, jtId, jtCity_live, jtsong;
	private JComboBox<Solution> jcbTravell;
	private JPanel jPanel;
	private JMenuBar menu;
	private JMenu jmarchive, jmInfo;
	private JMenuItem jiAgree, jInfo;
	private JButton jbAgree;

	public JDNewPerson(Controller controller) {
		setTitle(Constants.TITLE_AGREE);
		setSize(Constants.DIALOG_ANCHO, Constants.DIALOG_ALTO);
		setMinimumSize(new Dimension(Constants.DIALOG_ANCHO,
				Constants.DIALOG_ALTO));
		setModal(true);
		Image image = Toolkit.getDefaultToolkit().getImage(
				"img/login_agree.png");
		setIconImage(image);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		jPanel = new JPanel(new GridBagLayout());
		this.getContentPane().add(jPanel);
		jPanel.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		menu = new JMenuBar();
		menu.setBackground(Color.decode("#1F1D1D"));
		jmarchive = new JMenu("Archivo");
		jmInfo = new JMenu("Acerca de ");
		jmarchive.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jmarchive.setForeground(Color.WHITE);
		jmInfo.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jmInfo.setForeground(Color.WHITE);
		menu.add(jmarchive);
		menu.add(jmInfo);

		jlname = new JLabel(Constants.NAME_PERSON);
		jtname = new JTextField(10);
		jlastName = new JLabel(Constants.LASTNAME_PERSON);
		jtLastName = new JTextField(10);
		jlid = new JLabel(Constants.ID_PERSON);
		jtId = new JTextField(10);
		jlCity_live = new JLabel(Constants.CITY_BORN);
		jtCity_live = new JTextField(10);
		jlTravell = new JLabel(Constants.TRAVELL_PERSON);
		jcbTravell = new JComboBox<Solution>(Solution.values());
		jlsong = new JLabel(Constants.SONG);
		jtsong = new JTextField(10);

		jbAgree = new JButton(Constants.NAME_AGREE_PERSON, new ImageIcon(
				"img/accept.png"));
		jbAgree.setActionCommand(Constants.C_AGREE_PERSON);
		jbAgree.addActionListener(controller);
		jbAgree.setBackground(Color.decode("#1F1D1D"));
		jbAgree.setForeground(Color.WHITE);
		jbAgree.setToolTipText("Agregar Persona");
		jbAgree.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));

		jiAgree = new JMenuItem(Constants.NAME_AGREE_PERSON, new ImageIcon(
				"img/accept.png"));
		jiAgree.setActionCommand(Constants.C_AGREE_PERSON);
		jiAgree.addActionListener(controller);
		jiAgree.setBackground(Color.decode("#1F1D1D"));
		jiAgree.setForeground(Color.WHITE);
		jiAgree.setToolTipText("Agregar Persona");
		jiAgree.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jiAgree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_DOWN_MASK));

		jInfo = new JMenuItem(Constants.NAME_INFO,
				new ImageIcon("img/help.png"));
		jInfo.setActionCommand(Constants.C_INFO);
		jInfo.addActionListener(controller);
		jInfo.setBackground(Color.decode("#1F1D1D"));
		jInfo.setForeground(Color.WHITE);
		jInfo.setToolTipText("Informacion");
		jInfo.setFont(new Font("Segoe Print", Font.CENTER_BASELINE, 12));
		jInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_DOWN_MASK));

		setJMenuBar(menu);
		jmarchive.add(jiAgree);
		jmInfo.add(jInfo);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jlname, c);

		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jtname, c);

		c.gridx = 0;
		c.gridy = 1;
		c.fill =  GridBagConstraints.BOTH;
		jPanel.add(jlastName, c);

		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jtLastName, c);

		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jlid, c);

		c.gridx = 1;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jtId, c);

		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jlCity_live, c);

		c.gridx = 1;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jtCity_live, c);

		c.gridx = 0;
		c.gridy = 4;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jlTravell, c);

		c.gridx = 1;
		c.gridy = 4;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jcbTravell, c);

		c.gridx = 0;
		c.gridy = 5;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jlsong, c);

		c.gridx = 1;
		c.gridy = 5;
		c.fill = GridBagConstraints.BOTH;
		jPanel.add(jtsong, c);

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.fill = GridBagConstraints.CENTER;
		jPanel.add(jbAgree, c);
	}

	public void CleanScreen() {
		jtname.setText("");
		jtLastName.setText("");
		jtId.setText("");
		jtCity_live.setText("");
		jcbTravell.setSelectedItem(Solution.values());
		jtsong.setText("");
	}

	public Person createPerson() {
		return new Person(Integer.parseInt(jtId.getText()), jtname.getText(),
				jtLastName.getText(), jtCity_live.getText(), jcbTravell
						.getSelectedItem().toString(), jtsong.getText());
	}

	public boolean ValidateScreen() {
		boolean box = true;
		if (jtname.getText().length() == 0
				|| jtLastName.getText().length() == 0
				|| jtId.getText().length() == 0
				|| jtCity_live.getText().length() == 0
				|| jtsong.getText().length() == 0) {
			box = false;
		}
		return box;
	}

}
