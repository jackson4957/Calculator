/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;




import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 *
 * @author jamesjackson
 */
public class Calculator extends Application {
  
  private TextField tfXValue = new TextField();
  private TextField tfYValue = new TextField();
  private TextField tfOutput = new TextField();
  private Label label = new Label("Please select an operator and then click Claculate");
  
    
    public void start(Stage primaryStage) throws NumberFormatException {
        
        Font fontBold = Font.font("Arial", 
        FontWeight.BOLD, 20);
        label.setStyle("-fx-text-fill: blue");
        
        HBox radioButtonPane = new HBox(20);
        radioButtonPane.setPadding(new Insets(5, 5, 5, 5)); 
        radioButtonPane.setStyle("-fx-border-color: black");
       
        RadioButton rbAdd = new RadioButton("+");
        RadioButton rbSub = new RadioButton("-");
        RadioButton rbDiv = new RadioButton("/");
        RadioButton rbMult = new RadioButton("*");
        Button btCalc = new Button("Calculate");
        Button btReset = new Button("Reset");
        BorderPane pane = new BorderPane();
        rbAdd.setFont(fontBold);
        rbSub.setFont(fontBold);
        rbDiv.setFont(fontBold);
        rbMult.setFont(fontBold);
        
        
        radioButtonPane.getChildren().addAll(rbAdd, rbSub, rbDiv, rbMult, btCalc
        , btReset);
        pane.setTop(radioButtonPane);

       
        ToggleGroup group = new ToggleGroup();
        rbAdd.setToggleGroup(group);
        rbSub.setToggleGroup(group);
        rbDiv.setToggleGroup(group);
        rbMult.setToggleGroup(group);
    
        GridPane textPane = new GridPane(); 
        textPane.setHgap(5);
        textPane.setVgap(5);


        textPane.add(new Label("Enter first number (X):"), 0, 0);
        textPane.add(tfXValue, 1, 0);
        textPane.add(new Label("Enter second number (Y):"), 0, 1);
        textPane.add(tfYValue, 1, 1);
        textPane.add(new Label("Output:"), 0, 2);
        textPane.add(tfOutput, 1, 2);

        textPane.setAlignment(Pos.CENTER);
        tfXValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfYValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfOutput.setAlignment(Pos.BOTTOM_RIGHT);
        tfXValue.setFont(fontBold);
        tfYValue.setFont(fontBold);
        tfOutput.setFont(fontBold);
        pane.setCenter(textPane);
       
        StackPane bottomBorder = new StackPane(label);
        bottomBorder.setPadding(new Insets(10, 10, 10, 10));
        bottomBorder.setStyle("-fx-border-color: black");
   
        pane.setBottom(bottomBorder);
           
        btCalc.setOnAction(e -> {
              try{
                   float xNumber = Float.parseFloat(tfXValue.getText());
                   float yNumber = Float.parseFloat(tfYValue.getText());
                   float output ;
              
                   //          try { x.getText() to a double.
                   //                y.getText() to a double.
                    
                   if (rbAdd.isSelected()) {
                       try{
                       output = xNumber + yNumber;
                       tfOutput.setText(String.format(xNumber + " + " + yNumber + " = " + output));
                       label.setText("GUI Calculator");
                       }catch(Exception ex){
                       label.setText("X and Y must be numbers");
               }
                   }
                    if (rbSub.isSelected()) {
                       try{
                       output = xNumber - yNumber;
                       tfOutput.setText(String.format(xNumber + " - " + yNumber + " = " + output));
                       label.setText("GUI Calculator");
                       }catch(Exception ex){
                   label.setText("X and Y must be numbers");
               }
                   }
                    if (rbMult.isSelected()) {
                      try{
                       output = xNumber * yNumber;
                       tfOutput.setText(String.format(xNumber + " * " + yNumber + " = " + output));
                       label.setText("GUI Calculator");
                      }catch(Exception ex){
                   label.setText("X and Y must be numbers");
               }
                   }
                   if (rbDiv.isSelected()) {
                       try{
                       output = xNumber / yNumber;
                       tfOutput.setText(String.format(xNumber + " / " + yNumber + " = " + output));
                       label.setText("GUI Calculator");
                       }catch(Exception ex){
                   label.setText("X and Y must be numbers");
               }
                   }
              }catch(Exception ex){
                   label.setText("X and Y must be numbers");
               }
               // which radio button selected; use multile if-else
           });
           
           btReset.setOnAction(e -> reset());
   
           Scene scene = new Scene(pane, 450, 200);
           
           primaryStage.setTitle("GUI Calculator"); // Set the stage title
           primaryStage.setScene(scene); // Place the scene in the stage
           primaryStage.show(); // Display the stage
           primaryStage.show();
       
       }
                
    public void reset(){
       try {
        
       
        
        tfXValue.setText("");
        tfYValue.setText("");
        tfOutput.setText("");
        
        
       
        label.setText("Please select an operator and then click Claculate");
        
       }catch(Exception e) {
           
           label.setText("Please select an operator and then click Claculate");
           
           
       }
    }
   
    public static void main(String[] args) {
    launch(args);
  }

}
 