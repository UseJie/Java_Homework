package Interface.ComManage;

import Interface.ComMaint.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddSalesclerkPage extends AddCommodityPage {
	
	public AddSalesclerkPage() {
		super();
		jL1.setText( "添加售货员姓名" );
		jL2.setText( "添加售货员密码" );
		setVisible( true );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		p.remove( jL3 );
		p.remove( jt3 );
	}
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "确定" ) ) {
				System.out.println( "添加售货员到售货员表" );
				jt1.setText( null );
				jt2.setText( null );
				jt3.setText( null );
			}
			if( srcBtn.getText().equals( "重置" ) ) {
				System.out.println( "重新输入" );
				System.out.println( "添加售货员到售货员表" );
				jt1.setText( null );
				jt2.setText( null );
				jt3.setText( null );
			} 
		}
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}
	public static void main( String[] args ) {
		new AddSalesclerkPage();
	}
}
