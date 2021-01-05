package bkgnd.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bkgnd.DAO.OrderDao;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class topgoods extends JFrame {

	private JPanel contentPane;
    private shop Shop;
    private JTable table;
    private DBUtil dbutil=new DBUtil();
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					topgoods frame = new topgoods();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public topgoods(shop Shop) {
		this.Shop=Shop;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("热门商品榜单");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("请选择时间段");
		
		JComboBox leftyear = new JComboBox();
		leftyear.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020"}));
		
		JLabel lblNewLabel_2 = new JLabel("年");
		
		JComboBox leftmonth = new JComboBox();
		leftmonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblNewLabel_3 = new JLabel("月");
		
		JComboBox leftday = new JComboBox();
		leftday.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JLabel lblNewLabel_4 = new JLabel("日");
		
		JLabel lblNewLabel_5 = new JLabel("至");
		
		JLabel lblNewLabel_6 = new JLabel("年");
		
		JComboBox rightmonth = new JComboBox();
		rightmonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblNewLabel_7 = new JLabel("月");
		
		JComboBox rightday = new JComboBox();
		rightday.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JLabel lblNewLabel_8 = new JLabel("日");
		
		JComboBox rightyear = new JComboBox();
		rightyear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015"}));
		
		JButton commit = new JButton("提交");
		commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String leftdate=(String)leftyear.getSelectedItem()+"-"+(String)leftmonth.getSelectedItem()+"-"+(String)leftday.getSelectedItem();
				String rightdate=(String)rightyear.getSelectedItem()+"-"+(String)rightmonth.getSelectedItem()+"-"+(String)rightday.getSelectedItem();
				filltable(leftdate,rightdate);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(198)
					.addComponent(lblNewLabel)
					.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rightyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rightmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(leftyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_2))
										.addComponent(lblNewLabel_1))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5)
										.addComponent(leftmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(leftday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_7)
									.addGap(18)
									.addComponent(rightday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_4))
								.addComponent(lblNewLabel_8)))
						.addComponent(commit))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(leftyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(leftmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(leftday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
							.addGap(32)
							.addComponent(lblNewLabel_5)
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(rightday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8)
								.addComponent(rightyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6)
								.addComponent(rightmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(commit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u540D\u79F0", "\u9500\u552E\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	public  void filltable(String leftdate,String rightdate) {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();//��ʼ����ÿ�β�ѯʱ���ܰ��ϴεĲ�ѯ���ˢ�µ�
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=OrderDao.topgoods(conn, Shop,leftdate,rightdate);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getInt(2));
				dtm.addRow(v);
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
	}
}
