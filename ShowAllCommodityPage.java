package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

//会用到JTable
public class ShowAllCommodityPage extends JFrame {
	JPanel jp1 = new JPanel();
	Vector data = new Vector();
	Vector title = new Vector();
	Connection conn = null;
	Statement stmt = null;
	public ShowAllCommodityPage() {
		JTable jtb1 = null;
		DefaultTableModel defaultModel = null;	
		defaultModel = new DefaultTableModel();
		jtb1 = new JTable( defaultModel );	
		JTableHeader jth1 = jtb1.getTableHeader();
		String url = "jdbc:mysql://localhost:3306/supermarketDB";
		String user = "root";
		String password = "Userjie1119";
		String sql = "SELECT * FROM GOODS";
		try {
			conn = DriverManager.getConnection( url, user, password );
			if( !conn.isClosed() )
				System.out.println( "Successed connecting to DB" );
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				Vector line = new Vector();
				for( int i = 1; i <= 4; i++ ) {
					line.add( rs.getObject(i) );
				}
				data.add(line);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch( SQLException sqle ) {
			System.out.println( "SQLException: " + sqle.getMessage() );
		}
		setLayout( new BorderLayout() );
		jp1.setLayout( new GridLayout( 0, 1 ) );
		title.add( "gid" );
		title.add( "gname" );
		title.add( "gprice" );
		title.add( "gnum" );
		jp1.add( jth1);
		jp1.add( jtb1);
		defaultModel.setDataVector( data, title );
		add( "Center", jp1 );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		pack();
		setVisible( true );
	}
	public static void main( String[] args ) {
		new ShowAllCommodityPage();
	}
}
