package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 544);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u754C\u9762");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(242, 25, 158, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u5546\u5BB6\u7BA1\u7406");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_shop().setVisible(true);
			}
		});
		btnNewButton.setBounds(49, 231, 122, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7528\u6237\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_user().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(254, 231, 133, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8BA2\u5355\u67E5\u770B");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(463, 231, 122, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(254, 463, 133, 34);
		contentPane.add(btnNewButton_3);
		this.setLocationRelativeTo(null);
	}

}
