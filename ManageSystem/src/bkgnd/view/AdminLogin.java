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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bkgnd.DAO.AdminDao;
import bkgnd.model.Administrator;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JPasswordField password;
    private DBUtil dbutil=new DBUtil();
    private Administrator resultadmin=null;
    private AdminDao admindao=new AdminDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setFont(new Font("黑体", Font.BOLD, 32));
		setTitle("后台管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("管理员登陆界面");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 33));
		
		JLabel lblNewLabel_1 = new JLabel("账户名");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 19));
		
		ID = new JTextField();
		ID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 19));
		
		password = new JPasswordField();
		
		JButton btnNewButton = new JButton("登陆");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminID=ID.getText();
				String Password=new String(password.getPassword());
				if(StringUtil.isEmpty(adminID)||StringUtil.isEmpty(Password))
				{
					JOptionPane.showMessageDialog(null, "密码和用户名不能为空");
				}
				else {
					Administrator admin=new Administrator(adminID,Password);
					Connection conn=null;
					try {
						conn=dbutil.getCon();
						resultadmin=admindao.Login(conn, admin);
						if(resultadmin==null) JOptionPane.showMessageDialog(null, "用户名或者密码错误");
						else {
							dispose();
							new Admin().setVisible(true);
						}
					}
					catch (Exception ex) {
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
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 34));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID.setText("");
				password.setText("");
			}
		});
		
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 34));
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 31));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(196))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(190)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addComponent(ID, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_2)
					.addContainerGap(629, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(107))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
}
