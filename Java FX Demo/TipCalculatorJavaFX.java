package com.mycompany.tipcalculatorjavafx1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Title: Tip Calculator 
 * Desc:  Our First GUI
 * 
 * @author jg
 */
public class TipCalculatorJavaFX extends Application {

    // Instance Variables 
    
    private TextField billTF = new TextField("");
    private TextField serviceTF = new TextField("Great");
    private TextField tipTF = new TextField("0");
    
    public void start(Stage primaryStage) 
    {   
        tipTF.setDisable(true); // Set it so it displays as a TextBox
        
                    // Instead of Llambda Expression
                    // Let's use an inner class to make it easier to understand 
                    
//                    @Override
//                    /* In a GUI when an event happend 
//                     1. Get the data from the GUI - Get Input 
//                     2. Do the logic - Do Processing
//                     3. Update the screen - Display Results 
//                     */
//                    public void handle(ActionEvent e)
//                    {
//                    }
        Label billLbl = new Label("Enter Bill: ");
        Label serviceLbl = new Label("Enter Service: ");
        Label tipLbl = new Label("Tip: ");
        Button calcTipBtn = new Button("CalcTip");
        calcTipBtn.setOnAction(new calcButtonHandler());
        Button resetBtn = new Button("Start Over");
        
        resetBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override 
            public void handle(ActionEvent e)
            {
                billTF.setText("");
                tipTF.setText("0");
                serviceTF.setText("Great");
                // As that the cursor be put in that textbox 
                billTF.requestFocus();
            }
        });
        
        // Create containers for display
//        HBox hBox1 = new HBox(billLbl, billTF);
//        HBox hBox2 = new HBox(serviceLbl, serviceTF);
//        HBox hBox3 = new HBox(tipLbl, tipTF);
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.add(billLbl, 0,0);
        grid.add(billTF, 1,0);
        grid.add(serviceLbl, 0,1);
        grid.add(serviceTF, 1,1);
        grid.add(tipLbl, 0,2);
        grid.add(tipTF, 1,2);
        HBox buttonBox = new HBox(20,calcTipBtn, resetBtn);
        
        
        // Vertical Box (Left Labels for GUI)
        VBox box = new VBox(30, grid, buttonBox);
        box.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        // Add the box to the scene
        Scene scene = new Scene(box, 400, 300);
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene); // Add the scene to the stage
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    class calcButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle (ActionEvent e)
        {
            String service = serviceTF.getText();
            String billStr = billTF.getText();

            // This should be in a try catch
            double bill  = Double.parseDouble(billStr);
            double tip;
            double salesTax = 0.056;
            switch(service.toUpperCase())
            {
                case "Bad" : tip = bill * .10; break; 
                case "Fair" : tip = bill * .15; break; 
                default : tip = bill * .20; 
            }
            tip = (salesTax * tip) + tip;
            tipTF.setText("$" + tip);
        }
    }
    
}