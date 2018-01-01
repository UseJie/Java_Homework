package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import DB.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;

/*
*三个面板是用来装三种情况，分别是输入商品名、选择修改内容、输入修改
*/
public class ChangeCommodityPage extends JFrame implements ActionListener {

	JPanel p1 = new JPanel();
	JLabel j1 = new JLabel( "输入更改商品名称" );
	JTextField jt1 = new JTextField();
	JPanel jp3 = new JPanel();
	JLabel j5 = new JLabel( "请输入已修改的商品数量" );
	JTextField jt7 = new JTextField();
	
	JPanel jpTotb = new JPanel();
	Vector data = new Vector();
	Vector title = new Vector();

	JPanel jp2 = new JPanel();
	JButton b4 = new JButton( "确定" );
	JButton b5 = new JButton( "重置" );
	
	Connection conn = null;
	PreparedStatement pst = null;
	int rs;
	
	/*JLabel j6 = new JLabel( "商品名称" );
	JLabel j7 = new JLabel( "商品价格" );
	JLabel j8 = new JLabel( "商品数量" );
	JTextField jt8 = new JTextField();
	JTextField jt9 = new JTextField();
	JTextField jt10 = new JTextField();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel j2 = new JLabel( "选择您要修改的内容" );

	JButton jb1 = new JButton( "更改商品名称" );
	JButton jb2 = new JButton( "更改商品价格" );

	JButton jb3 = new JButton( "更改商品数量" );
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();

	JLabel j3 = new JLabel( "请输入已修改的商品名称" );
	JLabel j4 = new JLabel( "请输入已修改的商品价格" );

	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();

	*/

	public ChangeCommodityPage() {
		setSize( 500, 500 );
		setLayout( new GridLayout( 0, 1 ) );
		p1.setLayout( new GridLayout( 0, 1 ) );
		p1.add(j1);
		p1.add(jt1);
		

		
		JTable jtb1 = null;
		DefaultTableModel defaultModel = new DefaultTableModel();
		jtb1 = new JTable( defaultModel );
		JTableHeader jth1 = jtb1.getTableHeader();
		jpTotb.setLayout( new GridLayout( 0, 1) );
		title.add( "gid" );
		title.add( "gname" );
		title.add( "gprice");
		title.add( "gnum");
		jpTotb.add(jth1);
		jpTotb.add(jtb1);
		defaultModel.setDataVector( data, title );
		
		jp2.setLayout( new FlowLayout(0) );
		jp2.add( b4 );
		jp2.add( b5 );
		
		jp3.setLayout( new GridLayout( 0, 1 ) );
		jp3.add(j5);
		jp3.add(jt7);
		
		/*
		 * jt1
		 * */
		jt1.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				conn = DbConn.getconn();
				try {
					String sql = "SELECT * FROM GOODS WHERE gname=?";
					pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
					pst.setString(1, jt1.getText().toString());
					ResultSet rs = pst.executeQuery();
					while ( rs.next() ) {
						data.removeAllElements();
						defaultModel.setDataVector( data, title);
						Vector line = new Vector();
						for( int i = 1; i <= 4; i++ ) {
							line.add(rs.getObject(i));
						}
						data.add(line);
						defaultModel.setDataVector( data , title);
						jt7.setText(null);
					}
				}catch( SQLException sqle) {
					System.out.println( "SQLException: " +sqle.getMessage() );
				}finally {
					DbClose.addClose( pst,conn );
				}
			}
		});
		
		
		b4.addActionListener( this );
		add(p1);
		add(jpTotb);
		add(jp3);
		add(jp2);
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo(null);
		setVisible( true );
	}
	
	
	/*
	 *  确定按钮 b4
	 *  1. 赶时间 不做那么多判断
	 * */
	@Override
	public void actionPerformed( ActionEvent e ) {
		conn = DbConn.getconn();
		try {
			String sql = "UPDATE GOODS SET gnum=? WHERE gname=?";
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			pst.setInt(1, Integer.parseInt(jt7.getText()));
			pst.setString(2, jt1.getText().toString());
			rs = pst.executeUpdate();
			if ( rs > 0) {
				jt1.setText("Success");
				jt7.setText(null);
			}
			else {
				jt1.setText("fauild");
				jt7.setText(null);
			}
		}catch( SQLException sqle) {
			System.out.println( "SQLException: " +sqle.getMessage() );
		}finally {
			DbClose.addClose( pst,conn );
		}
	}

	public static void main(String[] args) {
		new ChangeCommodityPage();
	}
}

//class TextFieldToShow implements ActionListener {
//}
