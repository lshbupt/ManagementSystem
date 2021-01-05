package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bkgnd.DAO.orderByTime;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;

public class Admin_order_shop extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DBUtil dbutil=new DBUtil();
	private orderShop os =new orderShop();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_order_shop frame = new Admin_order_shop();
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
	public Admin_order_shop() {
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
				new Admin_order().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 86, 36);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 312, 573, 83);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u6570\u91CF", "\u9500\u91CF\u603B\u989D\uFF08\u5143\uFF09"
			}
		);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblid = new JLabel("\u6309\u5546\u5BB6ID\u67E5\u8BE2");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setFont(new Font("宋体", Font.PLAIN, 20));
		lblid.setBounds(239, 21, 140, 36);
		contentPane.add(lblid);
		
		JLabel lblid_2 = new JLabel("\u8BF7\u8F93\u5165\u5546\u5BB6ID");
		lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblid_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblid_2.setBounds(10, 216, 140, 36);
		contentPane.add(lblid_2);
		
		textField = new JTextField();
		textField.setBounds(181, 221, 221, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65F6\u95F4\u6BB5");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 84, 165, 26);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		comboBox.setBounds(208, 87, 53, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(302, 87, 40, 23);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_1_1.setBounds(383, 87, 40, 23);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(271, 87, 21, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u6708");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(352, 87, 21, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\u65E5   \u81F3");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(433, 87, 60, 22);
		contentPane.add(lblNewLabel_3_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		comboBox_2.setBounds(208, 137, 53, 23);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u5E74");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(271, 137, 21, 27);
		contentPane.add(lblNewLabel_3_2);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1_2.setBounds(302, 137, 40, 23);
		contentPane.add(comboBox_1_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("\u6708");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(352, 137, 21, 22);
		contentPane.add(lblNewLabel_3_1_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_1_1_1.setBounds(383, 137, 40, 23);
		contentPane.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("\u65E5");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(433, 137, 21, 22);
		contentPane.add(lblNewLabel_3_1_2_1);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year1=Integer.parseInt(comboBox.getSelectedItem().toString());
				int month1=Integer.parseInt(comboBox_1.getSelectedItem().toString());
				int day1=Integer.parseInt(comboBox_1_1.getSelectedItem().toString());
				int year2=Integer.parseInt(comboBox_2.getSelectedItem().toString());
				int month2=Integer.parseInt(comboBox_1_2.getSelectedItem().toString());
				int day2=Integer.parseInt(comboBox_1_1_1.getSelectedItem().toString());
				Date d1 = new Date(year1, month1, day1);
				Date d2 = new Date(year2, month2, day2);
				String str=comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_1_1.getSelectedItem().toString();
				String str1=comboBox_2.getSelectedItem().toString()+"-"+comboBox_1_2.getSelectedItem().toString()+"-"+comboBox_1_1_1.getSelectedItem().toString();
				String shopID = textField.getText();
				if(d1.compareTo(d2)!=-1) {
					JOptionPane.showMessageDialog(null, "请输入正确的时间区间!");
				}
				else {
					if(StringUtil.isEmpty(shopID)) {
						JOptionPane.showMessageDialog(null, "商家ID不能为空！");
					}
					else {
						try {
							Connection conn=dbutil.getCon();
							ResultSet rs = os.getS(conn, str, str1, shopID);
							model.setRowCount(0);
							while(rs.next()) {
								Vector row = new Vector();
								row.add(rs.getString("sum(NumberOfGoods)"));
								row.add(rs.getString("sum(NumberOfGoods*Price)"));
								model.addRow(row);
							}
						}
						catch (Exception ex)
						{
							System.out.println(ex);
						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(270, 437, 86, 36);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
