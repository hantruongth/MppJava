package ui;

import java.io.IOException;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BooksWindow extends Stage implements LibWindow {
	public static final BooksWindow INSTANCE = new BooksWindow();
	
	private boolean isInitialized = false;
	
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	
	private TextArea ta;
	public void setData(String data) {
		ta.setText(data);
	}
	
	
	private Text messageBar = new Text();
	public void clear() {
		messageBar.setText("");
	}
    private BooksWindow () {}
    public void init()  {
        
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("Books.fxml"));
    		Scene scene = new Scene(root);
    		setScene(scene);
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
