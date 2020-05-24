package org.jit.jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
*
* 删除学生信息
*
* @author dd
*
*/
public class MyFrame05 extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JButton btn1;
		private JButton btn2;
		private JTextField tf;
		public void init() {

		    setLayout(new FlowLayout());
		    setTitle("学生信息删除系统");
		    setSize(500, 500);
		    setLocationRelativeTo(null);

		}
		public void add(){
		     btn1=new JButton("确定");
		        btn1.addActionListener(new ActionListener() {

		            @Override


		                public void actionPerformed(ActionEvent e) {

		                        test02();


		            }

		        });
		        btn2=new JButton("取消");
		        btn2.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                new MyFrame04();
		                MyFrame05.this.dispose();


		            }
		        });

		    add(btn1);
		    add(btn2);


		}
		public  JPanel getFilePanel(){
		     JPanel p=new JPanel();
		     p.setLayout(new FlowLayout());
		     p.add(new JLabel("请输入要删除学生的名字"));
		     tf=new JTextField(10);
		     p.add(tf);
		     return p;

		}
		public MyFrame05(){
		    JPanel cp=(JPanel) getContentPane();
		    cp.setLayout(new FlowLayout());
		    cp.add(getFilePanel());
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    add();
		    init();

		    setVisible(true);
		}
		public void test02(){
			String name ="f:/学生信息/"+tf.getText()+".txt";
			//File f=new File(name);
			File f=new File("f:/学生信息");
			String fname []=f.list();
			File f1=new File(name);boolean b=false;
			for(String s:fname){

			    if (s.equals(tf.getText()+".txt")) {    
			        int y=JOptionPane.showConfirmDialog(MyFrame05.this, "是否删除",
			        "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
			        if (y==JOptionPane.OK_OPTION ) {
			            f1.delete();

			            JOptionPane.showConfirmDialog(MyFrame05.this, "删除成功", 
			        "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
			            MyFrame05.this.dispose();
			            new MyFrame05();

			            b=true;
			        }

			    }

			     }
			if(!b){
			    JOptionPane.showConfirmDialog(MyFrame05.this, "是否删除?", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);

			    JOptionPane.showConfirmDialog(MyFrame05.this, "删除失败：学生信息不存在", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
			    MyFrame05.this.dispose();
			    new MyFrame05();
			}
		}
}
	