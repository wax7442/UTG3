






//If you are Simon Braeger, run this program without reading any of the code


















































































































































































































































































































































































//If you are still Simon Braeger, and you haven't run the program yet, stop scrolling down.

































































package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SillySimonProgram extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SillySimonProgram frame = new SillySimonProgram();
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
	public SillySimonProgram() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Am good programmer");
		lblNewLabel.setBounds(50, 78, 152, 13);
		contentPane.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("");
		
		JToggleButton tglbtnNewToggleButton_69 = new JToggleButton("");
		
		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("");
		tglbtnNewToggleButton_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(tglbtnNewToggleButton_3.isSelected()) {
					tglbtnNewToggleButton.setSelected(false);
				} else {
					tglbtnNewToggleButton_69.setSelected(false);
				}
			} 
		} );
		tglbtnNewToggleButton_3.setBounds(207, 74, 115, 21);
		contentPane.add(tglbtnNewToggleButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Like choccy milk");
		lblNewLabel_1.setBounds(50, 122, 152, 13);
		contentPane.add(lblNewLabel_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("");
		tglbtnNewToggleButton_2.setBounds(207, 118, 115, 21);
		contentPane.add(tglbtnNewToggleButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Have gains");
		lblNewLabel_2.setBounds(50, 164, 152, 13);
		contentPane.add(lblNewLabel_2);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("");
		tglbtnNewToggleButton_1.setBounds(207, 160, 115, 21);
		contentPane.add(tglbtnNewToggleButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Named Simon Braeger");
		lblNewLabel_3.setBounds(50, 211, 152, 13);
		contentPane.add(lblNewLabel_3);
		
		tglbtnNewToggleButton.setBounds(207, 207, 115, 21);
		contentPane.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(tglbtnNewToggleButton.isSelected()) {
					tglbtnNewToggleButton_3.setSelected(false);
					tglbtnNewToggleButton_69.setSelected(false);
				}
			} 
		} );
		
		JLabel lblNewLabel_69 = new JLabel("Named Alex Loff");
		lblNewLabel_69.setBounds(50, 258, 152, 13);
		contentPane.add(lblNewLabel_69);
		
		
		tglbtnNewToggleButton_69.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(tglbtnNewToggleButton_69.isSelected()) {
					tglbtnNewToggleButton.setSelected(false);
					tglbtnNewToggleButton_3.setSelected(true);
				}
			} 
		} );
		tglbtnNewToggleButton_69.setBounds(207, 254, 115, 21);
		contentPane.add(tglbtnNewToggleButton_69);
		
		JLabel lblNewLabel_4 = new JLabel("BALLERNESS TEST");
		lblNewLabel_4.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(142, 10, 259, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Is baller:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(351, 160, 204, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Waiting for data...");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(332, 200, 251, 34);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(tglbtnNewToggleButton.isSelected()) {
					lblNewLabel_6.setText("no");
				} else if(tglbtnNewToggleButton_69.isSelected()) {
					lblNewLabel_6.setText("It is certain");
				} else if (!tglbtnNewToggleButton_2.isSelected() && !tglbtnNewToggleButton_1.isSelected() && !tglbtnNewToggleButton_3.isSelected()) {
					lblNewLabel_6.setText("Unlikely");
				} else {
					lblNewLabel_6.setText("Mayhaps");
				}
			} 
		} );
		btnNewButton.setBounds(411, 118, 85, 21);
		contentPane.add(btnNewButton);
	}
}
