package com.company;

import java.awt.*;
import java.awt.event.*;

/**
 * The fast CS203_GUI.
 */
public class CS203_GUI extends Frame implements ActionListener
{
    // instance variables - replace the example below with your own
    private Label     register_label;  // Declare a Label component 
    private TextField register_value;  // Declare a TextField component 
    private Button    time_step;       // Declare a Button component
    private Button    exit_button;     // Declare a Button component

    private int time = 0;              // Counter's value

    /**
     * Constructor for objects of class CS203_GUI
     */
    public CS203_GUI()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
        // the components from left-to-right, and flow to next row from top-to-bottom.

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());

        time_step = new Button("Step");          // construct the Button component
        p1.add(time_step);                       // "super" Frame adds Button
        time_step.addActionListener(this);

        exit_button = new Button("Exit");        // construct the Button component
        p1.add(exit_button);                     // "super" Frame adds Button
        exit_button.addActionListener(this);

        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());

        register_label = new Label("PC: ");     // construct the Label component
        p2.add(register_label);                 // "super" Frame adds Label

        register_value = new TextField("0", 10); // construct the TextField component
        register_value.setEditable(false);       // set to read-only
        p2.add(register_value);                  // "super" Frame adds TextField

        setTitle("CS203 Simple GUI");  // "super" Frame sets its title
        setSize(250, 100);             // "super" Frame sets its initial window size

        // add subpanels to the primary frame
        add(p1);
        add(p2);

        setVisible(true);
    }

    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getActionCommand().equals("Step")) {

            ++time; // increase the counter value

            // Display the counter value on the TextField tfCount
            register_value.setText(time + ""); // convert int to String

        } else if (evt.getActionCommand().equals("Exit")) {

            System.exit(0);  // Terminate the program

        } else {

            System.out.println("Unknown action command " + evt.getActionCommand());
        }
    }


}