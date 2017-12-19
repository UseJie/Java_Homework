package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CommodityManagementPage extends JFrame {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "列出当日卖出商品列表" );
	JButton b2 = new JButton( "售货员管理" );
	
	public CommodityManagementPage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new FlowLayout( 1, 5, 5) );
		p.add( b1 );
		p.add( b2 );
		getContentPane().add( "Center", p );
	}

	public static void main(String[] args) {
		CommodityManagementPage c = new CommodityManagementPage();
		c.setTitle( "商品管理" );
		c.pack();
		c.setVisible( true );
		c.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		c.setLocationRelativeTo( null );
	}
}
