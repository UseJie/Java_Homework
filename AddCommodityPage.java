package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class AddCommodityPage extends JFrame implements ActionListener {

	public JPanel p = new JPanel();
	public JPanel p1 = new JPanel();	

	public JLabel jL1 = new JLabel( "添加商品名称" );
	public JLabel jL2 = new JLabel( "添加商品价格" );
	public JLabel jL3 = new JLabel( "添加商品数量" );

	public JTextField jt1 = new JTextField();
	public JTextField jt2 = new JTextField();
	public JTextField jt3 = new JTextField();

	public JButton b1 = new JButton( "确定" );
	public JButton b2 = new JButton( "重置" );

	public AddCommodityPage() {
		setLayout( new BorderLayout() );
		p.setLayout( new GridLayout( 0, 1 ) );
		p1.setLayout( new FlowLayout() );
		p.add( jL1 );
		p.add( jt1 );
		p.add( jL2 );
		p.add( jt2 );
		p.add( jL3 );
		p.add( jt3 );
		p1.add( b1 );
		p1.add( b2 );
		b1.addActionListener( this );
		b2.addActionListener( this );
		getContentPane().add( "Center", p );
		getContentPane().add( "South", p1 );
		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "确定" ) ) {
				if( jt1.getText()!=null && !jt1.getText().equals("") && 
					jt2.getText()!=null && !jt2.getText().equals("") && 
					jt3.getText()!=null && !jt3.getText().equals("") ) {	//将数据添加到数据库
					Connection con = null;
					PreparedStatement pst = null;
					try {
						System.out.println( "Begin connecting to supermarketDB" );
						String url = "jdbc:mysql://localhost:3306/supermarketDB";
						String user = "root";
						String password = "Userjie1119";
						con = DriverManager.getConnection( url, user, password);
						if( !con.isClosed() )
							System.out.println( "Successed connecting to DB" );

						/*
						InputVerifier verifier = new InputVerifier() {
							public boolean verify(JComponent comp) {
								boolean returnValues;
								JTextField textField = (JTextField) comp;
								try {
									Integer.parseInt(textField.getText());
									returnValues = true;
								}catch(NumberFormatException nfe ) {
									returnValues = false;
								}
								return returnValues;
							}
						};
						jt2.setInputVerifier(verifier);
						jt3.setInputVerifier(verifier);
						*/
						Statement stmt = con.createStatement();
						String gname = jt1.getText().toString();
						int gprice = Integer.parseInt( jt2.getText() );
						int gnum = Integer.parseInt( jt3.getText() );
					
						System.out.println( gname + " " + gprice + " " + gnum);
						String sql = "insert into GOODS( gname, gprice, gnum ) values(?,?,?)";
						pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						pst.setString(1,gname);
						pst.setInt(2,gprice);
						pst.setInt(3,gnum);
						pst.executeUpdate();
						con.close();
					}catch(SQLException es ) {
						System.out.println( "SQLException : " + es.getMessage() );
					}catch(Exception ex ) {
						System.out.println( "Exception : " + ex.getMessage() );
						jt1.setText( "请输入正确的格式" );
						jt2.setText( null );
						jt3.setText( null );			
						jt1.addMouseListener( new MouseAdapter() {
							public void mouseClicked( MouseEvent me2 ) {
								jt1.setText(null);
							}
						});	
					}finally{
						System.out.println( "Bye" );
					}
				}
			
				else {
					jt1.setText("请输入全部信息");
					jt2.setText(null);
					jt3.setText(null);
					jt1.addMouseListener( new MouseAdapter() {
						public void mouseClicked( MouseEvent me ) {
							jt1.setText(null);
						}
					});
				}	
			}
				if( srcBtn.getText().equals( "重置" ) ) {
					jt1.setText( null );			
					jt2.setText( null );			
					jt3.setText( null );			
				}
			}
		}

	

	public static void main(String[] args) {
		new AddCommodityPage();
	}
}
