package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

public class Admin_user_delete extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private DBUtil dbutil=new DBUtil();
	private DeleteUser del =new DeleteUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_user_delete frame = new Admin_user_delete();
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
	public Admin_user_delete() {
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
				new Admin_user().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 97, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u5220\u9664\u7684\u7528\u6237ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(195, 142, 253, 43);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 235, 290, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				textField.setText("");
				if(StringUtil.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "用户ID不能为空！");
				}
				else {
					try {
						Connection conn=dbutil.getCon();
						JOptionPane.showMessageDialog(null, del.DeleteU(conn, id));
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(272, 364, 97, 32);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
