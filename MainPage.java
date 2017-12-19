/*
*功能描述：主界面
*显示：
＊		1.商品维护
*		2.前台收银
*		3.商品管理
＊author：userjie.com
*/

package Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class MainPage {
	public static void main(String[] args) {
		JFrame a = new JFrame( "主界面" );
		Container c = new Container();
		JPanel p = new JPanel();
		
		a.setSize( 200, 200 );
		a.setLocation( 100, 100 );
		a.setLayout( new BorderLayout( 5, 5 ) );//  组件横、纵间距为5个像素
		p.setLayout( new FlowLayout( 1, 5, 5 ) );
		JButton b1 = new JButton( "商品维护" );
		JButton b2 = new JButton( "前台收银" );
		JButton b3 = new JButton( "商品管理" );
		p.add( b1, BorderLayout.CENTER );	
		p.add( b2, BorderLayout.CENTER );	
		p.add( b3, BorderLayout.CENTER );	
		a.getContentPane().add( "Center", p );
		a.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		a.pack();
		a.setVisible( true );
	}
}
