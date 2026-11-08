package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//--nodes--
			Label title = new Label("College student registration");
			
			//left menu
			Button dashboardBtn = new Button("Dashboard");
			Button registationBtn = new Button("Registration");
			Button coursesBtn = new Button("Courses");
			Button helpBtn = new Button("Help");
			
			//form
			Label studentId = new Label("StudentId"); 
			TextField idField = new TextField();
			
			Label nameLabel = new Label("Full Name:");
			TextField nameField = new TextField();

			Label emailLabel = new Label("Email:");
			TextField emailField = new TextField();

			Label programLabel = new Label("Program:");
			TextField programField = new TextField();
			
			//registration and clear
			Button registerBtn = new Button("Register");
			Button clearBtn = new Button("Clear");
			
			Label statusLabel = new Label();
			
			//--containers--
			HBox topBar = new HBox();
			VBox leftBar = new VBox();
			VBox centerForm = new VBox();
			GridPane studentInfo = new GridPane();
			HBox confirmation = new HBox();
			
			//--placing nodes in containers--
			topBar.getChildren().add(title);
			leftBar.getChildren().addAll(dashboardBtn, registationBtn, coursesBtn, helpBtn);
			confirmation.getChildren().addAll(registerBtn, clearBtn);
			centerForm.getChildren().addAll(studentInfo,confirmation, statusLabel);
			
			//gridpane for fields and labels
			studentInfo.add(studentId, 0, 0);
			studentInfo.add(idField, 1, 0);

			studentInfo.add(nameLabel, 0, 1);
			studentInfo.add(nameField, 1, 1);
			
			studentInfo.add(emailLabel, 0, 2);
			studentInfo.add(emailField, 1, 2);
			
			studentInfo.add(programLabel, 0, 3);
			studentInfo.add(programField, 1, 3);
			
			//--styling--
			topBar.setAlignment(Pos.CENTER);
			leftBar.setAlignment(Pos.TOP_CENTER);
			leftBar.setPadding(new Insets(20));
			confirmation.setAlignment(Pos.CENTER);
			confirmation.setSpacing(10);
			confirmation.setPadding(new Insets(50));
			studentInfo.setHgap(10);
			studentInfo.setVgap(10);
			studentInfo.setPadding(new Insets(20));
			centerForm.setSpacing(15);
			centerForm.setPadding(new Insets(20));
			
			
			//--aranging containers with borderpane--
			root.setTop(topBar);
			root.setLeft(leftBar);
			root.setCenter(centerForm);
			
			//implementing register button
			registerBtn.setOnAction(e -> {
			    String id = idField.getText().trim();
			    String name = nameField.getText().trim();
			    String email = emailField.getText().trim();
			    String program = programField.getText().trim();

			    if (id == "" || name == "" || email == "" || program =="") {
			    	statusLabel.setText("Please fill in all fields.");
			    } else {
			    	statusLabel.setText("Your submission was successful");
			    }
			});
			
			//implementing clear button
			clearBtn.setOnAction(e -> {
			    // clear each of the four fields
				idField.setText("");
				nameField.setText("");
				emailField.setText("");
				programField.setText("");
				
			    // empty the status label
				statusLabel.setText("");
			});
			
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
