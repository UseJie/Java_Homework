package Interface.ComMaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
*三个面板是用来装三种情况，分别是输入商品名、选择修改内容、输入修改
*/
public class ChangeCommodityPage extends JFrame implements ActionListener {
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JLabel j1 = new JLabel( "输入更改商品名称" );
	JTextField jt1 = new JTextField();

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

	public ChangeCommodityPage() {
		setSize( 500, 500 );
		setLayout( new GridLayout( 1, 1 ) );
		p1.setLayout( new GridLayout( 2, 1 ) );
		p1.add( j1 );
		p1.add( jt1 );
		
		p2.setLayout( new GridLayout( 0, 1 ) );
		p2.add( j2 );
		p2.add( jb1 );
		p2.add( jb2 );
		p2.add( jb3 );

		getContentPane().add( p1 );
		
		//jt1.addActionListener( new TextFieldToShow() );
		jt1.addActionListener( this );	

		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setVisible( true );
	}
	@Override
	public void actionPerformed( ActionEvent e ) {
		Object obj = e.getSource();
		if( obj instanceof JTextField ) {
			JTextField srcTex = (JTextField) obj;
			System.out.println( "您输入了" + srcTex.getText() );
			jt1.setText( null );
			//this.removeLayoutComponent( p1 );
			getContentPane().add( p2 );
			pack();
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
