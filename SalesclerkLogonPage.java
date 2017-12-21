package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SalesclerkLogonPage extends JFrame {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "登录" );
	JButton b2 = new JButton( "退出" );

	public SalesclerkLogonPage() {
		setLayout( new BorderLayout( 5, 5 ) );
		p.setLayout( new FlowLayout( 1, 5, 5 ) );
		p.add( b1 );
		p.add( b2 );
		getContentPane().add( "Center", p );
		setTitle("前台收银登陆" );
		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true);
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
