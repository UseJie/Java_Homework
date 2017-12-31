package Interface.SLogon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
import DB.*;

public class ShoppingAccountPage extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JLabel j1 = new JLabel( "请输入商品名" );
	JTextField jt1 = new JTextField();

	JPanel jp2 = new JPanel();
	JLabel j2 = new JLabel( "请输入数量" );
	JTextField jt2 = new JTextField();

	JPanel jp3 = new JPanel();
	JLabel j3 = new JLabel( "总计" );
	JTextField jt3 = new JTextField();

	JPanel jp4 = new JPanel();
	JLabel j4 = new JLabel( "收款" );
	JTextField jt4 = new JTextField();

	JPanel jp5 = new JPanel();
	JLabel j5 = new JLabel( "找零" );
	JTextField jt5 = new JTextField();
	
	Vector data = new Vector();
	Vector title = new Vector();
	DefaultTableModel defaultModel = null;

	Connection conn = DbConn.getconn();
	PreparedStatement pst = null;
	ResultSet rs = null;
	String gname;
	public ShoppingAccountPage() {
		setLayout( new GridLayout( 0, 1 ) );

		
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( j1 );
		jp1.add( jt1 );
		

		JPanel jpTotb = new JPanel( new GridLayout( 0, 1 ) );
		JTable jtb1 = null;
		defaultModel = new DefaultTableModel();
		jtb1 = new JTable( defaultModel );
		JTableHeader jth1 = jtb1.getTableHeader();
		title.add( "gid" );
		title.add( "gname" );
		title.add( "gprice" );
		title.add( "gnum" );
		jpTotb.add( jth1 );
		jpTotb.add( jtb1 );
		defaultModel.setDataVector(data, title);
		
		jt1.addActionListener( this );

		
		jp2.setLayout( new GridLayout( 0, 1 ) );
		jp2.add( j2 );
		jp2.add( jt2 );
		
		/*Jt2.addActionListener:
		* 1. 没有输入商品名/输入名称不对:提示请输入正确商品名
		* 2. 数量超过库存,重新输入
		* 3. 更新数据库中的数量
		*/
		jt2.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				if( data.size() > 0 ) {
					Integer dataNum = Integer.parseInt(data.get(3).toString());
					Integer jtNum = Integer.parseInt(jt2.getText());
					if( dataNum >= jtNum && jtNum >= 0 ) {
						System.out.println( dataNum + " "+ jtNum );
						//更新数据中的数量
					}
					else {
						jt2.setText("请输入正确的数量");
						jt2.addMouseListener( new MouseAdapter() {
							public void mouseClicked( MouseEvent me ) {
								jt2.setText(null);
							}
						});
					}
				}
				else {
					jt1.setText("请输入正确的商品名");
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt1.setText(null);
						}
					});
				}
			}
		});
		
		jp3.setLayout( new GridLayout( 0, 1 ) );
		jp3.add( j3 );
		jp3.add( jt3 );

		jp4.setLayout( new GridLayout( 0, 1 ) );
		jp4.add( j4 );
		jp4.add( jt4 );

		jp5.setLayout( new GridLayout( 0, 1 ) );
		jp5.add( j5 );
		jp5.add( jt5 );
	
		add( jp1 );
		add( jpTotb );
		add( jp2 );
		add( jp3 );
		add( jp4 );
		add( jp5 );


		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		pack();
		show();
		setVisible( true );
		
		
		addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		});
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		gname = jt1.getText().toString();
		String sql = "SELECT * FROM GOODS WHERE gname=?";
		try {
			pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			pst.setString( 1, gname );
			rs = pst.executeQuery();
			data.removeAllElements();
			pack();
			while( rs.next() ) {
				Vector line = new Vector();
				for( int i = 1; i <= 4; i++ ) {
					line.add( rs.getObject(i) );
				}
				data.add( line );
			} 
			defaultModel.setDataVector( data, title );
			pack();
			DbClose.queryClose( pst, rs, conn );
		}catch( SQLException sqle ) {
			sqle.printStackTrace();
		}finally {
			DbClose.queryClose( pst, rs, conn );
		}
	}

	public static void main(String[] args) {
		new ShoppingAccountPage();
	}
}
