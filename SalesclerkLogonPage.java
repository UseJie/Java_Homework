package Interface;

import Interface.SLogon.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;
import DB.*;
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
				if( jt1.getText().equals("") || jpassword.equals("") 
					|| jt1.getText().equals("请输入完整信息")) {
					jt1.setText( "请输入完整信息" );
					jpf1.setText("");
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt1.setText(null);
						}
					});
				}
				else {
					Connection conn = null;
					PreparedStatement pst = null;
					ResultSet rs = null;
					String url = "jdbc:mysql://localhost:3306/supermarketDB";
					String user = "root";
					String password = "Userjie1119";
					try {
						conn = DriverManager.getConnection( url, user, password );
						String sql = "SELECT * FROM salesman WHERE sname=?";
						pst = conn.prepareStatement( sql );
						pst.setString( 1, jt1.getText().toString() );
						rs = pst.executeQuery();
						if( rs.next() ) {
							String pwd = rs.getString( "spassword" );
							if( jpassword.equals(pwd) ) {
								jt1.setText("密码正确");
								setVisible(false);
								jt1.addMouseListener( new MouseAdapter() {
									public void mouseClicked( MouseEvent me ) {
										jt1.setText(null);
									}
								});
								ShoppingAccountPage sap = new ShoppingAccountPage();
								jpf1.setText(null);
								sap.addWindowListener( new WindowAdapter() {
									public void widowClosing( WindowEvent we ) {
										sap.dispose();
										setVisible(true);
									}
								});
							}
							else {
								//密码错误
								jt1.setText( "密码错误" );
								jt1.addMouseListener( new MouseAdapter() {
									public void mouseClicked( MouseEvent me ) {
										jt1.setText(null);
									}
								});
							}
						}
						rs.close();
						pst.close();
						conn.close();
					}catch( SQLException sqle ) {
						sqle.printStackTrace();
					}finally {

					}
				}
			}

		} );
		b2.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				jt1.setText(null);
				jpf1.setText(null);
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
