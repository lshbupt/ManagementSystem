package bkgnd.view;

import java.awt.Font;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import bkgnd.DAO.OrderDao;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class OrderManagement extends JInternalFrame {
	private JTable table;
    private DBUtil dbutil=new DBUtil();
    private shop Shop;
    private String orderID;
    private JTextField oidtextfield;
    private JTextField ordernum;
    private JTextField totalmoney;
    private int ordercount=0,moneycount=0;
    private String status;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderManagement frame = new OrderManagement();
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
	public OrderManagement(shop Shop) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 899, 600);
		this.Shop=Shop;
		JLabel lblNewLabel = new JLabel("订单总览");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 27));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("修改订单状态");
		
		oidtextfield = new JTextField();
		oidtextfield.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("订单号");
		
		JLabel lblNewLabel_3 = new JLabel("修改状态为");
		
		JComboBox statusBox = new JComboBox();
		statusBox.setModel(new DefaultComboBoxModel(new String[] {"Delivered", "OrderPlaced", "Canceled", "Completed"}));
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtil.isEmpty(oidtextfield.getText())) {
					JOptionPane.showMessageDialog(null, "请选择要修改的订单");
				}
				else {
					Connection conn=null;
					try {
						conn=dbutil.getCon();
						OrderDao.updateOrderStatus(conn, orderID, (String)statusBox.getSelectedItem());
						filltable();
						JOptionPane.showMessageDialog(null, "修改成功");
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						try {
							dbutil.closeConnection(conn);
						} catch (Exception ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					}
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("显示全部订单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filltable();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("时间：");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
		
		JComboBox leftyear = new JComboBox();
		leftyear.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020"}));
		
		JLabel lblNewLabel_5 = new JLabel("年");
		
		JComboBox leftmonth = new JComboBox();
		leftmonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblNewLabel_6 = new JLabel("月");
		
		JComboBox leftday = new JComboBox();
		leftday.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JLabel lblNewLabel_7 = new JLabel("日  ——");
		
		JComboBox rightyear = new JComboBox();
		rightyear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2019", "2018", "2017", "2016", "2015"}));
		
		JLabel lblNewLabel_8 = new JLabel("年");
		
		JComboBox rightmonth = new JComboBox();
		rightmonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblNewLabel_9 = new JLabel("月");
		
		JComboBox rightday = new JComboBox();
		rightday.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JLabel lblNewLabel_10 = new JLabel("日");
		
		JComboBox typebox = new JComboBox();
		typebox.setModel(new DefaultComboBoxModel(new String[] {"-不限-", "钢琴", "电子琴", "吉他", "架子鼓", "小提琴"}));
		JComboBox querystatus = new JComboBox();
		querystatus.setModel(new DefaultComboBoxModel(new String[] {"-不限-", "Delivered", "Canceled", "Completed", "OrderPlaced"}));
		
		JButton btnNewButton_2 = new JButton("筛选");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String leftdate=(String)leftyear.getSelectedItem()+"-"+(String)leftmonth.getSelectedItem()+"-"+(String)leftday.getSelectedItem();
				String rightdate=(String)rightyear.getSelectedItem()+"-"+(String)rightmonth.getSelectedItem()+"-"+(String)rightday.getSelectedItem();
				filltable(leftdate,rightdate,(String)typebox.getSelectedItem(),(String)querystatus.getSelectedItem());
			}
		});
		
		JButton btnNewButton_3 = new JButton("热门榜单");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topgoods tg=new topgoods(Shop);
				tg.setVisible(true);
			}
		});
		
		
		
		JLabel lblNewLabel_11 = new JLabel("类别");
		
		JLabel lblNewLabel_12 = new JLabel("总计");
		
		ordernum = new JTextField();
		ordernum.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("单");
		
		JLabel lblNewLabel_14 = new JLabel("总金额");
		
		totalmoney = new JTextField();
		totalmoney.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("元");
		
		JLabel lblNewLabel_16 = new JLabel("");
		
		JLabel lblNewLabel_17 = new JLabel("订单状态");
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(oidtextfield, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnNewButton)
					.addContainerGap(393, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_12)
						.addComponent(lblNewLabel_14))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ordernum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_13))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(totalmoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_15)))
					.addGap(120))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(316)
											.addComponent(lblNewLabel))
										.addComponent(btnNewButton_3))
									.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_16)
										.addComponent(lblNewLabel_17)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(56)
									.addComponent(lblNewLabel_4)
									.addGap(2)
									.addComponent(leftyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(leftmonth, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_6)
									.addGap(12)
									.addComponent(leftday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_7)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rightyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rightmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rightday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_10)
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addComponent(lblNewLabel_11)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(typebox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(btnNewButton_2))
								.addComponent(querystatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(33))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_3)
								.addComponent(lblNewLabel_16)
								.addComponent(lblNewLabel_17)
								.addComponent(querystatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(rightyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(rightmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(rightday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10)
						.addComponent(btnNewButton_2)
						.addComponent(typebox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_4)
						.addComponent(leftyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(leftmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(leftday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(ordernum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(oidtextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_14)
								.addComponent(totalmoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_15))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				orderID=(String)table.getValueAt(row, 0);
				oidtextfield.setText(orderID);
				/*status=(String)table.getValueAt(row, 10);
				if(status=="Canceled"||status=="Completed") statusBox.setModel(new DefaultComboBoxModel(new String[] {""}));
				else if(status=="OrderPlaced") statusBox.setModel(new DefaultComboBoxModel(new String[] {"Delivered",  "Canceled", "Completed"}));
				else if(status=="Delivered") statusBox.setModel(new DefaultComboBoxModel(new String[] { "Canceled", "Completed"}));
				statusBox.updateUI();*/
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u7528\u6237ID", "\u4E0B\u5355\u65E5\u671F", "\u4E0B\u5355\u65F6\u95F4", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u91D1\u989D", "\u5546\u54C1\u6570\u91CF", "\u603B\u91D1\u989D", "\u5546\u54C1\u5927\u7C7B", "\u5546\u54C1\u5C0F\u7C7B", "\u8BA2\u5355\u72B6\u6001", "\u5B8C\u6210\u65E5\u671F", "\u5B8C\u6210\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false, false, false, false, false, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	public  void filltable() {
		ordercount=0;
		moneycount=0;
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();//��ʼ����ÿ�β�ѯʱ���ܰ��ϴεĲ�ѯ���ˢ�µ�
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=OrderDao.showOrder(conn, Shop);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getDate(3));
				v.add(rs.getTime(4));
				v.add(rs.getString(5));
				v.add(rs.getInt(6));
				v.add(rs.getInt(7));
				v.add(rs.getInt(8));
				v.add(rs.getString(9));
				v.add(rs.getString(10));
				v.add(rs.getString(11));
				v.add(rs.getDate(12));
				v.add(rs.getTime(13));
				dtm.addRow(v);
				ordercount++;
				moneycount+=rs.getInt(8);
			}
			ordernum.setText(ordercount+"");
			totalmoney.setText(moneycount+"");
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
	public  void filltable(String leftdate,String rightdate,String type,String status) {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();//��ʼ����ÿ�β�ѯʱ���ܰ��ϴεĲ�ѯ���ˢ�µ�
		dtm.setRowCount(0);
		Connection conn=null;
		ordercount=0;
		moneycount=0;
		try {
			conn=dbutil.getCon();
			ResultSet rs=OrderDao.showOrder(conn, Shop,leftdate,rightdate,type,status);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getDate(3));
				v.add(rs.getTime(4));
				v.add(rs.getString(5));
				v.add(rs.getInt(6));
				v.add(rs.getInt(7));
				v.add(rs.getInt(8));
				v.add(rs.getString(9));
				v.add(rs.getString(10));
				v.add(rs.getString(11));
				v.add(rs.getDate(12));
				v.add(rs.getTime(13));
				dtm.addRow(v);
				ordercount++;
				moneycount+=rs.getInt(8);
			}
			ordernum.setText(ordercount+"");
			totalmoney.setText(moneycount+"");
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
