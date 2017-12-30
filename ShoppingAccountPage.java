package Interface.SLogon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class ShoppingAccountPage extends JFrame {
	JPanel jp1 = new JPanel();
	JLabel j1 = new JLabel( "请输入商品名" );
	JTextField jt1 = new JTextField();

	JPanel jp2 = new JPanel();
	JLabel j2 = new JLabel( "请输入数量" );
	JTextField jt2 = new JTextField();

	JPanel jp3 = new JPanel();
	JLabel j3 = new JLabel( "总计" );
	JTextField jt3 = new JTextField();

	JPanel jp4 = new JPanel();
	JLabel j4 = new JLabel( "收款" );
	JTextField jt4 = new JTextField();

	JPanel jp5 = new JPanel();
	JLabel j5 = new JLabel( "找零" );
	JTextField jt5 = new JTextField();

	Object[][] rowData = {
							 { "apple", 5, 10 },
							 { "banana", 2, 20 },
							};
	String[] columnNames = { "商品名称", "商品价格", "商品数量" };

	JTable jtb1 = new JTable( rowData, columnNames );

	public ShoppingAccountPage() {
		setLayout( new GridLayout( 0, 1 ) );

		jtb1.setPreferredScrollableViewportSize( new Dimension( 500, 300 ));
		jtb1.setAutoResizeMode( JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS );
		TableColumn column = null;
		for( int i =0; i < 2; i++ ) {
			column = jtb1.getColumnModel().getColumn(i);
			if( ( i%2 ) == 0 )
				column.setPreferredWidth( 150 );
			else
				column.setPreferredWidth( 50 );
		}
		JScrollPane scrollPane = new JScrollPane( jtb1 );
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( j1 );
		jp1.add( jt1 );
	
		//jt1.addActionListener();

		jp2.setLayout( new GridLayout( 0, 1 ) );
		jp2.add( j2 );
		jp2.add( jt2 );

		jp3.setLayout( new GridLayout( 0, 1 ) );
		jp3.add( j3 );
		jp3.add( jt3 );

		jp4.setLayout( new GridLayout( 0, 1 ) );
		jp4.add( j4 );
		jp4.add( jt4 );

		jp5.setLayout( new GridLayout( 0, 1 ) );
		jp5.add( j5 );
		jp5.add( jt5 );
	
		add( jp1 );
		add( scrollPane );
		add( jp2 );
		add( jp3 );
		add( jp4 );
		add( jp5 );


		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		pack();
		show();
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		});
	}

	public static void main(String[] args) {
		new ShoppingAccountPage();
	}
}
