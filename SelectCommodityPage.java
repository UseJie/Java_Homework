package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;

public class SelectCommodityPage extends JFrame implements ActionListener {
	JPanel jp1 = new JPanel();
	JButton jb1 = new JButton( "按商品数量升序查询" );
	JButton jb2 = new JButton( "按商品价格升序查询" );
	JButton jb3 = new JButton( "输入关键字查询" );
	JPanel jp2 = new JPanel();
    Vector data = new Vector();
	Vector title = new Vector();
	String sql = "SELECT * FROM GOODS ORDER BY gprice ASC";
	JTable jtb1 = null;
	DefaultTableModel defaultModel = null;
	JTextField jt1 = new  JTextField("请输入关键字");


	public SelectCommodityPage() {
		setLayout( new GridLayout( 0, 1 ) );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( jb1 );
		jp1.add( jb2 );
		jp1.add( jb3 );
		add( jp1 );

		defaultModel = new DefaultTableModel();
		jtb1 = new JTable( defaultModel );
		JTableHeader jth1 = jtb1.getTableHeader();	
		
		jp2.setLayout( new GridLayout( 0, 1) );
		jp2.add( jth1 );
		jp2.add( jtb1 );
		
				
		title.add( "gid" );
		title.add( "gname" );
		title.add( "gprice" );
		title.add( "gnum" );
		defaultModel.setDataVector( data, title );
		add( jp2 );

		jb1.addActionListener( this );
		jb2.addActionListener( this );
		jb3.addActionListener( this );
		
		setLocationRelativeTo( null );
		pack();
		setVisible( true );
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "按商品数量升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
				remove(jp2);
				remove(jt1);
				add(jp2);
				data.removeAllElements();
				sql = "SELECT * FROM GOODS ORDER BY gnum ASC";
				data = prepareQueryData( sql );
				defaultModel.setDataVector( data, title );
				pack();
			} 
			if( srcBtn.getText().equals( "按商品价格升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
				remove(jp2);
				remove(jt1);
				add(jp2);
				data.removeAllElements();
				sql = "SELECT * FROM GOODS ORDER BY gprice ASC";
				data = prepareQueryData( sql );
				defaultModel.setDataVector( data, title );
				pack();
			} 
			if( srcBtn.getText().equals( "输入关键字查询" ) ) {
					System.out.println( "单击了" + srcBtn.getText() );
					remove( jp2 );
					add( jt1 );
					add( jp2 );
					data.removeAllElements();
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt1.setText(null);
							jt1.addActionListener( new ActionListener() {
								public void actionPerformed( ActionEvent e ) {
									if( !jt1.getText().equals("") && jt1.getText()!=null
										&& !jt1.getText().equals( "请输入关键字" ) &&
										jt1.getText()!= "请输入关键字") {
											try {
												Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/supermarketDB", "root", "Userjie1119" );
												String sql="SELECT * FROM GOODS WHERE gname LIKE ?"; 
												PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
												String gname = jt1.getText().toString();
												pst.setString(1, "%"+gname+"%");
												System.out.println(jt1.getText().toString());
												ResultSet rs = pst.executeQuery();
												while( rs.next() ) {
													Vector line = new Vector();
													for( int i = 1; i <= 4; i++ ) {
														line.add(rs.getObject(i));
													}
													data.add( line );
												}
												defaultModel.setDataVector( data, title );
												jt1.setText(null);
												pack();
												rs.close();
												pst.close();
												conn.close();
											}catch(SQLException sqle) {
												System.out.println( "SQLException:" + sqle.getMessage() );
											}
									}
									else
										jt1.setText( "请输入关键字" );
								}
									
							});
						}
					});
				pack();
			} 
		}
		else {
			System.out.println( " Not Distinguish Source " );
		}
	}
    public static Vector prepareQueryData( String sql ) {
		Connection conn = null;
		Vector data = new Vector();
		PreparedStatement pst = null;
		try {
			System.out.println( "Begin Connecting to DB" );
			String url = "jdbc:mysql://localhost:3306/supermarketDB";
			String user  = "root";
			String password = "Userjie1119";
			
			conn = DriverManager.getConnection( url, user, password );
			Statement stmt = conn.createStatement();
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			//pst.setString(1, sqe);
			ResultSet rs = pst.executeQuery();
			while( rs.next() ) {
				Vector line = new Vector();
				for( int i = 1; i <= 4; i++ ) {
					line.add( rs.getObject(i) );
				}
				data.add( line );
			}
			rs.close();
			pst.close();
			stmt.close();
			conn.close();	
			return data;
		}catch( SQLException sqle) {
			System.out.println( "SQLException: " + sqle.getMessage() );
			return null;
		}
	}
	public static void main( String[] args ) {
		new SelectCommodityPage();
	}

}
