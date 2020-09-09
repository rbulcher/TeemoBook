import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/*
 * iPav's spreadsheet (csv) of Teemo guide book turned into simple Java Application
 * Youtube: https://www.youtube.com/channel/UCoOUiBglwGIcnzjBcEQ1uIQ
 * Twitch: https://www.twitch.tv/ipav999
 * Original Google Sheet: https://tinyurl.com/y3529ow5
 * 
 * Author: Ryan Bulcher
 * Date: 9 - 4 - 2020
 * Some code taken from: https://camposha.info/java-jlist-filter-search/ (GUI implementation for search list) 
 */
public class TeemoBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
	private static Map<String, Champion> champions = new HashMap<>();
	private static ArrayList<String> champNames = new ArrayList<>();
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JList<String> myJList;
	private JLabel searchLabel;
	private JTextField searchTxt;

	/*
	 * Constructor
	 */
	public TeemoBook() {
		initComponents();
		this.bindData();
	}

	/*
	 * Our data source
	 */
	private static void getData() {
		try {
			String filePath = "resources\\data.txt";
			FileInputStream file = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			String champString = reader.readLine();
			champString = reader.readLine(); // skip title line
			while (champString != null) {
				String[] champ = champString.split(",");
				Champion addChamp = new Champion();
				addChamp.setName(champ[0]);
				addChamp.setOnevsone(champ[1]);
				addChamp.setVsBurst(champ[2]);
				addChamp.setVsMSJG(champ[3]);
				addChamp.setBoots(champ[5]);
				addChamp.setFirstItem(champ[6]);
				addChamp.setSumSpell(champ[8]);
				addChamp.setDifficulty(champ[11]);
				champions.put(addChamp.name, addChamp);
				champNames.add(addChamp.name);
				champString = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("ERROR LOADING FILE: " + e.getMessage());
		}
	}

	/*
	 * Bind data to JList
	 */
	private void bindData() {
		// foreach with functinal operation
		champNames.stream().forEach((champ) -> {
			defaultListModel.addElement(champ);
		});
		myJList.setModel(defaultListModel);
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	/*
	 * Search/Filter data
	 */
	private void searchFilter(String searchTerm) {
		DefaultListModel<String> filteredItems = new DefaultListModel<>();
		ArrayList<String> champs = champNames;

		champs.stream().forEach((champ) -> {
			String starName = champ.toString().toLowerCase();
			if (starName.contains(searchTerm.toLowerCase())) {
				filteredItems.addElement(champ);
			}
		});
		defaultListModel = filteredItems;
		myJList.setModel(defaultListModel);

	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		myJList = new JList<>();
		searchTxt = new JTextField();
		searchLabel = new JLabel();

		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Guide App");
		jPanel1.setBackground(new Color(64, 64, 64));

		//For apple only (Uncomment for apple download) 
//		try {
//			final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
//			final Image taskbarIcon = defaultToolkit
//					.getImage("src/icons/teemoIcon.png");
//			final Taskbar taskbar = Taskbar.getTaskbar();
//			// set icon for mac os (and other systems which do support this method)
//			taskbar.setIconImage(taskbarIcon);
//		} catch (final UnsupportedOperationException e) {
//			System.out.println("The os does not support: 'taskbar.setIconImage'");
//		} catch (final SecurityException e) {
//			System.out.println("There was a security exception for: 'taskbar.setIconImage'");
//		}

		myJList.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				myJListMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(myJList);

		searchTxt.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		searchTxt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				searchTxtKeyReleased(evt);
			}
		});

		searchLabel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		searchLabel.setForeground(new Color(204, 204, 204));
		searchLabel.setText("Search/Filter");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(69, 69, 69).addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(searchLabel).addGap(18, 18, 18)
								.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(90, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchLabel))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE).addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addContainerGap().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(10, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null); // center on screen
	}// </editor-fold>

	private void myJListMouseClicked(MouseEvent evt) {
		Champion currentChamp = champions.get(myJList.getSelectedValue());
		guidePage currentGuide = new guidePage(currentChamp);
		currentGuide.setVisible(true);
		currentGuide.setTitle("Teemo vs " + myJList.getSelectedValue());
	}

	private void searchTxtKeyReleased(KeyEvent evt) {
		searchFilter(searchTxt.getText());
	}

	// main method
	public static void main(String args[]) {
		getData();
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			Logger.getLogger(TeemoBook.class.getName()).log(Level.SEVERE, null, ex);
		}
		EventQueue.invokeLater(() -> {
			new TeemoBook().setVisible(true);
		});
	}

}
