package org.jit.jdbc;

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
import javax.swing.JPanel;

/**
* 显示学生信息
* @author dd
*
*/
public class MyFrame07 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3470067343249189290L;


	 private JButton btn1;
	private JButton btn2;




	    public void init() {

	        setLayout(new FlowLayout());
	        setTitle("学生信息");
	        setSize(500, 500);
	        setLocationRelativeTo(null);


	    }

	   public void add(){
	         btn1=new JButton("退出");
	            btn1.addActionListener(new ActionListener() {

	                @Override
	                public void actionPerformed(ActionEvent e) {

	                    System.exit(0);
	                }
	            });


	            btn2=new JButton("返回");
	            btn2.addActionListener(new ActionListener() {

	                public void actionPerformed(ActionEvent e) {
	                    MyFrame07.this.dispose();
	                    new MyFrame06();

	                }
	            });


	   }


	public MyFrame07(String name) throws IOException {


	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	     add();
	     dq(name);
	setVisible(true);

	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	setContentPane(p);

	p.setLayout(new BorderLayout());
	p1.setLayout(new GridLayout(8,1));
	p2.setLayout(new FlowLayout());

	p1.add(new JLabel(w0));
	p1.add(new JLabel(w1));
	p1.add(new JLabel(w2));
	p1.add(new JLabel(w3));
	p1.add(new JLabel(w4)); 
	p1.add(new JLabel(w5));
	p1.add(new JLabel(w6));
	p1.add(new JLabel(w7));
	p2.add(btn1);
	p2.add(btn2);

	p.add(p1,BorderLayout.CENTER);
	p.add(p2,BorderLayout.SOUTH);
	p.add(p3,BorderLayout.EAST);
	p.add(p4,BorderLayout.WEST);
	}
	String w0=null;
	String w1=null;
	String w2=null;
	String w3=null;
	String w4=null;
	String w5=null;
	String w6=null;
	String w7=null;
	 public  void dq(String name) throws IOException{
	    File f=new File("f:\\学生信息");
	    @SuppressWarnings("unused")
		String fname []=f.list();

	        Reader r=new FileReader("f:\\学生信息\\"+name);
	        String b=null;
	        char cs[]=new char[1024*1024];
	        int len=0;
	        while ((len=r.read(cs))!=-1) {
	            b=new String(cs,0,len);
	        }
	        r.close();

	        String[] s=b.split("。");
	        w0=s[0];
	        w1=s[1];
	        w2=s[2];
	        w3=s[3];
	        w4=s[4];
	        w5=s[5];
	        w6=s[6];
	        w7=s[7];

	}
}