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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
* 信息录入
* @author dd
*
*/

public class MyFrame02 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6950975487859584925L;
	private JMenuBar bar;
	private JMenu my_file;

	
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf4;
	private static JTextField tf5;
	private static JTextField tf6;
	private static JTextField tf7;
	private static JTextField tf8;
	
	private static JButton btn1;
	private static JButton btn2;
	
	public void init() {
	    setLayout(new FlowLayout());
	    setTitle("学生信息录入");
	    setSize(500, 300);
	    setLocationRelativeTo(null);	
	}
	public void add(){
	    bar=new JMenuBar();
	     my_file=new JMenu("开始");
	  

	     bar.add(my_file);
	    
	     setJMenuBar(bar);
	}
	
	public MyFrame02() {
		  JPanel p=new JPanel();
		  JPanel p1=new JPanel();
		  JPanel p2=new JPanel();
		  new JPanel();
		     p.setLayout(new BorderLayout());
		     p1.setLayout(new GridLayout(4,2));
		     p2.setLayout(new FlowLayout());

		     p1.add(new JLabel("姓名"));
		     tf1=new JTextField(10);
		     p1.add(tf1);
		     p1.add(new JLabel("性别"));
		     tf2=new JTextField(10);
		     p1.add(tf2);
		     p1.add(new JLabel("班级"));
		     tf3=new JTextField(10);
		     p1.add(tf3);
		     p1.add(new JLabel("专业"));
		     tf4=new JTextField(10);
		     p1.add(tf4);
		     p1.add(new JLabel("院系")); 
		     tf5=new JTextField(10);
		     p1.add(tf5);
		     p1.add(new JLabel("电子邮箱"));
		     tf6=new JTextField(10);
		     p1.add(tf6);
		     p1.add(new JLabel("联系方式"));
		     tf7=new JTextField(10);
		     p1.add(tf7);
		     p1.add(new JLabel("学校"));
		     tf8=new JTextField(10);
		     p1.add(tf8);
		    btn1=new JButton("保存");
		    btn2=new JButton("取消");
		     p1.add(tf8);
		     p2.add(btn1);
		     p2.add(btn2);


		     this.setContentPane(p);
		     p.add(p1,BorderLayout.CENTER);
		     p.add(p2,BorderLayout.SOUTH);

		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  init();
		  add();
		  setVisible(true);

		  btn1.addActionListener(new ActionListener() {

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            int x=JOptionPane.showConfirmDialog(MyFrame02.this, "是否保存？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		            if (x==JOptionPane.OK_OPTION) {
		                try {
		                      cj();
		                    test01();
		                    JOptionPane.showConfirmDialog(MyFrame02.this, "保存成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		                MyFrame02.this.dispose();
		                new MyFrame02();
		                } catch (IOException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();

		                }
		        }else{
		                JOptionPane.showConfirmDialog(MyFrame02.this, "保存失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		       }
		      }
		    });
		  btn2.addActionListener(new ActionListener() {

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            new MyFrame04();
		            MyFrame02.this.dispose();

		        }
		    });
		}
	public static void test01() throws IOException{
		 String name ="f:\\学生信息\\"+tf1.getText()+".txt";

		    OutputStream os=new FileOutputStream(name);
		  os.write("姓名：".getBytes());
		  os.write(tf1.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("性别：".getBytes());
		  os.write(tf2.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("班级：".getBytes());
		  os.write(tf3.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("电话：".getBytes());
		  os.write(tf4.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("手机：".getBytes());
		  os.write(tf5.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("电子邮箱：".getBytes());
		  os.write(tf6.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("通信地址：".getBytes());
		  os.write(tf7.getText().getBytes());
		  os.write("。".getBytes());
		  os.write("邮政编码：".getBytes());
		  os.write(tf8.getText().getBytes());
		  os.close();
		}
	public static void cj(){
		File f1=new File("f:/学生信息");
		f1.mkdir();
		}
}