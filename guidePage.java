
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class guidePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Champion champion = new Champion();
	String name, onevsone, vsBurst, vsMSJG, boots, firstItem, optionalItem, sumSpell, difficulty;

	/*
	 * Map of all the icons, Certain images had to be resized: That is the extra
	 * .getImage().getScaledInstance() .... other images did not need resize.
	 */

	Map<String, ImageIcon> icons = new HashMap<String, ImageIcon>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("flash", new ImageIcon("icons\\Flash.png"));
			put("Armguard", new ImageIcon("icons\\Armguard.png"));
			put("Berserk", new ImageIcon("icons\\Berserkers.png"));
			put("Berserker", new ImageIcon("icons\\Berserkers.png"));
			put("E", new ImageIcon(new ImageIcon("icons\\Electrocute.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Darkharvest", new ImageIcon("icons\\Darkharvest.png"));
			put("Dom", new ImageIcon(new ImageIcon("icons\\Domination.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("FF", new ImageIcon(new ImageIcon("icons\\FleetFootwork.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Ghost", new ImageIcon("icons\\Ghost.png"));
			put("GoU", new ImageIcon(new ImageIcon("icons\\GraspOfTheUndying.png").getImage().getScaledInstance(60,
					60, Image.SCALE_DEFAULT)));
			put("Gunblade", new ImageIcon("icons\\Gunblade.png"));
			put("HoB", new ImageIcon(new ImageIcon("icons\\HailOfBlades.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Hourglass", new ImageIcon("icons\\Hourglass.png"));
			put("Ignite", new ImageIcon("icons\\Ignite.png"));
			put("Inspiration", new ImageIcon("icons\\Inspiration.png"));
			put("Liandry", new ImageIcon("icons\\Liandrys.png"));
			put("Mantle", new ImageIcon("icons\\Mantle.png"));
			put("Mercury", new ImageIcon("icons\\Mercurys.png"));
			put("Morello", new ImageIcon("icons\\Morello.png"));
			put("Nashor", new ImageIcon("icons\\Nashors.png"));
			put("Negatron", new ImageIcon("icons\\Negatron.png"));
			put("PR", new ImageIcon(new ImageIcon("icons\\PhaseRush.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Pre", new ImageIcon(new ImageIcon("icons\\Precision.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("PTA", new ImageIcon(new ImageIcon("icons\\PressTheAttack.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Pres", new ImageIcon(new ImageIcon("icons\\PressTheAttack.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("QSS", new ImageIcon("icons\\QSS.png"));
			put("Res", new ImageIcon(
					new ImageIcon("icons\\Resolve.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
			put("Sorcerer", new ImageIcon("icons\\Sorcerers.png"));
			put("Speed", new ImageIcon("icons\\Speed.png"));
			put("SA", new ImageIcon(new ImageIcon("icons\\SummonAery.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)));
			put("Swiftness", new ImageIcon("icons\\Swiftness.png"));
			put("Ninja", new ImageIcon("icons\\Tabi.png"));
			put("Teleport", new ImageIcon("icons\\Teleport.png"));
			put("Wit", new ImageIcon("icons\\Wits.png"));
			// Difficulty rank images below
			put("Free", new ImageIcon(new ImageIcon("icons\\Free.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Easy", new ImageIcon(new ImageIcon("icons\\Easy.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Okay", new ImageIcon(new ImageIcon("icons\\Okay.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Decent", new ImageIcon(new ImageIcon("icons\\Decent.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Hard", new ImageIcon(new ImageIcon("icons\\Hard.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Very", new ImageIcon(new ImageIcon("icons\\Very.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
			put("Dodge", new ImageIcon(new ImageIcon("icons\\Dodge.png").getImage().getScaledInstance(300, 300,
					Image.SCALE_DEFAULT)));
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guidePage frame = new guidePage(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ImageIcon getItemNeeded(String item) {
		String[] find = item.split(" ");
		String[] clean = find[0].split("'");
		return icons.get(clean[0]);
	}

	private ImageIcon[] getRunesNeeded(String rune) {
		ImageIcon[] images = new ImageIcon[2];
		String[] find = rune.split(" ");
		images[0] = getItemNeeded(find[0]);
		images[1] = getItemNeeded(find[2]);
		return images;
	}

	/**
	 * Create the frame.
	 */
	public guidePage(Champion champion) {
		getContentPane().setBackground(Color.BLACK);
		setBackground(new Color(139, 69, 19));
		name = champion.name;
		onevsone = champion.onevsone;
		vsBurst = champion.vsBurst;
		vsMSJG = champion.vsMSJG;
		boots = champion.boots;
		firstItem = champion.firstItem;
		optionalItem = champion.optionalItem;
		sumSpell = champion.sumSpell;
		difficulty = champion.difficulty;

		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		
		

		JLabel lblNewLabel_2 = new JLabel("      ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridheight = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 10;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("                ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				JLabel lblNewLabel = new JLabel("Teemo VS " + champion.name);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 9;
				gbc_lblNewLabel.gridy = 4;
				getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridwidth = 2;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNewLabel_3 = new JLabel("Rune 1 vs 1:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(getRunesNeeded(champion.onevsone)[0]);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 5;
		gbc_lblNewLabel_4.gridy = 5;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_7 = new JLabel(getRunesNeeded(champion.onevsone)[1]);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 5;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("                    ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 10;
		gbc_lblNewLabel_6.gridy = 5;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 2;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 6;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);

		JLabel lblNewLabel_5 = new JLabel("Rune vs Burst Jg:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 6;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_8 = new JLabel(getRunesNeeded(champion.vsBurst)[0]);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 6;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel(getRunesNeeded(champion.vsBurst)[1]);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 7;
		gbc_lblNewLabel_9.gridy = 6;
		getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridwidth = 2;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 7;
		getContentPane().add(horizontalStrut_2, gbc_horizontalStrut_2);

		JLabel lblNewLabel_5_1 = new JLabel("Rune vs MS Jg:");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 2;
		gbc_lblNewLabel_5_1.gridy = 7;
		getContentPane().add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);

		JLabel lblNewLabel_8_1 = new JLabel(getRunesNeeded(champion.vsMSJG)[0]);
		GridBagConstraints gbc_lblNewLabel_8_1 = new GridBagConstraints();
		gbc_lblNewLabel_8_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_1.gridx = 5;
		gbc_lblNewLabel_8_1.gridy = 7;
		getContentPane().add(lblNewLabel_8_1, gbc_lblNewLabel_8_1);

		JLabel lblNewLabel_10 = new JLabel(getRunesNeeded(champion.vsMSJG)[1]);
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 7;
		gbc_lblNewLabel_10.gridy = 7;
		getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(getItemNeeded(champion.difficulty));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridheight = 9;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 9;
		gbc_lblNewLabel_11.gridy = 5;
		getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.gridwidth = 2;
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 10;
		getContentPane().add(horizontalStrut_3, gbc_horizontalStrut_3);

		JLabel lblNewLabel_5_2 = new JLabel("Boots:");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_2 = new GridBagConstraints();
		gbc_lblNewLabel_5_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_2.gridx = 2;
		gbc_lblNewLabel_5_2.gridy = 10;
		getContentPane().add(lblNewLabel_5_2, gbc_lblNewLabel_5_2);

		JLabel lblNewLabel_8_2 = new JLabel(getItemNeeded(champion.boots));
		GridBagConstraints gbc_lblNewLabel_8_2 = new GridBagConstraints();
		gbc_lblNewLabel_8_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_2.gridx = 5;
		gbc_lblNewLabel_8_2.gridy = 10;
		getContentPane().add(lblNewLabel_8_2, gbc_lblNewLabel_8_2);

		JLabel lblNewLabel_5_1_1 = new JLabel(champion.boots);
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1_1.gridx = 7;
		gbc_lblNewLabel_5_1_1.gridy = 10;
		getContentPane().add(lblNewLabel_5_1_1, gbc_lblNewLabel_5_1_1);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.gridwidth = 2;
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 12;
		getContentPane().add(horizontalStrut_4, gbc_horizontalStrut_4);

		JLabel lblNewLabel_5_3 = new JLabel("1st Item:");
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_3 = new GridBagConstraints();
		gbc_lblNewLabel_5_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_3.gridx = 2;
		gbc_lblNewLabel_5_3.gridy = 12;
		getContentPane().add(lblNewLabel_5_3, gbc_lblNewLabel_5_3);

		JLabel lblNewLabel_8_2_1 = new JLabel(getItemNeeded(champion.firstItem));
		GridBagConstraints gbc_lblNewLabel_8_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_8_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_2_1.gridx = 5;
		gbc_lblNewLabel_8_2_1.gridy = 12;
		getContentPane().add(lblNewLabel_8_2_1, gbc_lblNewLabel_8_2_1);

		JLabel lblNewLabel_5_2_1 = new JLabel(champion.firstItem);
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_2_1.gridx = 7;
		gbc_lblNewLabel_5_2_1.gridy = 12;
		getContentPane().add(lblNewLabel_5_2_1, gbc_lblNewLabel_5_2_1);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.gridwidth = 2;
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 0;
		gbc_horizontalStrut_5.gridy = 14;
		getContentPane().add(horizontalStrut_5, gbc_horizontalStrut_5);

		JLabel lblNewLabel_5_4 = new JLabel("Summoner Spells:");
		lblNewLabel_5_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_5_4 = new GridBagConstraints();
		gbc_lblNewLabel_5_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_4.gridx = 2;
		gbc_lblNewLabel_5_4.gridy = 14;
		getContentPane().add(lblNewLabel_5_4, gbc_lblNewLabel_5_4);

		JLabel lblNewLabel_8_2_2 = new JLabel(getItemNeeded(champion.sumSpell));
		GridBagConstraints gbc_lblNewLabel_8_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_8_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_2_2.gridx = 5;
		gbc_lblNewLabel_8_2_2.gridy = 14;
		getContentPane().add(lblNewLabel_8_2_2, gbc_lblNewLabel_8_2_2);

		JLabel lblNewLabel_8_2_3 = new JLabel(icons.get("flash"));
		GridBagConstraints gbc_lblNewLabel_8_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_8_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8_2_3.gridx = 7;
		gbc_lblNewLabel_8_2_3.gridy = 14;
		getContentPane().add(lblNewLabel_8_2_3, gbc_lblNewLabel_8_2_3);

		JButton nextMatch = new JButton("Exit");
		nextMatch.setHorizontalAlignment(SwingConstants.RIGHT);
		nextMatch.setFont(new Font("Times New Roman", Font.BOLD, 26));
		nextMatch.setIcon(new ImageIcon(new ImageIcon("icons\\teemoIcon.png").getImage().getScaledInstance(140, 140,
				Image.SCALE_DEFAULT)));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 14;
		getContentPane().add(nextMatch, gbc_btnNewButton);
		nextMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(new ImageIcon("icons\\Book.png").getImage().getScaledInstance(900, 600,
				Image.SCALE_DEFAULT)));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.gridwidth = 12;
		gbc_lblNewLabel_12.gridheight = 18;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 1;
		getContentPane().add(lblNewLabel_12, gbc_lblNewLabel_12);

	}

}
