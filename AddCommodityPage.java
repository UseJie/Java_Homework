package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddCommodityPage extends JFrame {
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();	

	JLabel jL1 = new JLabel( "添加商品名称" );
	JLabel jL2 = new JLabel( "添加商品价格" );
	JLabel jL3 = new JLabel( "添加商品数量" );

	JTextField jt1 = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();

	JButton b1 = new JButton( "确定" );
	JButton b2 = new JButton( "取消" );

	public AddCommodityPage() {
		setLayout( new BorderLayout() );
		p.setLayout( new GridLayout( 0, 1 ) );
		p1.setLayout( new FlowLayout() );
		p.add( jL1 );
		p.add( jt1 );
		p.add( jL2 );
		p.add( jt2 );
		p.add( jL3 );
		p.add( jt3 );
		p1.add( b1 );
		p1.add( b2 );
		getContentPane().add( "Center", p );
		getContentPane().add( "South", p1 );
		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}
	public static void main(String[] args) {
		new AddCommodityPage();
	}
}
