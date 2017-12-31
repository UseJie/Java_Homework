package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SalesclerkLogonPage extends JFrame {
	JPanel p = new JPanel();
	JButton b1 = new JButton( "登录" );
	JButton b2 = new JButton( "重置" );

	JPanel p2 = new JPanel();
	JLabel j1 = new JLabel( "请输入用户名" );
	JTextField jt1 = new JTextField();
	JLabel j2 = new JLabel( "请输入密码" );
	//JTextField jt2 = new JTextField(); 
	JPasswordField jpf1 = new JPasswordField(13);

	public SalesclerkLogonPage() {
		setLayout( new GridLayout( 0, 1 ) );
		p.setLayout( new FlowLayout() );
		p.add( b1 );
		p.add( b2 );
		b1.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				char[] s = jpf1.getPassword();
				String jpassword = new String(s);
				System.out.println(jpassword);
			}

		} );
		b2.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				
			}
		} );

		p2.setLayout( new GridLayout( 0, 1 ) );
		p2.add( j1 );
		p2.add( jt1 );
		p2.add( j2 );
		//p2.add( jt2 );
		p2.add( jpf1 );

		//getContentPane().add( p2 );
		//getContentPane().add( p );
		add( p2 );
		add( p );
		setTitle("前台收银登陆" );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true);
	}
	public static void main(String[] main) {
		new SalesclerkLogonPage();
	}
}
