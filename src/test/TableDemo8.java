package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class TableDemo8 extends JFrame implements ActionListener
{
  JTable jt;

  TableDemo8 (String title)
  {
   // Pass the title to the JFrame superclass so that it appears in
   // the title bar.

   super (title);

   // Tell the program to exit when the user either selects Close
   // from the System menu or presses an appropriate X button on the
   // title bar.

   setDefaultCloseOperation (EXIT_ON_CLOSE);

   // Create a table with a default table model that specifies 10
   // rows by 10 columns dimensions.

   jt = new JTable (new DefaultTableModel (10, 10));

   // Establish blue as the selection foreground color and white as
   // the selection background color.

   jt.setSelectionBackground (Color.blue);
   jt.setSelectionForeground (Color.white);

   // Allow only a single row, a single column, or a single cell to
   // be selected.

   jt.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

   // Add the table to the center portion of the frame window's
   // content pane.

   getContentPane ().add (jt);

   // Create a panel for positioning buttons.

   JPanel jp = new JPanel ();

   // Create a "Row Selection Only" button, register the current
   // TableDemo8 object as a listener to that button's action
   // events, and add that button to the panel.

   JButton jb = new JButton ("Row Selection Only");
   jb.addActionListener (this);
   jp.add (jb);

   // Create a "Column Selection Only" button, register the current
   // TableDemo8 object as a listener to that button's action
   // events, and add that button to the panel.

   jb = new JButton ("Column Selection Only");
   jb.addActionListener (this);
   jp.add (jb);

   // Create a "Row and Column Selection" button, register the
   // current TableDemo8 object as a listener to that button's
   // action events, and add that button to the panel.

   jb = new JButton ("Row and Column Selection");
   jb.addActionListener (this);
   jp.add (jb);

   // Add the panel to the south portion of the frame window's
   // content pane.

   getContentPane ().add (jp, BorderLayout.SOUTH);

   // Establish the frame's initial size as 600x250 pixels.

   setSize (600, 250);

   // Display the frame window and all contained components.

   setVisible (true);
  }

  public void actionPerformed (ActionEvent e)
  {
   // Print selected row, column, or cell information.

   if (jt.getRowSelectionAllowed () &&
     !jt.getColumnSelectionAllowed ())
   {
     System.out.println ("Selected row = " + 
               jt.getSelectedRow ());

     System.out.println ("Focused cell column in selected row = " 
               + jt.getSelectedColumn () + "\n");
   }
   else
   if (jt.getColumnSelectionAllowed () &&
     !jt.getRowSelectionAllowed ())
   {
     System.out.println ("Selected column = " +
               jt.getSelectedColumn ());

     System.out.println ("Focused cell row in selected column = " 
               + jt.getSelectedRow () + "\n");
   }
   else
   {
     System.out.println ("Selected cell at (row, column) = (" +
               jt.getSelectedRow () + ", " +
               jt.getSelectedColumn () + ")\n");
   }

   // Identify the button that initiated the event.

   JButton jb = (JButton) e.getSource ();

   // Obtain the button's label.

   String label = jb.getText ();

   // Enable row and/or column selection, as appropriate.

   if (label.equals ("Row Selection Only"))
   {
     jt.setRowSelectionAllowed (true);
     jt.setColumnSelectionAllowed (false);
   }
   else
   if (label.equals ("Column Selection Only"))
   {
     jt.setColumnSelectionAllowed (true);
     jt.setRowSelectionAllowed (false);
   }
   else
   {
     jt.setRowSelectionAllowed (true);
     jt.setColumnSelectionAllowed (true);
   }

   // Remove the current selection to prevent confusion.

   jt.clearSelection ();
  }

  public static void main (String [] args)
  {
   // Create a TableDemo8 object, which creates the GUI.

   new TableDemo8 ("Table Demo #8");
  }
}