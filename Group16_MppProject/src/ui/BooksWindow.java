package ui;


import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
	
    private BooksWindow () {}
    public void init()  {
        
        try {
        	
            URL location = getClass().getResource("/ui/TableBooks.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            Scene scene = new Scene(fxmlLoader.load());
    		setScene(scene);
    		
    		
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
