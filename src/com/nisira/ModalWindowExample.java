package com.nisira;
import java.awt.*;
import java.awt.event.*;

public class ModalWindowExample extends Frame {
	  public ModalWindowExample() {
	    super("ModalWindowExample Frame");

	    add(new TextArea(), BorderLayout.CENTER);
	    Button b = new Button("Show modal window");
	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        showModalWindow();
	      }});
	    add(b, BorderLayout.NORTH);
	    pack();
	    setLocation(100, 200);
	    setVisible(true);
	  }

	  private void showModalWindow() {
	    class HidingWindow extends Window {
		Button b = new Button("Close");

	      public HidingWindow(Frame frame) {
	        super(frame);
	        setBackground(SystemColor.control);
	  	setLayout(new BorderLayout());

	       b.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		setVisible(false);			
	      	}});

	        add(b, BorderLayout.NORTH);
	      }

	      public Insets getInsets() {
	        return new Insets(2,2,2,2);
	      }

	      public void setVisible(boolean show) {
	        super.setVisible(show);
	        if (!show) {
	          ModalWindowExample.this.setEnabled(true);
	          ModalWindowExample.this.toFront();

	        }else{
	        	toFront();
	          b.requestFocus();
	        }
	      }

	      public void paint(Graphics g) {
	        Dimension size = getSize();
	        Color c = g.getColor();
	        g.setColor(SystemColor.control);
	        g.fill3DRect(0,0, size.width, size.height, true);
	        g.setColor(c);
	        super.paint(g);
	      }
	    };

	    final Window w = new HidingWindow(this);

	    w.add(new TextArea(), BorderLayout.CENTER);

	    w.pack();
	    w.setLocation(400, 400);

	    setEnabled(false);
	    w.setVisible(true);
	  }

	  public static void main(String args[]) {
	    Frame f = new ModalWindowExample();
	    f.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {System.exit(0);}
	    });
	  }
	}