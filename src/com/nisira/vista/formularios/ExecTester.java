package com.nisira.vista.formularios;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExecTester {
   JTextField commandField;
   JTextArea outputText;
   /**
    * Shows a simple Swing UI for testing exec().   This is handy when
    * you want to try several different exec()s.
    */
   public void showUI()
   {
      JFrame frame = new JFrame("Runtime.exec() Tester");

      // frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE  );
      // Sun docs say use JFrame.EXIT_ON_CLOSE, but it doesn't exist,
      // (in JDK 1.2, at least) so I'll add this window adapter:
      frame.addWindowListener( new WindowAdapter() 
       {
         public void windowClosing(WindowEvent e) 
         {
            System.exit(0);
         }
       }
      );

      Container pane = frame.getContentPane();
      pane.setLayout( new java.awt.FlowLayout() );

      pane.add(new JLabel("Enter your command:"));
      
      commandField = new JTextField("notepad c:\\windows\\win.ini", 30);
      pane.add(commandField);
      
      final JButton goButton = new JButton("Execute It!");
      pane.add(goButton);
      
      goButton.addActionListener( new goButtonListener() );     

      pane.add( new JLabel( "Results of execution:" ) );
      outputText = new JTextArea(5,50);
      pane.add( new JScrollPane(outputText) );
      
      frame.pack();
      frame.setSize( 600, 200 );
      // Yes, I'm ashamed of hard-coding the window size, but the default
      // JFrame wasn't coming up nicely arranged.   This could probably
      // be fixed by fooling with more frames and layouts, but I'll leave
      // that as an exercise for whomever wishes to pursue it.

      frame.setVisible(true);         
   }

   /**
    * Runs the exec() and adds its output to the results area.
    */
   class goButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         outputText.append( runExec( commandField.getText() ) );
      }
   }

   /**
    * Executes Runtime.exec() and returns the results is a 
    * human-readable string.
    *
    * @param cmd The command to send to Runtime.exec().
    */
   public static String runExec( String cmd )
   {
      String results = "Results of Runtime.getRuntime().exec( \"" + 
                       cmd + "\" ):";
      try
      {
         Runtime.getRuntime().exec( cmd );
         results += " No problem.";
      }
      catch( java.io.IOException e )
      {
         results += "\n   " + e.toString();
      }

      return results + "\n";
   }

   /**
    * Displays the UI or simply runs the command line, depending upon
    * what's specified by args[0].
    * @param args The usual thing.
    */
   public static void main( String[] args )
   {
      if( args.length == 0 || args[0].equals( "/showui" ) )
         (new ExecTester()).showUI();
      else
         System.out.println( "Runtime.getRuntime().exec( \"" + 
                             args[0] + "\" ): " + runExec(args[0]));
   }

}
