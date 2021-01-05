package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import bkgnd.DAO.*;

public class Admin_user_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DBUtil dbutil=new DBUtil();
	private AddUser addu =new AddUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_user_add frame = new Admin_user_add();
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
	public Admin_user_add() {
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 75, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u589E\u52A0\u7528\u6237\u7684\u540D\u79F0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(56, 115, 211, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u589E\u52A0\u7528\u6237\u7684\u8D26\u53F7");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(56, 191, 211, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u589E\u52A0\u7528\u6237\u7684\u5BC6\u7801");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(56, 273, 211, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u589E\u52A0\u7528\u6237\u7684\u7535\u8BDD");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(56, 347, 211, 45);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(303, 124, 271, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(303, 200, 271, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 284, 271, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 358, 271, 28);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_name=textField.getText();
				String user_account=textField_1.getText();
				String user_password=textField_2.getText();
				String user_tel=textField_3.getText();
				if(StringUtil.isEmpty(user_name)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}
				else if(StringUtil.isEmpty(user_account)) {
					JOptionPane.showMessageDialog(null, "账户不能为空！");
				}
				else if(StringUtil.isEmpty(user_password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
				else if(StringUtil.isEmpty(user_tel)) {
					JOptionPane.showMessageDialog(null, "电话不能为空！");
				}
				else {
					try {
						Connection conn=dbutil.getCon();
						addu.AddU(conn, user_name, user_account, user_password, user_tel);
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					JOptionPane.showMessageDialog(null, "您已成功添加用户！");
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(266, 434, 96, 33);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
