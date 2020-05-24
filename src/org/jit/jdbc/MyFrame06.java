package org.jit.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* 查找
* @author dd
*
*/

public class MyFrame06 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3875327913128504957L;
	private JButton btn1;
	private JButton btn2;

	  private JTextField tf;

	public void init() {

	    setLayout(new FlowLayout());
	    setTitle("学生信息查看系统");
	    setSize(500, 500);
	    setLocationRelativeTo(null);

	}

	public void add(){
	     btn1=new JButton("确定");
	        btn1.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int x=JOptionPane.showConfirmDialog(MyFrame06.this, "是否查看", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	                if (x==JOptionPane.OK_OPTION) {
	                try {
	                    ck();
	                    MyFrame06.this.dispose();
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            }else{
	                JOptionPane.showConfirmDialog(MyFrame06.this, "查看失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	                new MyFrame06();
	            }
	            }
	        });


	        btn2=new JButton("取消");
	        btn2.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                MyFrame06.this.dispose();
	                new MyFrame04();

	            }
	        });

	    add(btn1);
	    add(btn2);


	}

	public  JPanel getFilePanel(){
	     JPanel p=new JPanel();
	     p.setLayout(new FlowLayout());
	     p.add(new JLabel("请输入要查找学生的名字"));
	     tf=new JTextField(10);
	     p.add(tf);
	     return p;

	}
	public MyFrame06(){
	    JPanel cp=(JPanel) getContentPane();
	    cp.setLayout(new FlowLayout());
	    cp.add(getFilePanel());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    add();
	    init();

	    setVisible(true);
	}

	public void ck() throws IOException {
	    File f=new File("f:\\学生信息");
	    String fname []=f.list();
	    /*String a=null;*/
	    boolean b=false;
	    for(String s:fname){
	        if (s.equals(tf.getText()+".txt")) {
	            new MyFrame07(tf.getText()+".txt");
	          b=true;
	        }
	        }
	    if (!b) {
	        JOptionPane.showConfirmDialog(MyFrame06.this, "查看失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
	        new MyFrame06();
	    }
	        MyFrame06.this.dispose();

	}
}