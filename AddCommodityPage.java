package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddCommodityPage extends JFrame implements ActionListener {

	public JPanel p = new JPanel();
	public JPanel p1 = new JPanel();	

	public JLabel jL1 = new JLabel( "添加商品名称" );
	public JLabel jL2 = new JLabel( "添加商品价格" );
	public JLabel jL3 = new JLabel( "添加商品数量" );

	public JTextField jt1 = new JTextField();
	public JTextField jt2 = new JTextField();
	public JTextField jt3 = new JTextField();

	public JButton b1 = new JButton( "确定" );
	public JButton b2 = new JButton( "重置" );

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
		b1.addActionListener( this );
		b2.addActionListener( this );
		getContentPane().add( "Center", p );
		getContentPane().add( "South", p1 );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "确定" ) ) {
				//将数据添加到数据库
				jt1.setText( null );
				jt2.setText( null );
				jt3.setText( null );			
			}
			if( srcBtn.getText().equals( "重置" ) ) {
				jt1.setText( null );			
				jt2.setText( null );			
				jt3.setText( null );			
			}
		}
	}

	public static void main(String[] args) {
		new AddCommodityPage();
	}
}
