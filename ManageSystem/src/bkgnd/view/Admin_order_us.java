package bkgnd.view;

import java.awt.BorderLayout;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Admin_order_us extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private DBUtil dbutil=new DBUtil();
	private ShopAndUser sau =new ShopAndUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_order_us frame = new Admin_order_us();
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
	public Admin_order_us() {
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
		
		JLabel lblNewLabel = new JLabel("\u8BE5\u65F6\u95F4\u5185\u9500\u91CF\u6392\u540D\u524D\u5341\u7684\u5546\u5BB6");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 145, 269, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BE5\u65F6\u95F4\u5185\u6210\u529F\u4E0B\u5355\u91D1\u989D\u524D\u5341\u7684\u7528\u6237");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 300, 307, 36);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 618, 115);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u5546\u5BB6\u540D\u79F0", "\u9500\u552E\u603B\u91CF\uFF08\u5143\uFF09"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 331, 618, 115);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		DefaultTableModel model1 = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7528\u6237\u540D", "\u4E0B\u5355\u91D1\u989D\uFF08\u5143\uFF09"
				}
			);
		table_1.setModel(model1);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65F6\u95F4\u6BB5");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 50, 165, 26);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		comboBox.setBounds(211, 53, 53, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(295, 53, 40, 23);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_1_1.setBounds(374, 53, 40, 23);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(267, 57, 21, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u6708");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(343, 54, 21, 22);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\u65E5   \u81F3");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(424, 53, 60, 22);
		contentPane.add(lblNewLabel_3_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		comboBox_2.setBounds(211, 86, 53, 23);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u5E74");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(267, 90, 21, 15);
		contentPane.add(lblNewLabel_3_2);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1_2.setBounds(295, 86, 40, 23);
		contentPane.add(comboBox_1_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("\u6708");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(343, 86, 21, 22);
		contentPane.add(lblNewLabel_3_1_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_1_1_1.setBounds(374, 86, 40, 23);
		contentPane.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("\u65E5");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(424, 85, 21, 22);
		
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
				if(d1.compareTo(d2)!=-1) {
					JOptionPane.showMessageDialog(null, "请输入正确的时间区间!");
				}
				else {
					try {
						Connection conn=dbutil.getCon();
						ResultSet rs = sau.Shop_10(conn, str, str1);
						ResultSet rs1 = sau.User_10(conn, str, str1);
						model.setRowCount(0);
					    model1.setRowCount(0);
						while(rs.next()) {
							Vector row = new Vector();
							row.add(rs.getString("ShopName"));
							row.add(rs.getString("Sum(NumberOfGoods)"));
							model.addRow(row);
						}
						while(rs1.next()) {
							Vector row = new Vector();
							row.add(rs1.getString("Name"));
							row.add(rs1.getString("sum(NumberOfGoods*Price)"));
							model1.addRow(row);
						}
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(267, 456, 86, 36);
		contentPane.add(btnNewButton_1);
		contentPane.add(lblNewLabel_3_1_2_1);
		this.setLocationRelativeTo(null);
	}

}
