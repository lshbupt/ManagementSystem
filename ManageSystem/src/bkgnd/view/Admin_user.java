package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bkgnd.util.DBUtil;
import bkgnd.DAO.*;
public class Admin_user extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DBUtil dbutil=new DBUtil();
	private User_information user=new User_information();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_user frame = new Admin_user();
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
	public Admin_user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 21, 86, 36);
		contentPane.add(lblNewLabel);
		
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
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u7528\u6237");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_user_add().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(23, 437, 122, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u7528\u6237");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_user_delete().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(180, 437, 116, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_user_update().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(343, 437, 116, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\u67E5\u8BE2\u7528\u6237");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_user_search().setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3_1.setBounds(495, 437, 116, 45);
		contentPane.add(btnNewButton_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 619, 346);
		contentPane.add(scrollPane);
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"UserID", "Password", "Name", "TelNo", "Account"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		model.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=user.getUser(conn);
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("UserID"));
				row.add(rs.getString("Password"));
				row.add(rs.getString("Name"));
				row.add(rs.getInt("TelNo"));
				row.add(rs.getString("Account"));
				model.addRow(row);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				dbutil.closeConnection(conn);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.setLocationRelativeTo(null);
	}
}
