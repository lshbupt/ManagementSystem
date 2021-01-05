package bkgnd.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import bkgnd.DAO.ShopDao;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

public class PasswordChange extends JInternalFrame {
	private JPasswordField old;
	private JTextField newpw;
	private DBUtil dbutil=new DBUtil();
	private ShopDao shopdao=new ShopDao();
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    */
	/**
	 * Create the frame.
	 */
	public PasswordChange(shop Shop) {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("修改密码界面");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("输入旧密码");
		
		old = new JPasswordField();
		
		JLabel lblNewLabel_2 = new JLabel("输入新密码");
		
		newpw = new JPasswordField();
		newpw.setColumns(10);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtil.isEmpty(old.getText())||StringUtil.isEmpty(newpw.getText()))
				{
					JOptionPane.showMessageDialog(null, "新密码或者旧密码不能为空");
				}
				else {
					if(!(old.getText()).equals(Shop.getPassword())) {
					JOptionPane.showMessageDialog(null, "旧密码错误，请重新输入");
					newpw.setText("");
					old.setText("");
					}
					else {
						Connection conn=null;
						try {
							conn=dbutil.getCon();
							shopdao.ChangePassword(conn, Shop, newpw.getText());
							JOptionPane.showMessageDialog(null, "修改成功");
							dispose();
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
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
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(newpw))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(old, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(btnNewButton)))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(old, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(newpw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(37))
		);
		getContentPane().setLayout(groupLayout);

	}
}
