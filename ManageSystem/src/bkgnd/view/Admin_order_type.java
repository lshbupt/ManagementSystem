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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bkgnd.DAO.*;
import bkgnd.util.DBUtil;

public class Admin_order_type extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DBUtil dbutil=new DBUtil();
	private OrderType odt =new OrderType();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_order_type frame = new Admin_order_type();
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
	public Admin_order_type() {
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
		
		JLabel lblNewLabel = new JLabel("\u6309\u5546\u54C1\u7C7B\u578B\u67E5\u8BE2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(229, 81, 169, 36);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4E50\u5668"}));
		comboBox.setBounds(213, 151, 69, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u7535\u5B50\u7434", "\u94A2\u7434", "\u67B6\u5B50\u9F13", "\u5409\u4ED6", "\u5C0F\u63D0\u7434"}));
		comboBox_1.setBounds(356, 151, 69, 23);
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 212, 564, 76);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u603B\u9500\u91CF", "\u8BA2\u5355\u6210\u4EA4\u603B\u91D1\u989D"
				}
			);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=comboBox_1.getSelectedItem().toString();
				try {
					Connection conn=dbutil.getCon();
					ResultSet rs = odt.orderT(conn, str);
					model.setRowCount(0);
					while(rs.next()) {
						Vector row = new Vector();
						row.add(rs.getString("SUM(NumberOfGoods)"));
						row.add(rs.getString("SUM(Price*NumberOfGoods)"));
						model.addRow(row);
					}
				}
				catch (Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(274, 404, 86, 36);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
}
