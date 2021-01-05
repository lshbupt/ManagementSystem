package bkgnd.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import bkgnd.DAO.GoodDao;
import bkgnd.DAO.ShopDao;
import bkgnd.model.ShopAndGoods;
import bkgnd.model.shop;
import bkgnd.util.DBUtil;
import bkgnd.util.SGIDUtil;

public class AddSG extends JFrame {
	private JTable table;
	private DBUtil dbutil=new DBUtil();
	private GoodDao gooddao=new GoodDao();
	private ShopDao shopdao=new ShopDao();
	private JTextField goodId;
	private JTextField price;
	private JTextField num;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSG frame = new AddSG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public AddSG(shop Shop) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 341);
		
		JLabel lblNewLabel = new JLabel("可供添加的商品");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 22));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("商品ID");
		
		goodId = new JTextField();
		goodId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("商品单价");
		
		price = new JTextField();
		price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("商品数量");
		
		num = new JTextField();
		num.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(commitGood(goodId.getText(),Integer.valueOf(price.getText()),Integer.valueOf(num.getText()),Shop))
				JOptionPane.showMessageDialog(null, "添加成功");	
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("请输入添加的产品参数");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(goodId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_4)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(464, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(goodId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnNewButton))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5927\u7C7B", "\u5C0F\u7C7B", "\u5546\u54C1\u540D\u79F0", "\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
        fillgoodtable();
	}
	/**
	 * �ύ��ӵ���Ʒ
	 * @param gid
	 * @param price
	 * @param num
	 * @param Shop
	 */
	private  boolean commitGood(String gid,int price,int num,shop Shop) {
		SGIDUtil sgidutil=new SGIDUtil();
	      ShopAndGoods sg=new ShopAndGoods();
	      Connection conn=null;
	      sg.setGoodID(gid);
	      sg.setPrice(price);
	      sg.setRemain(num);
	      sg.setShopID(Shop.getShopID());
	      sg.setSGID(sgidutil.getSGID());
	      try {
	    	  conn=dbutil.getCon();
	    	  shopdao.InsertSG(conn, sg);
	    	  return true;
	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();
	    	  return false;
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
	/**
	 * ����������Ʒ���嵥
	 */
	public  void fillgoodtable() {
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			ResultSet rs=gooddao.TotalGood(conn);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
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
