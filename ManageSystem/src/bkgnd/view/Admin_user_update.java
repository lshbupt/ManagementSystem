package bkgnd.view;

import java.awt.BorderLayout;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

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
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Admin_user_update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JTextArea textArea;
	private DBUtil dbutil=new DBUtil();
	private UpdateUser uuser =new UpdateUser();
	private String user_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_user_update frame = new Admin_user_update();
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
	public Admin_user_update() {
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
		btnNewButton.setBounds(0, 10, 92, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u7684\u7528\u6237ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 86, 212, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(197, 122, 235, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u540E\u7684\u7528\u6237\u540D\u79F0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 181, 212, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u540E\u7684\u7528\u6237\u8D26\u6237");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(76, 244, 212, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u540E\u7684\u7528\u6237\u7535\u8BDD");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(76, 312, 212, 33);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(341, 185, 224, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(341, 248, 224, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(341, 316, 224, 28);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_id=textField.getText();
				String user_name=textField_1.getText();
				String user_account=textField_2.getText();
				String user_tel=textField_3.getText();
				if(StringUtil.isEmpty(user_id)) {
					JOptionPane.showMessageDialog(null, "用户ID不能为空！");
				}
				else if(StringUtil.isEmpty(user_name)) {
					JOptionPane.showMessageDialog(null, "用户名称不能为空！");
				}
				else if(StringUtil.isEmpty(user_account)) {
					JOptionPane.showMessageDialog(null, "账户不能为空！");
				}
				else if(StringUtil.isEmpty(user_tel)) {
					JOptionPane.showMessageDialog(null, "电话不能为空！");
				}
				else if(StringUtil.isEmpty(textArea.getText())) {
					JOptionPane.showMessageDialog(null, "请重置用户密码!");
				}
				else {
					try {
						Connection conn=dbutil.getCon();
						JOptionPane.showMessageDialog(null, uuser.UpdateU(conn, user_id, user_name, user_account, user_password ,user_tel));
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textArea.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(259, 463, 114, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\u91CD\u7F6E\u5BC6\u7801");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_password = RandomPassword.genRandomPwd(8);
				textArea.setText(user_password);
			}
		});
		btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(126, 369, 114, 34);
		contentPane.add(btnNewButton_1_1);
		textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(282, 375, 187, 24);
		contentPane.add(textArea);
		
		this.setLocationRelativeTo(null);
	}
}
