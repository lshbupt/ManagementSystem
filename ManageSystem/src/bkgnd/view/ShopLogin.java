package bkgnd.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bkgnd.DAO.ShopDao;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

public class ShopLogin extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
	private DBUtil dbutil=new DBUtil();
    private shop resultshop=null;
    private ShopDao shopdao=new ShopDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopLogin frame = new ShopLogin();
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
	public ShopLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("商户登陆界面");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 41));
		
		JLabel lblNewLabel_1 = new JLabel("账户");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		
		account = new JTextField();
		account.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 25));
		
		password = new JPasswordField();
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Account=account.getText();
				String Password=new String(password.getPassword());
				if(StringUtil.isEmpty(Account)||StringUtil.isEmpty(Password))
				{
					JOptionPane.showMessageDialog(null, "密码和用户名不能为空");
				}
				else 
				{
					shop Shop=new shop(Account,Password);
					Connection conn=null;
					try {
						conn=dbutil.getCon();
						resultshop=shopdao.Login(conn, Shop);
						if(resultshop==null)
						{
							JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
						}
						else {
							/*
							 * ���ٵ�½���ڣ������̻�������
							 */
							dispose();
							new ShopMain(resultshop).setVisible(true);
						}
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
					finally {
						try {
							dbutil.closeConnection(conn);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setText("");
				password.setText("");
			}
		});
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(btnNewButton, Alignment.TRAILING))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(password)
								.addComponent(account, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(lblNewLabel)))
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(263, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(106))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_2)
					.addContainerGap(333, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_2)
					.addGap(3)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(account, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

}
