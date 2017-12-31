package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;

public class DeleteCommodityPage extends JFrame implements ActionListener {
	JPanel jp1 = new JPanel();
	JLabel j1 = new JLabel( "输入删除商品名称" );
	JTextField jt1 = new JTextField();

	/*JPanel jp2 = new JPanel();
	JLabel j2 = new JLabel( "商品名称" );
	JTextField jt2 = new JTextField();
	JLabel j3 = new JLabel( "商品价格" );
	JTextField jt3 = new JTextField();
	JLabel j4 = new JLabel( "商品数量" );
	JTextField jt4 = new JTextField();
	*/
	JPanel jp3 = new JPanel();
	JButton jb1 = new JButton( "确定" ); 
	//JButton jb2 = new JButton( "取消" ); 
	public DeleteCommodityPage() {
		setLayout( new BorderLayout( ) );
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( j1 );
		jp1.add( jt1 );
		getContentPane().add( "North", jp1 );
		jt1.addActionListener( this );
	/*		
		jp2.setLayout( new GridLayout( 0, 1 ) );
		jp2.add( j2 );
		jp2.add( jt2 );
		jp2.add( j3 );
		jp2.add( jt3 );
		jp2.add( j4 );
		jp2.add( jt4 );
		getContentPane().add( "Center", jp2 );
	*/
		jp3.setLayout( new FlowLayout() );
		jp3.add( jb1 );
		//jp3.add( jb2 );
		getContentPane().add( "South", jp3 );
	
		jb1.addActionListener( this );
		//jb2.addActionListener( this );

		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}

	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JTextField ) {
			JTextField srcText = (JTextField) obj;
			System.out.println( "您输入了:" + srcText.getText() );
			Vector data = new Vector();
			Vector title = new Vector();
			JPanel jp4 = new JPanel( new GridLayout( 0, 1 ) );
			JTable jtb1 = null;
			DefaultTableModel defaultModel = null;
			defaultModel = new DefaultTableModel();
			jtb1 = new JTable(defaultModel);
			JTableHeader jth1 = jtb1.getTableHeader();
			title.add( "gid" );
			title.add( "gname" );
			title.add( "gprice" );
			title.add( "gnum" );
			System.out.println( "你输入了:" + jt1.getText().toString() );
			data = prepareQueryDataForGname( jt1.getText().toString() );
			jp4.add( jth1 );
			jp4.add( jtb1 );
			defaultModel.setDataVector( data, title );
			add( "Center", jp4);
			pack();
		}
		else if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "确定" ) ) {
				//实现从数据库中删除
				if( jt1.getText()!=null && !jt1.getText().equals("") && !jt1.getText().equals( "请输入要删除商品名称") && jt1.getText()!="请输入要删除商品名称" )  {
					//有全部输入	
					boolean returnValues;
					returnValues = prepareQueryForDelete( jt1.getText().toString() );
					System.out.println("delete success");
				}
				else {
					//没有全部输入
					System.out.println("pleases input add messages");
					jt1.setText( "请输入要删除商品名称" );
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me) {
							jt1.setText(null);
						}
					} );
				}
				System.out.println( "您单击了按钮\"确定\"" );
			} 
			/*if( srcBtn.getText().equals( "取消" ) ) {
				//实现推出单前界面
				System.out.println( "您单击了按钮\"取消\"" );
				this.dispose();
			}
			*/
		}
		else {
			System.out.println( "Not Distinguisg Source" );
		}
	}

	public static Vector prepareQueryDataForGname( String gname ) {
		Connection conn = null;
		Vector data = new Vector();
		PreparedStatement pst = null;
		try {
			System.out.println( "Begin Connecting to DB" );
			String url = "jdbc:mysql://localhost:3306/supermarketDB";
			String user = "root";
			String password = "Userjie1119";
			conn = DriverManager.getConnection( url, user, password );
			if( !conn.isClosed() ) 
				System.out.println( "Successed connecting to DB" );
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM GOODS WHERE gname=?";
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			pst.setString( 1, gname );
			ResultSet rs = pst.executeQuery();
			while( rs.next() ) {
				Vector line = new Vector();
				for( int i = 1; i <= 4; i++ ) {
					line.add( rs.getObject(i) );
				}
				data.add( line );
			} 
			rs.close();
			stmt.close();
			pst.close();
			conn.close();
			return data;
		}catch( SQLException es ) {
			System.out.println( "SQLException: " + es.getMessage() );
			return null;
		}catch( Exception e ) {
			System.out.println( "Exception: " + e.getMessage() );
			return null;
		}finally{
			System.out.println( "Bye" );
		}
	}	
	public static boolean prepareQueryForDelete( String dname ) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean returnValues;
		try {
			System.out.println( "Begin Connecting to DB" );
			String url = "jdbc:mysql://localhost:3306/supermarketDB";
			String user = "root";
			String password = "Userjie1119";
			conn = DriverManager.getConnection( url, user, password );
			if( !conn.isClosed() )
				System.out.println( "Successed connectiong to DB" );
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM GOODS WHERE gname=?";
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			pst.setString(1, dname);
			int rs = pst.executeUpdate();
			if( rs > 0 ) {
				System.out.println( "Delete successed" );
				return true;
			}
			pst.close();
			stmt.close();
			conn.close();
			return false;
		}catch( SQLException es ) {
			System.out.println( "SQLException: " + es.getMessage() );
			return false;
		}catch( Exception e) {
			System.out.println( "Exception: " + e.getMessage() );
			return false;
		}
	}
	public static void main( String[] args ) {
		new DeleteCommodityPage();
	}
}
