package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
*三个面板是用来装三种情况，分别是输入商品名、选择修改内容、输入修改
*/
public class ChangeCommodityPage extends JFrame implements ActionListener {
	JButton b4 = new JButton( "确定" );
	JButton b5 = new JButton( "重置" );

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JLabel j1 = new JLabel( "输入更改商品名称" );
	JTextField jt1 = new JTextField();
	JLabel j6 = new JLabel( "商品名称" );
	JLabel j7 = new JLabel( "商品价格" );
	JLabel j8 = new JLabel( "商品数量" );
	JTextField jt8 = new JTextField();
	JTextField jt9 = new JTextField();
	JTextField jt10 = new JTextField();

	JLabel j2 = new JLabel( "选择您要修改的内容" );

	JButton jb1 = new JButton( "更改商品名称" );
	JButton jb2 = new JButton( "更改商品价格" );
	JButton jb3 = new JButton( "更改商品数量" );
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();

	JLabel j3 = new JLabel( "请输入已修改的商品名称" );
	JLabel j4 = new JLabel( "请输入已修改的商品价格" );
	JLabel j5 = new JLabel( "请输入已修改的商品数量" );
	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();
	JTextField jt7 = new JTextField();
	JPanel jpb = new JPanel();
	

	public ChangeCommodityPage() {
		setSize( 500, 500 );
		setLayout( new GridLayout( 0, 1 ) );
		p1.setLayout( new GridLayout( 0, 1 ) );
		p1.add( j1 );
		p1.add( jt1 );
		p1.add( j6 );
		p1.add( jt8 );
		p1.add( j7 );
		p1.add( jt9 );
		p1.add( j8 );
		p1.add( jt10 );
		
		p2.setLayout( new GridLayout( 0, 1 ) );
		p2.add( j2 );
		p2.add( jb1 );
		p2.add( jb2 );
		p2.add( jb3 );
		
		jb1.addActionListener( this );
		jb2.addActionListener( this );
		jb3.addActionListener( this );

		getContentPane().add( p1 );
		
		//jt1.addActionListener( new TextFieldToShow() );
		jt1.addActionListener( this );	

		pack();
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
		jpb.setLayout( new FlowLayout() );
		jpb.add( b4 );
		jpb.add( b5 );
		b4.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				//实现更该数据库
				System.out.println( "更改后名称"  + jt5.getText() );
				jt5.setText( null );
			}
		} );
		b5.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				System.out.println( "正在重置" );
				
				p3.removeAll();
				remove( p3 );
				remove( jpb );

				setLayout( new GridLayout( 0, 1 ) );
				p1.setLayout( new GridLayout( 0, 1 ) );
				p1.add( j1 );
				p1.add( jt1 );
				p1.add( j6 );
				p1.add( jt8 );
				p1.add( j7 );
				p1.add( jt9 );
				p1.add( j8 );
				p1.add( jt10 );
				p2.setLayout( new GridLayout( 0, 1 ) );
				p2.add( j2 );
				p2.add( jb1 );
				p2.add( jb2 );
				p2.add( jb3 );
		
				jb1.addActionListener( this );
				jb2.addActionListener( this );
				jb3.addActionListener( this );
				getContentPane().add( p1 );
				pack();
			}
		} );

	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JTextField ) {
			JTextField srcTex = (JTextField) obj;
			System.out.println( "您输入了" + srcTex.getText() );
			jt1.setText( null );
			p1.removeAll();
			remove( p1 );
			getContentPane().add( p2 );
			pack();
		}
		else if( obj instanceof JButton ) {
			JButton srcBtn = (JButton) obj;
				if( srcBtn.getText().equals( "更改商品名称" ) ) {
				p2.removeAll();
				p1.removeAll();
				remove( p2 );
				remove( p1 );
				p3.setLayout( new GridLayout( 1, 0 ) );
				p3.add( j3 );
				p3.add( jt5 );
				getContentPane().add( p3 );
				getContentPane().add( jpb );
				pack();
				
			}
			
			if( srcBtn.getText().equals( "更改商品价格" ) ) {
				p2.removeAll();
				remove( p2 );
				p3.setLayout( new GridLayout( 1, 0 ) );
				p3.add( j4 );
				p3.add( jt6 );
				getContentPane().add( p3 );
				getContentPane().add( jpb );
				pack();
			}
	
			if( srcBtn.getText().equals( "更改商品数量" ) ) {
				p2.removeAll();
				remove( p2 );
				p3.setLayout( new GridLayout( 1, 0 ) );
				p3.add( j5 );
				p3.add( jt7 );
				getContentPane().add( p3 );
				getContentPane().add( jpb );
				pack();
			}

		}
		else {
			System.out.println( "Not Distinguish Source" );
		}
	}

	public static void main(String[] args) {
		new ChangeCommodityPage();
	}
}

//class TextFieldToShow implements ActionListener {
//}
