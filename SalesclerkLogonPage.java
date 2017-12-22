package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SalesclerkLogonPage extends JFrame implements ActionListener{
	JPanel p = new JPanel();
	JButton b1 = new JButton( "登录" );
	JButton b2 = new JButton( "退出" );

	public SalesclerkLogonPage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new FlowLayout( 1, 5, 5 ) );
		p.add( b1 );
		p.add( b2 );
		b1.addActionListener( this );
		b2.addActionListener( this );
		getContentPane().add( "Center", p );
		setTitle("前台收银登陆" );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true);
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "登陆" ) ) {
				//new 一个登录界面
			}
			if( srcBtn.getText().equals( "退出" ) ) {
				dispose();
			}
		}	
	}
/*
	public static void main(String[] main) {
		SalesclerkLogonPage s = new SalesclerkLogonPage();
		s.setTitle( "前台收银登录" );
		s.pack();
		s.setVisible( true );
		s.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		s.setLocationRelativeTo( null );
	}
*/
}
