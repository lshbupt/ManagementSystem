package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;
import bkgnd.DAO.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Admin_user_search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private DBUtil dbutil=new DBUtil();
	private SearchUser suser=new SearchUser();
	private JTable table;
	int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_user_search frame = new Admin_user_search();
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
	public Admin_user_search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 543);
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
		btnNewButton.setBounds(10, 10, 86, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblid = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u7684\u7528\u6237ID");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setFont(new Font("宋体", Font.PLAIN, 20));
		lblid.setBounds(38, 137, 217, 36);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(279, 142, 252, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 196, 618, 102);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
				"UserID", "Password", "Name", "TelNo", "Account"
			}
		);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_id=textField.getText();
				if(StringUtil.isEmpty(user_id)) {
					JOptionPane.showMessageDialog(null, "用户ID不能为空！");
				}
				else {
					try {
						Connection conn=dbutil.getCon();
						ResultSet rs = suser.SUser(conn, user_id);
						if (rs.next()) {
							if(count>0) {
								model.removeRow(0);
							}
							Vector row = new Vector();
							row.add(rs.getString("UserID"));
							row.add(rs.getString("Password"));
							row.add(rs.getString("Name"));
							row.add(rs.getInt("TelNo"));
							row.add(rs.getString("Account"));
							model.addRow(row);
							count++;
						}
						else {
						    JOptionPane.showMessageDialog(null, "未查询到该用户的相关信息");
						}
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
					textField.setText("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(249, 391, 114, 34);
		contentPane.add(btnNewButton_1);
		
		this.setLocationRelativeTo(null);
	}
}
