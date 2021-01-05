package bkgnd.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;
public class Admin_order_count extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private DBUtil dbutil=new DBUtil();
	private OrderCount oc =new OrderCount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_order_count frame = new Admin_order_count();
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
	public Admin_order_count() {
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
				new Admin_order().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 86, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u7684\u5E74\u4EFD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 56, 165, 26);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		comboBox.setBounds(217, 56, 53, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(280, 56, 21, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6309\u9500\u91CF(\u5143)\u663E\u793A");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 109, 165, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u6309\u8BA2\u5355\u6570\u91CF\u663E\u793A");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(10, 280, 165, 26);
		contentPane.add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 132, 591, 126);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6708\u4EFD", "\u9500\u552E\u91CF\uFF08\u5143\uFF09"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 302, 591, 126);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		DefaultTableModel model_1=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u6708\u4EFD", "\u8BA2\u5355\u6570\u91CF"
				}
			);
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String year=comboBox.getSelectedItem().toString();
				model.setRowCount(0);
				model_1.setRowCount(0);
				try {
					Connection conn=dbutil.getCon();
					for(int i=1;i<=12;i++) {
						ResultSet rs = oc.price(conn, year, Integer.toString(i));
						ResultSet rs1 = oc.amount(conn, year, Integer.toString(i));
						Vector row = new Vector();
						Vector row1 = new Vector();
						row.add(i+"月份");
						row1.add(i+"月份");
						if(rs.next()&&rs1.next()) {
							row.add(rs.getString("sum(NumberOfGoods*Price)"));
							row1.add(rs1.getString("sum(NumberOfGoods)"));
						}
						else {
							row.add("0");
							row1.add("0");
						}
						model.addRow(row);
						model_1.addRow(row1);
					}
				}
				catch (Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(272, 446, 86, 36);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
