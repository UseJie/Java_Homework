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

	Connection conn = null;
	PreparedStatement pst = null;
	String gname;
	
	int dataNum;//用来记录数据库中数量
	String dataName;
	int dataPrice;
	
	Integer jt3Data;//总价
	Integer jt4Data;//收款
	Integer jt5Data;//找零
	
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
				Integer jtNum = Integer.parseInt(jt2.getText());
				if( dataNum >= jtNum && jtNum >= 0 ) {
					System.out.println( dataNum + " "+ jtNum );
					//更新数据中的数量
					Integer updateNum = new Integer(dataNum - jtNum);
					conn = DbConn.getconn();
					String sql = "UPDATE GOODS SET gnum=? WHERE gname=?";
					try{
						pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
						String insertData = new String( updateNum.toString() );
						pst.setString( 1, insertData );
						pst.setString( 2, dataName );
						int rs = pst.executeUpdate();
						if( rs > 0) {
							//计算总价
							jt3Data = new Integer ( jtNum * dataPrice );
							jt3.setText( jt3Data.toString() );
						}
						else {
							jt1.setText( "系统出错,请重新输入" );
							data.removeAllElements();
							defaultModel.setDataVector( data, title );
							jt2.setText( null );
							jt3.setText( null);
						}
					}catch( SQLException sqle ) {
						System.out.println( "SQLException: " + sqle.getMessage() );
					}finally {
						DbClose.addClose( pst, conn );
					}
					
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
		});
		
		jp3.setLayout( new GridLayout( 0, 1 ) );
		jp3.add( j3 );
		jp3.add( jt3 );


		jp4.setLayout( new GridLayout( 0, 1 ) );
		jp4.add( j4 );
		jp4.add( jt4 );
		/*
		 * Jt4.addActonListener:
		 * 1. 不重复检验前面是否为空
		 * 2. 直接获取jt4Data//收款
		 * 3. 然后设置jt5Data//找零
		 */
		jt4.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				if( !jt4.getText().equals("") &&
					jt4.getText()!=null) {
					jt4Data = Integer.parseInt(jt4.getText());
					if( jt4Data >= jt3Data ) {
						jt5Data = jt4Data - jt3Data;
						jt5.setText( jt5Data.toString() );
					}
					else {
						//收款不够
						jt4.setText( "收款不够" );
						jt4.addMouseListener( new MouseAdapter() {
							public void mouseClicked( MouseEvent me ) {
								jt4.setText(null);
							}
						});
					}
				}
				else {
					//请给出有效输入
					jt4.setText( "请输入收款金额" );
					jt4.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt2.setText(null);
						}
					});
				}
			}
		});
		
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
		
		
	}

	/*
	 *	jt1:
	 *	1. 输入不能为空
	 * 	2. 连接数据库
	 * 	3. 显示数据
	 */
	@Override
	public void actionPerformed( ActionEvent e ) {
		if( !jt1.getText().equals("") && jt1.getText()!=null && 
				!jt1.getText().equals("请输入商品名") ) {
			gname = jt1.getText().toString();
			String sql = "SELECT * FROM GOODS WHERE gname=?";
			conn = DbConn.getconn();
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
				pst.setString( 1, gname );
				rs = pst.executeQuery();
				data.removeAllElements();
				pack();
				if( rs.next() ) {
					Vector line = new Vector();
					for( int i = 1; i <= 4; i++ ) {
						line.add( rs.getObject(i) );
					}
					data.add( line );
					dataName = rs.getString(2);
					dataPrice = rs.getInt( 3 );
					dataNum = rs.getInt( 4 );
				}
				else {
					//输入为空
					jt1.setText("商品不存在/商品名错误");
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt1.setText(null);
						}
					});
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
		else {
			data.removeAllElements();
			defaultModel.setDataVector( data ,  title );
			jt2.setText(null);
			jt1.setText("请输入商品名");
			jt1.addMouseListener( new MouseAdapter() {
				public void mouseClicked( MouseEvent me ) {
					jt1.setText(null);
				}
			});
		}
	}

	public static void main(String[] args) {
		new ShoppingAccountPage();
	}
}
