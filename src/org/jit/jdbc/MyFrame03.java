package org.jit.jdbc;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
* 注册账号
* @author dd
*
*/
public class MyFrame03 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5937504264182197318L;
	private JTextField tf;
	private JPasswordField pf1;
	private JPasswordField pf2;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JButton btn1;
	private JButton btn2;
	private JPanel p=new JPanel();
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel p4=new JPanel();
	private JPanel p5=new JPanel();
	public void init(){
	    setTitle("学生登记系统注册账号");
	    setSize(300, 200);
	    setLocationRelativeTo(null);
	    lb1=new JLabel("  账号");
	    lb2=new JLabel("  密码");
	    lb3=new JLabel("  再次输入密码");
	    lb4=new JLabel("注册账号");
	    btn1=new JButton("确定");
	    btn2=new JButton("取消");
	    tf=new JTextField(20);
	    pf1=new JPasswordField(20); 
	    pf2=new JPasswordField(20); 
	
	   this.setContentPane(p);
	   p.setLayout(new BorderLayout());
	   p1.setLayout(new FlowLayout());
	   p2.setLayout(new GridLayout(3, 2));
	
	   p1.add(lb4);
	   p2.add(lb1);
	   p2.add(tf);
	   p2.add(lb2);
	   p2.add(pf1);
	   p2.add(lb3);
	   p2.add(pf2);
	   p3.add(btn1);
	   p3.add(btn2);
	   p.add(p1,BorderLayout.NORTH);
	   p.add(p2,BorderLayout.CENTER);
	   p.add(p3,BorderLayout.SOUTH);
	   p.add(p4,BorderLayout.EAST);
	   p.add(p5,BorderLayout.WEST);
	}
	
	public void add(){
	
	
	    btn1.addActionListener(new ActionListener() {
	
	        @SuppressWarnings("deprecation")
			@Override
	        public void actionPerformed(ActionEvent e) {
	        if (pf2.getText().toString().trim().equals(pf1.getText().toString().trim())) {
	
	            try {
	                save();
	                int x=JOptionPane.showConfirmDialog(MyFrame03.this, "注册成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	                if(x==JOptionPane.OK_OPTION){
	                    fh();
	
	                }
	            } catch (IOException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        }else {
	            JOptionPane.showConfirmDialog(MyFrame03.this, "输入密码不一致，请重新输入", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	            MyFrame03.this.dispose();
	            new MyFrame03();
	        }
	
	        }

			private void fh() {
				// TODO Auto-generated method stub
				MyFrame03.this.dispose();
				new MyFrame01();
			
			}
	    });
	
	
	
	    btn2.addActionListener(new ActionListener() {
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            fh();
	
	        }

			private void fh() {
				// TODO Auto-generated method stub
				MyFrame03.this.dispose();
				new MyFrame01();
			
			}
	    });
	
	     /*add(tf);
	     add(pf1);
	     add(pf2);
	     add(btn1);
	     add(btn2);*/
	
	
	}
	/*   public  JPanel getFilePanel(){
	    JPanel p=new JPanel();
	     p.setLayout(new FlowLayout());
	     p.add(new JLabel("注册账号！"));
	     return p;
	}*/
	
	public MyFrame03() {
	   JPanel cp=(JPanel) getContentPane();
	   cp.setLayout(new FlowLayout());
	
	   /*cp.add(getFilePanel());*/
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	    add();
	    setVisible(true);
	}

		@SuppressWarnings("deprecation")
		public void save() throws IOException{
		File f1=new File("f:/信息系统账号");
		f1.mkdir();
		String name ="f:/信息系统账号/"+tf.getText()+".txt";
		OutputStream os=new FileOutputStream(name);
		//os.write(tf.getText().getBytes());
		os.write(pf1.getText().getBytes());
		os.close();
	}
}