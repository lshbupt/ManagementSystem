package bkgnd.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import bkgnd.model.shop;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;

public class ShopMain extends JFrame {
    /* private shop Shop;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMain frame = new ShopMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	JDesktopPane desktopPane ;
	/**
	 * Create the frame.
	 */
	public ShopMain(shop Shop) {
		setFont(new Font("黑体", Font.BOLD, 27));
		this.setTitle(Shop.getShopname());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 737);
		desktopPane = new JDesktopPane();
		JButton btnNewButton = new JButton("商品管理");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsManagement gm=new GoodsManagement(Shop);
				gm.filltable("");
				gm.setVisible(true);
				desktopPane.add(gm);
			}
		});
		
		JButton btnNewButton_1 = new JButton("订单管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderManagement om=new OrderManagement(Shop);
				om.filltable();
				om.setVisible(true);
				desktopPane.add(om);
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 24));
		
		JButton btnNewButton_2 = new JButton("修改密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange pc=new PasswordChange(Shop);
				pc.setVisible(true);
				desktopPane.add(pc);
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.BOLD, 24));
		
		JButton btnNewButton_3 = new JButton("安全退出");
		btnNewButton_3.setFont(new Font("黑体", Font.BOLD, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu().setVisible(true);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocationRelativeTo(null);
	}
}
