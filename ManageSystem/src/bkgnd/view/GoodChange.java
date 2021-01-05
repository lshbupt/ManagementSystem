package bkgnd.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bkgnd.DAO.ShopDao;
import bkgnd.util.DBUtil;
import bkgnd.util.StringUtil;

public class GoodChange extends JFrame {
	private DBUtil dbutil=new DBUtil();
	private ShopDao shopdao=new ShopDao();
	private JPanel contentPane;
	private JTextField Newremain;
	private JTextField NewPrice;
    private String SGID;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodChange frame = new GoodChange();
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
	public GoodChange(String SGID) {
		this.SGID=SGID;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("商品数量");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 25));
		
		Newremain = new JTextField();
		Newremain.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("商品单价");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 25));
		
		NewPrice = new JTextField();
		NewPrice.setColumns(10);
		
		JButton CommitButton = new JButton("提交");
		CommitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtil.isEmpty(Newremain.getText())||StringUtil.isEmpty(NewPrice.getText()))
				{
					JOptionPane.showMessageDialog(null, "数据不能为空");
				}
				else {
				int remain=Integer.valueOf(Newremain.getText());
				int price=Integer.valueOf(NewPrice.getText());
				Change(SGID,remain,price);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Newremain, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(NewPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(CommitButton)
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(Newremain)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(NewPrice)
						.addComponent(CommitButton))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void Change(String SGID,int remain,int price) {
		Connection conn=null;
		try {
			conn=dbutil.getCon();
			shopdao.updateSG(conn, SGID, remain, price);
			dispose();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				dbutil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
