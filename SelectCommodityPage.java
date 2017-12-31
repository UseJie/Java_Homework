package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.sql.*;

public class SelectCommodityPage extends JFrame implements ActionListener {
	JPanel jp1 = new JPanel();
	JButton jb1 = new JButton( "按商品数量升序查询" );
	JButton jb2 = new JButton( "按商品价格升序查询" );
	JButton jb3 = new JButton( "输入关键字查询" );


	public SelectCommodityPage() {
		setLayout( new GridLayout( 0, 1 ) );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( jb1 );
		jp1.add( jb2 );
		jp1.add( jb3 );
		add( jp1 );

		JPanel jp2 = new JPanel();
		JTable jtb1 = null;
		DefaultTableModel defaultModel = null;
		defultModel = new DefaultTableModel();
		jtb1 = new JTable( defaultModel );
		JTableHeader jth1 = jtb1.getTableHeader();	
		
		jp2.setLayout( new GridLayout( 0, 1) );
		jp2.add( jth1 );
		jp2.add( jtb1 );
		
		Vector data = new Vector();
		Vector title = new Vector();
		
		String sqe;
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
	public static Vector prepareQueryData( String sqe ) {
		Connection conn = null;
		Vector data = new Vector();
		PreparedStatement pst = null;
		try {
			System.out.println( "Begin Connecting to DB" );
			String url = "jdbc:mysql://localhost:3306/supermarketDB";
			String user  = "root";
			String password = "Userjie1119";
			String sql = "SELECT * FROM GOODS ORDER BY ? ASC";
			
			conn = DriverManager.getConnection( url, user, password );
			Statement stmt = conn.createStatement();
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			pst.setString(1, sqe);
			ResuletSet rs = pst.executeQuery();
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
		@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "按商品数量升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
				data.removeAllElement();
				sqe = "gnum";
				data = prepareQueryData( sqe );
				defaultModel.setDataVector( data, title );
				pack();
			} 
			if( srcBtn.getText().equals( "按商品价格升序查询" ) ) {
				System.out.println( "单击了" + srcBtn.getText() );
				data.removeAllElement();
				sqe = "gprice";
				data = prepareQueryData( sqe );
				defaultModel.setDataVector( data, title );
				pack();
			} 
			if( srcBtn.getText().equals( "输入关键字查询" ) ) {
				try {
					System.out.println( "单击了" + srcBtn.getText() );
					data.removeAllElement();
					Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/supermarketDB", "root", "Userjie1119" );
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM GOODS WHERE gname LIKE '%'||?||'%' " );
					
				}
			} 
		}
		else {
			System.out.println( " Not Distinguish Source " );
		}
	}

	public static void main( String[] args ) {
		new SelectCommodityPage();
	}

}
