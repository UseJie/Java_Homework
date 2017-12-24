/*
*功能描述：主界面
*显示：
＊		1.商品维护
*		2.前台收银
*		3.商品管理
＊author：userjie.com
*/

package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MainPage {
	public static void main(String[] args) {
		JFrame a = new JFrame( "主界面" );
		Container c = new Container();
		JPanel p = new JPanel();
		
		a.setLocation( 100, 100 );
		a.setLayout( new BorderLayout( 5, 5 ) );//  组件横、纵间距为5个像素
		p.setLayout( new GridLayout( 0, 1 ) );
		JButton b1 = new JButton( "商品维护" );
		JButton b2 = new JButton( "商品管理" );
		JButton b3 = new JButton( "前台收银" );
		p.add( b1 );	
		p.add( b2 );	
		p.add( b3 );	
		
		b1.addActionListener( new ButtonToComMain() );
		b2.addActionListener( new ButtonToComManagement() );
		b3.addActionListener( new ButtonToSales() );

		a.getContentPane().add( "Center", p );
		a.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		a.setLocationRelativeTo( null );
		a.pack();
		a.setVisible( true );
	}
}
	
class ButtonToComMain implements ActionListener {
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			System.out.println( "您单机了按钮:" + srcBtn.getText() );
			CommodityMaintenancePage amtp = new CommodityMaintenancePage();
			amtp.addWindowListener( new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e ) {
					amtp.dispose();
					System.out.println( "ComMaint exit" );
				}	
			});
		}
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}
}	

class ButtonToComManagement implements ActionListener {
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			System.out.println( "您单机了按钮:" + srcBtn.getText() );
			new CommodityManagementPage();
		}
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}
}

class ButtonToSales implements ActionListener {
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			System.out.println( "您单机了按钮:" + srcBtn.getText() );
			SalesclerkLogonPage scl = new SalesclerkLogonPage();
			scl.addWindowListener( new java.awt.event.WindowAdapter() {
				public void windowClosing( java.awt.event.WindowEvent e ) {
					scl.dispose();
				}
			});
		}
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}
}
