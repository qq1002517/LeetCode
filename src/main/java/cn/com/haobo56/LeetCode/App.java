package cn.com.haobo56.LeetCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class App extends JFrame{
	private static final long serialVersionUID = 1L;
	public DrawComponent dc = new DrawComponent();
	 
	public static void main(String[] args) {
		App jmf= new App();
		jmf.initUI();
	}
 
	private void initUI() {
		
		this.setSize(600,500);
		this.setDefaultCloseOperation(3);
		this.setTitle("亮瞎你眼");
		JPanel jp = new JPanel();
		jp.setSize(50, 0);
		jp.setLayout(new FlowLayout());
		this.add(BorderLayout.SOUTH,jp);
		JLabel j1 = new JLabel("行数");
		JTextField jtf1 = new JTextField();
		jtf1.setPreferredSize(new Dimension(20,30));
		JLabel j2 = new JLabel("列数");
		JTextField jtf2 = new JTextField();
		jtf2.setPreferredSize(new Dimension(20,30));
		JButton jb = new JButton("确定");
		
		MyActionListener ma = new MyActionListener(dc,jtf1,jtf2);
		jb.addActionListener(ma);
		jp.add(j1);
		jp.add(jtf1);
		jp.add(j2);
		jp.add(jtf2);
		jp.add(jb);
		this.add(dc);
		
		this.setVisible(true);
		
	}
}
/**
 * 
 * @author haobo56
 *	彩蛋组件
 */
class DrawComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private int row =0,column = 0;
	
	//重绘方法
	public void paintComponent(Graphics g) {
		this.setPreferredSize(new Dimension(400,400));
		Random rand = new Random();
		for(int i = 0;i<this.row;i++){
			for(int j = 0;j<this.column;j++){
				int r1 = rand.nextInt(256);
				int g1 = rand.nextInt(256);
				int b1 = rand.nextInt(256);
				Color c = new Color(r1,g1,b1);
				g.setColor(c);
				g.fillOval(j*100+100, i*50+50, 100, 50);
			}
		}	
	}
	
	public int getRow() {
		return row;
	}
 
	public void setRow(int row) {
		this.row = row;
	}
 
	public int getColumn() {
		return column;
	}
 
	public void setColumn(int column) {
		this.column = column;
	}
}
/**
 * 监听器
 * @author haobo56
 *
 */
class MyActionListener implements ActionListener {
	 
	public JTextField jtf1,jtf2;
	public DrawComponent dc;
	private MyThread m1;
	
	public MyActionListener(DrawComponent dc,JTextField jtf1, JTextField jtf2) {
		this.dc = dc;
		this.jtf1 = jtf1;
		this.jtf2 = jtf2;
	}
 
	public void actionPerformed(ActionEvent e) {
		//得到文本框的文本值
		int row = Integer.parseInt(this.jtf1.getText());
		int column = Integer.parseInt(this.jtf2.getText());
		
		//启动线程
		if(m1 == null){
			m1 = new MyThread(this.dc);
			m1.start();
		}
		this.dc.setColumn(column);
		this.dc.setRow(row);
	}
}
/**
 * 线程
 */
class MyThread extends Thread{
    public DrawComponent dc;
    
	public MyThread(DrawComponent dc){
		this.dc = dc;
	}
	
	public void run(){
		while (true){
		this.dc.repaint();
		}
	}
}
