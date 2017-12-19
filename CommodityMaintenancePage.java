package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class CommodityMaintenancePage extends JFrame {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "添加商品" );
	JButton b2 = new JButton( "更改商品" );
	JButton b3 = new JButton( "删除商品" );
	JButton b4 = new JButton( "显示所有商品" );
	JButton b5 = new JButton( "查询商品" );

	public CommodityMaintenancePage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new FlowLayout( 1, 5, 5 ) );
		p.add( b1 );
		p.add( b2 );
		p.add( b3 );
		p.add( b4 );
		p.add( b5 );
		getContentPane().add( "Center", p );
	}	
	public static void main(String[] args) {
		CommodityMaintenancePage c = new CommodityMaintenancePage();
		c.setTitle( "商品维护界面" );
		c.pack();
		c.setVisible( true );
		c.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		c.setLocationRelativeTo( null );
	}
}
