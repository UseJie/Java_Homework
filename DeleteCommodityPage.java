package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DeleteCommodityPage extends JFrame implements ActionListener {
	JPanel jp1 = new JPanel();
	JLabel j1 = new JLabel( "输入删除商品名称" );
	JTextField jt1 = new JTextField();

	JPanel jp2 = new JPanel();
	JLabel j2 = new JLabel( "商品名称" );
	JTextField jt2 = new JTextField();
	JLabel j3 = new JLabel( "商品价格" );
	JTextField jt3 = new JTextField();
	JLabel j4 = new JLabel( "商品数量" );
	JTextField jt4 = new JTextField();

	JPanel jp3 = new JPanel();
	JButton jb1 = new JButton( "确定" ); 
	JButton jb2 = new JButton( "取消" ); 

	public DeleteCommodityPage() {
		setLayout( new BorderLayout() );
		jp1.setLayout( new GridLayout( 0, 1 ) );
		jp1.add( j1 );
		jp1.add( jt1 );
		getContentPane().add( "North", jp1 );
		jt1.addActionListener( this );
			
		jp2.setLayout( new GridLayout( 0, 1 ) );
		jp2.add( j2 );
		jp2.add( jt2 );
		jp2.add( j3 );
		jp2.add( jt3 );
		jp2.add( j4 );
		jp2.add( jt4 );
		getContentPane().add( "Center", jp2 );

		jp3.setLayout( new FlowLayout() );
		jp3.add( jb1 );
		jp3.add( jb2 );
		getContentPane().add( "South", jp3 );

		jb1.addActionListener( this );
		jb2.addActionListener( this );

		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}

	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JTextField ) {
			JTextField srcText = (JTextField) obj;
			System.out.println( "您输入了:" + srcText.getText() );
			jt2.setText( srcText.getText() );
			jt3.setText( "5" );
			jt4.setText( "100" );
			jt1.setText( null );
		}
		else if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
			if( srcBtn.getText().equals( "确定" ) ) {
				//实现从数据库中删除
				jt2.setText( null );
				jt3.setText( null );
				jt4.setText( null );
				System.out.println( "您单击了按钮\"确定\"" );
			} 
			if( srcBtn.getText().equals( "取消" ) ) {
				//实现推出单前界面
				System.out.println( "您单击了按钮\"取消\"" );
				this.dispose();
			}
		}
		else {
			System.out.println( "Not Distinguisg Source" );
		}
	}

	public static void main( String[] args ) {
		new DeleteCommodityPage();
	}
}
