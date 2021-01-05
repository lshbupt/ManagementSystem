package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import bkgnd.util.DBUtil;
import bkgnd.DAO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Connection;

import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class Admin_shop extends JFrame {

	private JPanel contentPane;
	private DBUtil dbutil=new DBUtil();
	private Shop_information shop=new Shop_information();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_shop frame = new Admin_shop();
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
	public Admin_shop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 544);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u5BB6\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(284, 4, 86, 36);
		contentPane.add(lblNewLabel);
		
		/*try {
			Connection conn=dbutil.getCon();
			String result=shop.getShop(conn);
			TextArea textArea = new TextArea(result,0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
			textArea.setFont(new Font("黑体", Font.PLAIN, 12));
			textArea.setBackground(Color.WHITE);
			textArea.setBounds(0, 46, 627, 366);
			textArea.setText(result);
			contentPane.add(textArea);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}*/
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(0, 4, 86, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u5546\u5E97");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_shop_add().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(22, 435, 122, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u5546\u5E97");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_shop_delete().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(178, 435, 116, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_shop_update().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(339, 435, 116, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\u67E5\u8BE2\u5546\u5BB6");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_shop_search().setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3_1.setBounds(494, 435, 116, 45);
		contentPane.add(btnNewButton_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 617, 362);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ShopID", "ShopName", "Account", "TelNo", "Password"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);

		model.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=shop.getShop(conn);
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("ShopID"));
				row.add(rs.getString("ShopName"));
				row.add(rs.getString("Account"));
				row.add(rs.getInt("TelNo"));
				row.add(rs.getString("Password"));
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
