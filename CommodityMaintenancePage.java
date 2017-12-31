package Interface;

import Interface.ComMaint.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class CommodityMaintenancePage extends JFrame implements ActionListener{
	JPanel p = new JPanel();
	JButton b1 = new JButton( "添加商品" );
	JButton b2 = new JButton( "更改商品" );
	JButton b3 = new JButton( "删除商品" );
	JButton b4 = new JButton( "显示所有商品" );
	JButton b5 = new JButton( "查询商品" );

	JButton b6 = new JButton( "关闭" );

	public CommodityMaintenancePage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new GridLayout( 0, 1 ) );
		p.add( b1 );
		p.add( b2 );
		p.add( b3 );
		p.add( b4 );
		p.add( b5 );
		//p.add( b6 );
	
		b1.addActionListener( this );
		b2.addActionListener( this );
		b3.addActionListener( this );
		b4.addActionListener( this );
		b5.addActionListener( this );
		//b6.addActionListener( this  );
		getContentPane().add( "Center", p );
		setTitle( "商品维护" );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		//setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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
			if( srcBtn.getText().equals( "添加商品" ) ) {
				AddCommodityPage acp = new AddCommodityPage();
				acp.addWindowListener( new java.awt.event.WindowAdapter() {
					public void windowClosing( java.awt.event.WindowEvent e ) {
						acp.dispose();
						System.out.println( "add exit" );
						setVisible( true );
					}
				});
			}
			if( srcBtn.getText().equals( "更改商品" ) ) {
				ChangeCommodityPage ccp = new ChangeCommodityPage();
				ccp.addWindowListener( new java.awt.event.WindowAdapter() {
					public void windowClosing( java.awt.event.WindowEvent e ) {
						ccp.dispose();
						System.out.println( "ccp exit" );
						setVisible( true );
					}
				});
			}
			if( srcBtn.getText().equals( "删除商品" ) ) {
				DeleteCommodityPage dcp = new DeleteCommodityPage();
				dcp.addWindowListener( new java.awt.event.WindowAdapter() {
					public void windowClosing( java.awt.event.WindowEvent e ) {
						dcp.dispose();
						System.out.println( "dcp exit" );
						setVisible( true );
					}
				} );
			} 
			if( srcBtn.getText().equals( "显示所有商品" ) ) {
				ShowAllCommodityPage scap = new ShowAllCommodityPage();
				scap.addWindowListener( new WindowAdapter() {
					public void windowClosing( WindowEvent e ) {
						scap.dispose();
						System.out.println( "scap exit" );
						setVisible( true );
					}
				});
			} 

			if( srcBtn.getText().equals( "查询商品" ) ) {
				SelectCommodityPage secp = new SelectCommodityPage();
				secp.addWindowListener( new java.awt.event.WindowAdapter() {
					public void windowClosing( java.awt.event.WindowEvent e) {
						secp.dispose();
						System.out.println( "scp exit" );
						setVisible( true );
					}
				} );
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
}	
/*
	public static void main(String[] args) {
		CommodityMaintenancePage c = new CommodityMaintenancePage();
		c.setTitle( "商品维护界面" );
		c.pack();
		c.setVisible( true );
		c.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		c.setLocationRelativeTo( null );
	}
*/

/*
class ButtonToAddCom implements ActionListener {
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			System.out.println( "您单击了按钮:" + srcBtn.getText() );
			if( srcBtn.getText().equals( "添加商品" ) ) {
				new AddCommodityPage();
			}
			if( srcBtn.getText().equals( "更改商品" ) ) {
				new ChangeCommodityPage();
			}
			if( srcBtn.getText().equals( "删除商品" ) ) {
				new DeleteCommodityPage();
			} 
			if( srcBtn.getText().equals( "显示所有商品" ) ) {} 
			if( srcBtn.getText().equals( "查询商品" ) ) {} 
			if( srcBtn.getText().equals( "退出" ) ) {
				dispose();
			}
		}	 
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}
}*/
