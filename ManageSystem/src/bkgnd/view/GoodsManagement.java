package bkgnd.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import bkgnd.DAO.ShopDao;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;
/**
 * �̼ҹ����Լҵ���Ʒ
 * @author lsh18
 *
 */
public class GoodsManagement extends JInternalFrame {
	private JTable mygoodtable;
	private JTextField goodname;
	private shop myShop;
	private String SGID=null;
	private DBUtil dbutil=new DBUtil();
	private ShopDao shopdao=new ShopDao();
	private JButton deletebutton,Changebutton;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsManagement frame = new GoodsManagement();
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
	public GoodsManagement(shop Shop) {
		myShop=Shop;
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 747, 420);
		
		JLabel Shopname = new JLabel(Shop.getShopname());
		Shopname.setFont(new Font("黑体", Font.BOLD, 31));
		
		JScrollPane scrollPane = new JScrollPane();
		
		goodname = new JTextField();
		goodname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("输入商品名称");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 17));
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Goodname=goodname.getText();
				filltable(Goodname);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("添加商品");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddSG asg=new AddSG(Shop);
				asg.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 24));
		
		deletebutton = new JButton("删除");
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				try {
					conn=dbutil.getCon();
					shopdao.deleteSG(conn, SGID);
					JOptionPane.showMessageDialog(null, "删除成功！！");
					filltable("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		});
		deletebutton.setEnabled(false);
		deletebutton.setFont(new Font("黑体", Font.BOLD, 24));
		
		Changebutton = new JButton("修改");
		Changebutton.setEnabled(false);
		Changebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mygoodtable.getSelectedRow()!=-1) {
				GoodChange gc=new GoodChange(SGID);
				gc.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "请选择你要修改的商品");
				}
			}
		});
		Changebutton.setFont(new Font("黑体", Font.BOLD, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(313)
					.addComponent(Shopname)
					.addContainerGap(274, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(goodname, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnNewButton)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(152)
							.addComponent(Changebutton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(deletebutton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(Shopname)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(goodname, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton)))
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(deletebutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Changebutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(57))
		);
		
		mygoodtable = new JTable();
		mygoodtable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row=mygoodtable.getSelectedRow();
				SGID=(String)mygoodtable.getValueAt(row, 0);
				deletebutton.setEnabled(true);
				Changebutton.setEnabled(true);
			}
		});
		
		mygoodtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SGID", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u5355\u4EF7", "\u5269\u4F59\u6570\u91CF", "\u5546\u54C1\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(mygoodtable);
		getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * �����ѯ����Ϊĳ����Ʒ������
	 * @param goodname
	 */
	public  void filltable(String goodname) {
		DefaultTableModel dtm=(DefaultTableModel) mygoodtable.getModel();//��ʼ����ÿ�β�ѯʱ���ܰ��ϴεĲ�ѯ���ˢ�µ�
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=shopdao.Goodslist(conn, myShop, goodname);//���̵��id����Ʒ������Ϊ��������
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getInt(3));
				v.add(rs.getInt(4));
				v.add(rs.getString(5));
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
