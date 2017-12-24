package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SelectCommodityPage extends JFrame implements ActionListener {
	JPanel jp1 = new JPanel();
	JButton jb1 = new JButton( "按商品数量升序查询" );
	JButton jb2 = new JButton( "按商品价格升序查询" );
	JButton jb3 = new JButton( "输入关键字查询" );


	public SelectCommodityPage() {
		setLayout( new GridLayout( 0, 1 ) );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( jb1 );
		jp1.add( jb2 );
		jp1.add( jb3 );
		add( jp1 );

		jb1.addActionListener( this );
		jb2.addActionListener( this );
		jb3.addActionListener( this );
		
		setLocationRelativeTo( null );
		pack();
		setVisible( true );
	}
		@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "按商品数量升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
			} 
			if( srcBtn.getText().equals( "按商品价格升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
			} 
			if( srcBtn.getText().equals( "输入关键字查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
			} 
		}
		else {
			System.out.println( " Not Distinguish Source " );
		}
	}

	public static void main( String[] args ) {
		new SelectCommodityPage();
	}

}
