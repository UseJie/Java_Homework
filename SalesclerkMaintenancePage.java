package Interface.ComManage;

import Interface.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SalesclerkMaintenancePage extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "添加售货员" );
	JButton b2 = new JButton( "更改售货员" );
	JButton b3 = new JButton( "删除售货员" );
	JButton b4 = new JButton( "显示所有售货员" );

	public SalesclerkMaintenancePage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new GridLayout( 0, 1 ) );
		p.add( b1 );
		p.add( b2 );
		p.add( b3 );
	
		b1.addActionListener( this );
		b2.addActionListener( this );
		b3.addActionListener( this );
		b4.addActionListener( this );
		getContentPane().add( "Center", p );
		setTitle( "售货员管理" );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			setVisible( false );
			JButton srcBtn = (JButton) obj;
			System.out.println( "您单击了按钮:" + srcBtn.getText() );
			if( srcBtn.getText().equals( "添加售货员" ) ) {
				System.out.printf( "添加售货员" );
				AddSalesclerkPage asp = new AddSalesclerkPage();
				asp.addWindowListener( new WindowAdapter() {
					public void windowClosing( WindowEvent e ) {
						asp.dispose();
						System.out.println( "asp exit" );
						setVisible( true );
					}
				});
			}
			if( srcBtn.getText().equals( "更改售货员" ) ) {
				System.out.printf( "更改售货员" );
			}
			if( srcBtn.getText().equals( "删除售货员" ) ) {
				System.out.println( "删除售货员" );
			} 
			if( srcBtn.getText().equals( "显示所有售货员" ) ) {
				System.out.println( "售货员" );
			} 


			//if( srcBtn.getText().equals( "关闭" ) ) {
			//	dispose();
			//}
			//无法将dispose()实现成窗口关闭
		}
	else {
			System.out.println( "Not Distinguish Source" );
		}

	}	

	public static void main( String[] args ) {
		new SalesclerkMaintenancePage();
	}
}
