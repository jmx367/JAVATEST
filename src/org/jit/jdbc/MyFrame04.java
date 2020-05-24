package org.jit.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
* 选择需要进行的操作。
* 1.录入学生信息
* 2.修改学生信息
* 3.删除学生信息
* 4.注销
* @author dd
*
*/
public class MyFrame04 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1716005290443185025L;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	public void init(){
	    setLayout(new FlowLayout());
	    setTitle("选择");
	    setSize(275, 405);
	    setLocationRelativeTo(null);
	}
	public void add(){
		btn1=new JButton("录入学生信息");
		btn1.addActionListener(new ActionListener() {

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            new MyFrame02();
		            MyFrame04.this.dispose();

		        }
		    });


		    btn2=new JButton("查找学生信息");
		    btn2.addActionListener(new ActionListener() {

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            new MyFrame06();
		            MyFrame04.this.dispose();
		        }
		    });

		    btn3=new JButton("删除学生信息");
		   btn3.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		     new MyFrame05();
		     MyFrame04.this.dispose();

		    }
		});
		   
		   

		   btn4=new JButton("退出信息系统");
		  btn4.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int x=JOptionPane.showConfirmDialog(MyFrame04.this, "是否退出系统？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		        if(x==JOptionPane.OK_OPTION){


		            System.exit(0);
		        }

		    }
		});

		     add(btn1);
		     add(btn2);
		     add(btn3);
		     add(btn4);
		   
	}
	public JPanel getFilePanel(){
		JPanel p=new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel("选择你要进行的操作！"));
		return p;
		}

		public MyFrame04() {
		JPanel cp=(JPanel) getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(getFilePanel());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    init();
	    add();
	    setVisible(true);
		}
}