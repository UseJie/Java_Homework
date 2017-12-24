package Interface;

import Interface.ComManage.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CommodityManagementPage extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "列出当日卖出商品列表" );
	JButton b2 = new JButton( "售货员管理" );
	
	public CommodityManagementPage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new FlowLayout( 1, 5, 5) );
		p.add( b1 );
		p.add( b2 );

		b1.addActionListener( this );
		b2.addActionListener( this );

		getContentPane().add( "Center", p );
		setTitle( "商品管理" );
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
			if( srcBtn.getText().equals( "列出当日卖出商品列表" ) ) {
				System.out.println( "列出当如卖出商品列表" );
			}
			if( srcBtn.getText().equals( "售货员管理" ) ) {
				SalesclerkMaintenancePage smp = new SalesclerkMaintenancePage();
				setVisible( false );
				smp.addWindowListener( new WindowAdapter(){
					public void windowClosing( WindowEvent e ) {
						smp.dispose();
						System.out.println( "smp exit" );
						setVisible( true );
						
					}
				});
			}
		}
	}

	public static void main(String[] args) {
		new CommodityManagementPage();
	}

}
