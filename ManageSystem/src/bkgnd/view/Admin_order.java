package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Admin_order extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_order frame = new Admin_order();
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
	public Admin_order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 86, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BA2\u5355\u67E5\u8BE2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(258, 60, 86, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u6309\u65F6\u95F4\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order_time().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(96, 148, 188, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6309\u7C7B\u578B\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order_type().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(347, 148, 179, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("\u8BA2\u5355\u7EDF\u8BA1");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order_count().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(347, 267, 179, 36);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\u6309\u5546\u5BB6\u548C\u7528\u6237\u67E5\u8BE2");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order_us().setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1_2.setBounds(96, 267, 188, 36);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("\u67E5\u8BE2\u5546\u5BB6");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_order_shop().setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1_2_1.setBounds(96, 369, 188, 36);
		contentPane.add(btnNewButton_1_2_1);
		this.setLocationRelativeTo(null);
	}
}
