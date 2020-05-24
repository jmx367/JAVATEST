package org.jit.jdbc;
/**
* 登陆界面
* @author dd
*
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class MyFrame01 extends JFrame{
	private JButton btn1;
	private JButton btn2;
	private JTextField tf;
	private JPasswordField pf;
	public void init() {

	    /*setLayout(new FlowLayout());*/
	    setTitle("学生登记系统");
	    setSize(400, 180);
	    setLocationRelativeTo(null);

	    tf=new JTextField(5);
	    pf=new JPasswordField(5);
	}
	public void add1(){

	    btn1=new JButton("登陆"); 
	    JLabel name=new JLabel("       账号");
	    JLabel password=new JLabel("       密码");
	    JLabel bq1=new JLabel("  ");
	    JLabel bq2=new JLabel("  ");


	    JPanel p=new JPanel();
	    JPanel p1=new JPanel();
	    JPanel p2=new JPanel();
	    JPanel p3=new JPanel();
	    JPanel p4=new JPanel();
	    JPanel p5=new JPanel();



	    btn1.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        try {
	            pd();
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        }
	    });


	    btn2=new JButton("注册");
	    btn2.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new MyFrame03();
	            MyFrame01.this.dispose();
	        }
	    });
	    this.setContentPane(p); //设置为内容面板  总布
	    p.setLayout(new BorderLayout());
	    p1.setLayout(new FlowLayout());
	    p2.setLayout(new GridLayout(2,2));
	    p3.setLayout(new FlowLayout());



	     p1.add(new JLabel("登陆系统"));
	     p2.add(name);
	     p2.add(tf);
	     p2.add(password);
	     p2.add(pf);
	     p3.add(btn1);
	     p3.add(btn2);
	     p4.add(bq1);
	     p5.add(bq2);


	     p.add(p1,BorderLayout.NORTH);
	     p.add(p2,BorderLayout.CENTER);
	     p.add(p3,BorderLayout.SOUTH);
	     p.add(p4,BorderLayout.EAST);

	}


	public MyFrame01(){
	    JPanel cp=(JPanel) getContentPane();
	    cp.setLayout(new FlowLayout());

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	    add1();
	    setVisible(true);
	}
	@SuppressWarnings("deprecation")
	public void pd() throws IOException{
	    File f=new File("f:\\信息系统账号");
	    String fname []=f.list();
	    @SuppressWarnings("unused")
		String a=null;
	    for(String s:fname){
	        if (s.equals(tf.getText()+".txt")) {    
	        a=s;
	        @SuppressWarnings("resource")
			Reader r=new FileReader("f:\\信息系统账号\\"+s);
	        String b=null;
	        char cs[]=new char[10];
	        int len=0;
	        while ((len=r.read(cs))!=-1) {
	            b=new String(cs,0,len);
	        }
	        if (pf.getText().equals(b)) {
	            JOptionPane.showConfirmDialog(MyFrame01.this, "输入正确！", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	            new MyFrame04();
	            MyFrame01.this.dispose();
	        }   else {
	            JOptionPane.showConfirmDialog(MyFrame01.this, "输入有误,请重新输入！", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	            MyFrame01.this.dispose();
	            new MyFrame01();
	        }   
	}
	}

	}
}
