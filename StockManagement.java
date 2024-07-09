
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;

public class StockManagement extends Application {
	static Scanner input = new Scanner(System.in);
	
	 @Override
	    public void start(Stage primaryStage) {
	        
	    	// Create a root BorderPane
	        BorderPane root = new BorderPane();

	        // Set padding for the root pane
	        root.setPadding(new Insets(20));
	        
	        // Navigation bar
	        VBox navigationBar = new VBox(10);
	        navigationBar.setPadding(new Insets(10));
	        navigationBar.setAlignment(Pos.CENTER);

	        // Create a VBox to hold the welcome message, date-time, group members and name input
	        VBox vBox = new VBox(10);
	        vBox.setPadding(new Insets(10));
	        vBox.setAlignment(Pos.CENTER);

	        // Create and format date-time label
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        Label dateTimeLabel = new Label("Current Date and Time: " + dtf.format(LocalDateTime.now()));
	        dateTimeLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 17;");

	        // Create labels for welcome message
	        Label welcomeLabel = new Label("Welcome to the Stock Management System (SMS) !");
	        welcomeLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 20;");
	        
	        // Create labels for group members
	        Label groupMembersLabel = new Label("\nGroup Members:\n1. Ong Yi Sheng\n2. Desmond Ho Jia Shen\n3. Tharini A/P Vijesh Kumar\n4. Seow Yi Xuan");
	        groupMembersLabel.setStyle("-fx-font-family: 'Times New Roman';  -fx-font-size: 17;");
	      
	        Label nameLabel = new Label("\nPlease Enter Your Full Name");
	        nameLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16;");

	        // Create TextField for user to enter their name
	        TextField nameField = new TextField();
	        nameField.setPromptText("Full Name");
	        nameField.setMaxWidth(200);
	        nameField.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16;");

	        // Button to confirm name entry
	        Button confirmNameButton = new Button("Confirm Name");
	        Label userIDLabel = new Label("\n\nUser ID will be displayed here.");
	        userIDLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16;");

	        // Set the action for the confirm name button
	        confirmNameButton.setOnAction(e -> {
	            String inputName = nameField.getText().trim();
	            // Create a UserInfo instance
	            UserInfo user = new UserInfo(inputName);
	            if (!inputName.isEmpty() && inputName.matches("[a-zA-Z ]+")) {
	                user.setName(inputName);  // Use setName to update name and automatically generate userID
	                userIDLabel.setText("User ID: " + user.getUserID());
	    			Stage stage2 = new Stage();
	    			VBox v2 = new VBox();
	    			stage2.setTitle("Add Product");
	    			Label t1 = new Label("Do you want to add the product? (1 - YES , 0 -NO)");
	    			TextField inputField = new TextField();
	    			v2.getChildren().addAll(t1, inputField);
	    		    Button submitButton = new Button("Submit");
	    		    v2.getChildren().add(submitButton);
	    		    v2.setAlignment(Pos.CENTER);
	    		    submitButton.setOnAction(e2 -> {
	    		    	stage2.close();
	    		        int choice = Integer.parseInt(inputField.getText());
	    		        if (choice != 0 && choice != 1 ) {
	    		            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid index. Please enter a valid index.");
	    		            alert.showAndWait();
	    		        } else {
	    		        	
	    		        	if(choice == 1) 
	    					{
	    						boolean bigmenu_loop = true;
	    		        		Product[]product = null;
	    		    			Product[] defaultproduct = new Product[4];
	    		    			defaultproduct[0] = new TV("null","null","null","null",0,0,0);
	    		    			defaultproduct[3] = new TV("Samsung","IPS","1920x1080","27inch",3,2000,000001);
	    		    			defaultproduct[1] = new Refrigerator("LG","Double Door","Red",24,5,600,000017);
	    		    			defaultproduct[2] = new TV("Apple","Oled","4k","62inch",7,10000,000003);
	    						product = new Product[4 + maximum_product(input)];
	    						primaryStage.close();
	    						for (int i = 4; i < product.length; i++) {
	    							for (int j = 0; j < 4; j++) {
	    								product[j] = defaultproduct[j];
	    							}
	    							product[i] = new TV("null","null","null","null",0,0,0);
	    					}
	    						for (int i = 0; i < product.length - 4; i++) {
	    							addProduct(product,input);

	    						}
	    						while (bigmenu_loop) {
	    							Execution_menu(menu_choice(product,input),product,input);		
	    							}
	    						}
	    					
	    					else
	    					{	
	    						Product[]product = null;
	    						Product[] defaultproduct = new Product[4];
	    						defaultproduct[0] = new TV("null","null","null","null",0,0,0);
	    						defaultproduct[3] = new TV("Samsung","IPS","1920x1080","27inch",3,2000,000001);
	    						defaultproduct[1] = new Refrigerator("LG","Double Door","Red",24,5,600,000017);
	    						defaultproduct[2] = new TV("Apple","Oled","4k","62inch",7,10000,000003);
	    						product = new Product[4];
	    							for (int j = 0; j < 4; j++) 
	    							{
	    								product[j] = defaultproduct[j];
	    							}
	    							boolean bigmenu_loop = true;
	    							while (bigmenu_loop) {
	    							Execution_menu(menu_choice(product,input),product,input);		
	    							}
	    					}
	    					
	    					//Scene // Close the stage after setting the choice
	    		        }
	    		    });
	    		    
	    		    Scene scene2 = new Scene(v2, 400, 300);
	    		    stage2.setScene(scene2);
	    		    stage2.show();
	    					
	            } else {
	                userIDLabel.setText("Invalid input. Please use only letters and spaces.");
	            }
	        });

	        // Add labels to VBox
	        vBox.getChildren().addAll(welcomeLabel, dateTimeLabel, groupMembersLabel, nameLabel, nameField, confirmNameButton, userIDLabel);

	        // Set the VBox as the center of the BorderPane
	        root.setCenter(vBox);
	        
	     // Create the scene and set it on the stage
	        Scene scene = new Scene(root, 800, 450);
	        primaryStage.setTitle("Stock Management System");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	     
			
			input.close();
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
		public static int maximum_product(Scanner input)
		{

			Stage stage = new Stage();
		    stage.setTitle("Number product storing");
		    
		    VBox vbox = new VBox();
		    vbox.setSpacing(10);    
		    vbox.setAlignment(Pos.CENTER);
		    
		    Label promptLabel = new Label("Please enter the number of product that want to store in the system: ");
		    TextField inputField = new TextField();
		    vbox.getChildren().addAll(promptLabel, inputField);
		    Button submitButton = new Button("Submit");
		    vbox.getChildren().add(submitButton);
		    
		    AtomicInteger maxNum_product = new AtomicInteger(); // Using AtomicInteger to hold the value
		    
		    submitButton.setOnAction(e -> {
		        int choice = Integer.parseInt(inputField.getText());
		        if (choice < 0 ) {
		            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid choice. Please enter a valid index.");
		            alert.showAndWait();
		        } else {
		        	maxNum_product.set(choice);
		            stage.close(); // Close the stage after setting the choice
		        }
		    });
		    
		    Scene scene = new Scene(vbox, 600, 300);
		    stage.setScene(scene);
		    stage.showAndWait();
		    
		    return maxNum_product.get(); 
		}
		
		public static int ProductArray(Product[] product, Scanner input) {
		    Stage stage = new Stage();
		    stage.setTitle("Product Array");
		    
		    VBox vbox = new VBox();
		    vbox.setSpacing(10);    
		    vbox.setAlignment(Pos.CENTER);
		    for (int i = 1; i < product.length; i++) {
		        Text text = new Text((i ) + ": " + product[i].getName_product());
		        vbox.getChildren().add(text);
		    }
		    
		    Label promptLabel = new Label("Please enter the index of product that you want to update:");
		    TextField inputField = new TextField();
		    vbox.getChildren().addAll(promptLabel, inputField);
		    Button submitButton = new Button("Submit");
		    vbox.getChildren().add(submitButton);
		    
		    AtomicInteger product_choice = new AtomicInteger(); // Using AtomicInteger to hold the value
		    
		    submitButton.setOnAction(e -> {
		        int choice = Integer.parseInt(inputField.getText());
		        if (choice < 0 || choice >= product.length) {
		            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid choice. Please enter a valid index.");
		            alert.showAndWait();
		        } else {
		            product_choice.set(choice);
		            stage.close(); // Close the stage after setting the choice
		        }
		    });
		    
		    Scene scene = new Scene(vbox, 400, 300);
		    stage.setScene(scene);
		    stage.showAndWait();
		    
		    return product_choice.get(); // Retrieve the choice from AtomicInteger and return
		}

		public static int menu_choice(Product[] product, Scanner input)
		{
			
			 	Stage stage = new Stage();
			    stage.setTitle("Menu");
			    
			    VBox vbox = new VBox();
			    vbox.setSpacing(10);    
			    vbox.setAlignment(Pos.CENTER);
			   
			    
			    Label promptLabel = new Label("1. View products \n2. Add stock \n3. Deduct stock \n4. Discontinue product\n0. Exit\nPlease enter a menu option :");
			    TextField inputField = new TextField();
			    vbox.getChildren().addAll(promptLabel, inputField);
			    Button submitButton = new Button("Submit");
			    vbox.getChildren().add(submitButton);
			    
			    AtomicInteger menu_choice = new AtomicInteger(); // Using AtomicInteger to hold the value
			    
			    submitButton.setOnAction(e -> {
			        int choice = Integer.parseInt(inputField.getText());
			        if (choice < 0 || choice >= 5) {
			            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid choice. Please enter a valid index.");
			            alert.showAndWait();
			        } else {
			        	menu_choice.set(choice);
			            stage.close(); // Close the stage after setting the choice
			        }
			    });
			    
			    Scene scene = new Scene(vbox, 800, 300);
			    stage.setScene(scene);
			    stage.showAndWait();
			    
			    return menu_choice.get(); 
		}
		
		public static  void addStock(Product [] product, Scanner input)
		{
			int index = ProductArray(product, input);
			
			 Stage stage = new Stage();
			    stage.setTitle("Add Stock");
			    
			    VBox vbox = new VBox();
			    vbox.setSpacing(10);    
			    vbox.setAlignment(Pos.CENTER);
			   
			    
			    Label promptLabel = new Label("PLease enter the number of product adding: ");
			    TextField inputField = new TextField();
			    vbox.getChildren().addAll(promptLabel, inputField);
			    Button submitButton = new Button("Submit");
			    vbox.getChildren().add(submitButton);
			    
			    AtomicInteger add_product = new AtomicInteger(); // Using AtomicInteger to hold the value
			    
			    submitButton.setOnAction(e -> {
			        int choice = Integer.parseInt(inputField.getText());
			        if (choice < 0 ) {
			            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid choice. Please enter a valid index.");
			            alert.showAndWait();
			            
			        }
			        else if(product[index].getStatus_product() == false)
			        {
			        	Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to add stock to unavailable product list.");
			            alert.showAndWait();
			        }
			        else {
			        	add_product.set(choice);
			            stage.close(); // Close the stage after setting the choice
			        }
			    });
			    
			    Scene scene = new Scene(vbox, 800, 300);
			    stage.setScene(scene);
			    stage.showAndWait();
			    product[index].addStock_product(add_product.get()); 
			    
			 
		}
		public static  void deductStock(Product [] product, Scanner input)
		{
			int index = ProductArray(product, input);

			
			 Stage stage = new Stage();
			    stage.setTitle("Deduct Stock");
			    
			    VBox vbox = new VBox();
			    vbox.setSpacing(10);    
			    vbox.setAlignment(Pos.CENTER);
			   
			    
			    Label promptLabel = new Label("PLease enter the number of product deducting: ");
			    TextField inputField = new TextField();
			    vbox.getChildren().addAll(promptLabel, inputField);
			    Button submitButton = new Button("Submit");
			    vbox.getChildren().add(submitButton);
			    
			    AtomicInteger deduct_product = new AtomicInteger(); // Using AtomicInteger to hold the value
			    
			    submitButton.setOnAction(e -> {
			        int choice = Integer.parseInt(inputField.getText());
			        if (choice < 0 ) {
			            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid choice. Please enter a valid index.");
			            alert.showAndWait();
			        } 
			        else if(product[index].getStatus_product() == false)
			        {
			        	Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to deduct stock to unavailable product list.");
			            alert.showAndWait();
			        }
			        else if(choice > product[index].getQuantity_product())
			        {
			        	Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to deduct stock due to not enough product in the list!");
			            alert.showAndWait();
			        }
			        else {
			        	deduct_product.set(choice);
			            stage.close(); // Close the stage after setting the choice
			        }

			    });
			    
			    Scene scene = new Scene(vbox, 800, 300);
			    stage.setScene(scene);
			    stage.showAndWait();
				product[index].deductStock_product(deduct_product.get()); 
		}
		
		
		public static void discontinueStatus( Product [] product, Scanner input)
		{
			Stage stage = new Stage();
		    stage.setTitle("Discontinue Status");
			int index = ProductArray(product,input);
			 VBox vbox = new VBox();
			    vbox.setSpacing(10);    
			    vbox.setAlignment(Pos.CENTER);
			   
			    
			    Label promptLabel = new Label("The product has been diactivated. ");
			    vbox.getChildren().addAll(promptLabel );
			    Button submitButton = new Button("Close");
			    vbox.getChildren().add(submitButton);
			    
			  		    
			    submitButton.setOnAction(e -> {
			            stage.close(); // Close the stage after setting the choice
			        

			    });
			    
			    Scene scene = new Scene(vbox, 400, 300);
			    stage.setScene(scene);
			    stage.showAndWait();
				product[index].setStatus_product(false);  


		 }		
			
		
		public static void Execution_menu(int menu_choice, Product [] product, Scanner input)
		{
			boolean menu_loop = true ;
			while(menu_loop)
			{
				
				switch(menu_choice)
				{
				case 1:
					display(product);
					menu_loop = false;
					break;
				case 2:
					addStock(product, input);
					menu_loop = false;

					break;
				case 3:
					deductStock(product, input);
					menu_loop = false;

					break;
				case 4:
					discontinueStatus(product,input);
					menu_loop = false;

			  	 	break;
				case 0:
					
					Stage stage = new Stage();
					stage.setTitle("END OF ASSIGNMENT");
					VBox vbox = new VBox();
					Label promptLabel = new Label("BYE BYE!\n");
				    vbox.getChildren().add(promptLabel);
				    Button submitButton = new Button(":D");
				    vbox.getChildren().add(submitButton);
				    
				    submitButton.setOnAction(e -> {
				        
				            stage.close();
				            System.exit(0);// Close the stage after setting the choice
				        }

				    );
				    vbox.setAlignment(Pos.CENTER);
				    Scene scene = new Scene(vbox, 400, 300);
				    stage.setScene(scene);
				    stage.showAndWait();
					
					
				default: 
					Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Only number 1,2,3,4,0 allowed!");
		            alert.showAndWait();
				}
			
			}
}
		public static void addProduct(Product[] product, Scanner input) 
		{
	
				Stage stage = new Stage();
		    	stage.setTitle("Add Product");
				VBox vbox = new VBox();
				vbox.setSpacing(10);    
			    vbox.setAlignment(Pos.CENTER);
			   
			    
			    Label promptLabel = new Label("Select the type of product to add:\n1. Refrigerator\n2. TV\n3. Fan\n4. Oven\nEnter your choice:");
			    TextField inputField = new TextField();
			    vbox.getChildren().addAll(promptLabel, inputField);
			    Button submitButton = new Button("Submit");
			    vbox.getChildren().add(submitButton);
			    
			    AtomicInteger menu_choice = new AtomicInteger(); // Using AtomicInteger to hold the value
			    
			    submitButton.setOnAction(e -> {
			        int choice = Integer.parseInt(inputField.getText());
			        if (choice != 1 && choice != 2 && choice!= 3 && choice!= 4 ) {
			            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Only number 1,2,3,4 allowed!");
			            alert.showAndWait();
			        } else {
			        	menu_choice.set(choice);
			            stage.close(); // Close the stage after setting the choice
			        }

			    });
			    Scene scene = new Scene(vbox, 400, 300);
			    stage.setScene(scene);
			    stage.showAndWait();
			    int menuChoice = menu_choice.get();

			    boolean zz_loop = true ;
				   // input.nextLine(); // clear the input buffer
					while(zz_loop)
				    switch (menuChoice) {
				        case 1:
				            addRefrigerator(product, input);
				            zz_loop =false;
				            break;
				        case 2:
				            addTV(product, input);
				            zz_loop =false;
				            break;
				        case 3:
				            addFan(product, input);
				            zz_loop =false;
				            break;
				        case 4:
				            addOven(product, input);
				            zz_loop =false;
				            break;
				        default:
				            System.out.println("Invalid input.");
				    }
			    


		}

		public static void addRefrigerator(Product[] product, Scanner input) 
		{
            	int index = ProductArray(product, input);

				Stage stage = new Stage();
				stage.setTitle("Add Refrigerator");

		        GridPane grid = new GridPane();
		        grid.setAlignment(Pos.CENTER);
		        grid.setHgap(10);
		        grid.setVgap(10);
		        grid.setPadding(new Insets(25, 25, 25, 25));

		        Scene scene = new Scene(grid, 800, 600);
		        stage.setScene(scene);

		        Label nameLabel = new Label("Name:");
		        grid.add(nameLabel, 0, 0);
		        TextField nameField = new TextField();
		        grid.add(nameField, 1, 0);

		        Label doorLabel = new Label("Door Design:");
		        grid.add(doorLabel, 0, 1);
		        TextField doorField = new TextField();
		        grid.add(doorField, 1, 1);

		        Label colorLabel = new Label("Color:");
		        grid.add(colorLabel, 0, 2);
		        TextField colorField = new TextField();
		        grid.add(colorField, 1, 2);

		        Label capacityLabel = new Label("Capacity:");
		        grid.add(capacityLabel, 0, 3);
		        TextField capacityField = new TextField();
		        grid.add(capacityField, 1, 3);

		        Label quantityLabel = new Label("Quantity:");
		        grid.add(quantityLabel, 0, 4);
		        TextField quantityField = new TextField();
		        grid.add(quantityField, 1, 4);

		        Label priceLabel = new Label("Price:");
		        grid.add(priceLabel, 0, 5);
		        TextField priceField = new TextField();
		        grid.add(priceField, 1, 5);

		        Label itemNumberLabel = new Label("Item Number:");
		        grid.add(itemNumberLabel, 0, 6);
		        TextField itemNumberField = new TextField();
		        grid.add(itemNumberField, 1, 6);

		        Button addButton = new Button("Add Refrigerator");
		        VBox vbox = new VBox(10);
		        vbox.setAlignment(Pos.BOTTOM_CENTER);
		        vbox.getChildren().add(addButton);
		        grid.add(vbox, 1, 7);

		        addButton.setOnAction(e -> {
		            String name = nameField.getText();
		            String doorDesign = doorField.getText();
		            String color = colorField.getText();
		            double capacity = Double.parseDouble(capacityField.getText());
		            int quantity = Integer.parseInt(quantityField.getText());
		            double price = Double.parseDouble(priceField.getText());
		            int itemNumber = Integer.parseInt(itemNumberField.getText());

		            // Create a new Refrigerator object and add it to the products array
		            
		            product[index] = new Refrigerator(name, doorDesign, color, capacity, quantity, price, itemNumber);
		            Stage stage2 = new Stage();
					stage2.setTitle("Content of Product");
					VBox vb = new VBox();
					Label promptLabel = new Label("Refrigerator added successfully.\nThe content of Product: \n");
					vb.getChildren().add(promptLabel);
		            for (int i = 1; i < product.length; i++) {
		                if (product[i] != null) {
		                  Label contentLabel = new Label(i + ": " + product[i].getName_product() + "\n");
		                  vb.getChildren().add(contentLabel);
		                  
		                }
		            }
		            Button con = new Button("Continue");
	                vb.getChildren().add(con);
	                
	                con.setOnAction(e2 ->{ stage2.close();
	                stage.close();});
		            Scene scene2 = new Scene(vb, 300, 200);
		            
		            stage2.setScene(scene2);
		            stage2.show();
		        });
		        
		        
		        
			    stage.showAndWait();
		    
		}
		
		public static void addTV(Product[] product, Scanner input) 
		{
            	int index = ProductArray(product, input);

				Stage stage = new Stage();
				stage.setTitle("Add TV");

		        GridPane grid = new GridPane();
		        grid.setAlignment(Pos.CENTER);
		        grid.setHgap(10);
		        grid.setVgap(10);
		        grid.setPadding(new Insets(25, 25, 25, 25));

		        Scene scene = new Scene(grid, 800, 600);
		        stage.setScene(scene);

		        Label nameLabel = new Label("Product Name:");
		        grid.add(nameLabel, 0, 0);
		        TextField nameField = new TextField();
		        grid.add(nameField, 1, 0);

		        Label screenLabel = new Label("Screen Type:");
		        grid.add(screenLabel, 0, 1);
		        TextField screenField = new TextField();
		        grid.add(screenField, 1, 1);

		        Label resolutionLabel = new Label("Resolution:");
		        grid.add(resolutionLabel, 0, 2);
		        TextField resolutionField = new TextField();
		        grid.add(resolutionField, 1, 2);

		        Label dsizeLabel = new Label("Display Size:");
		        grid.add(dsizeLabel, 0, 3);
		        TextField dsizeField = new TextField();
		        grid.add(dsizeField, 1, 3);

		        Label quantityLabel = new Label("Quantity:");
		        grid.add(quantityLabel, 0, 4);
		        TextField quantityField = new TextField();
		        grid.add(quantityField, 1, 4);

		        Label priceLabel = new Label("Price:");
		        grid.add(priceLabel, 0, 5);
		        TextField priceField = new TextField();
		        grid.add(priceField, 1, 5);

		        Label itemNumberLabel = new Label("Item Number:");
		        grid.add(itemNumberLabel, 0, 6);
		        TextField itemNumberField = new TextField();
		        grid.add(itemNumberField, 1, 6);

		        Button addButton = new Button("Add TV");
		        VBox vbox = new VBox(10);
		        vbox.setAlignment(Pos.BOTTOM_CENTER);
		        vbox.getChildren().add(addButton);
		        grid.add(vbox, 1, 7);

		        addButton.setOnAction(e -> {
		            String name = nameField.getText();
		            String screen_type = screenField.getText();
		            String resolution = resolutionField.getText();
		            String display_size = dsizeField.getText();
		            int quantity = Integer.parseInt(quantityField.getText());
		            double price = Double.parseDouble(priceField.getText());
		            int itemNumber = Integer.parseInt(itemNumberField.getText());

		            // Create a new TV object and add it to the products array
		            
		            product[index] = new TV(name, screen_type, resolution, display_size, quantity, price, itemNumber);
		            Stage stage2 = new Stage();
					stage2.setTitle("Content of Product");
					VBox vb = new VBox();
					Label promptLabel = new Label("TV added successfully.\nThe content of Product: \n");
					vb.getChildren().add(promptLabel);
		            for (int i = 1; i < product.length; i++) {
		                if (product[i] != null) {
		                  Label contentLabel = new Label(i + ": " + product[i].getName_product() + "\n");
		                  vb.getChildren().add(contentLabel);
		                }
		            }
		            Button con = new Button("Continue");
	                vb.getChildren().add(con);
	                
	                con.setOnAction(e2 ->{ stage2.close();
	                stage.close();});
		            Scene scene2 = new Scene(vb, 300, 200);
		            
		            stage2.setScene(scene2);
		            stage2.show();
		        });
		        
		        
		        
			    stage.showAndWait();
		       
		    
		}
		
		public static void addFan(Product[] product, Scanner input) 
		{
            	int index = ProductArray(product, input);

				Stage stage = new Stage();
				stage.setTitle("Add Fan");

		        GridPane grid = new GridPane();
		        grid.setAlignment(Pos.CENTER);
		        grid.setHgap(10);
		        grid.setVgap(10);
		        grid.setPadding(new Insets(25, 25, 25, 25));

		        Scene scene = new Scene(grid, 800, 600);
		        stage.setScene(scene);

		        Label nameLabel = new Label("Product Name:");
		        grid.add(nameLabel, 0, 0);
		        TextField nameField = new TextField();
		        grid.add(nameField, 1, 0);

		        Label fanLabel = new Label("Fan Type:");
		        grid.add(fanLabel, 0, 1);
		        TextField fanField = new TextField();
		        grid.add(fanField, 1, 1);

		        Label colorLabel = new Label("Color:");
		        grid.add(colorLabel, 0, 2);
		        TextField colorField = new TextField();
		        grid.add(colorField, 1, 2);

		        Label bcountLabel = new Label("Blade Count:");
		        grid.add(bcountLabel, 0, 3);
		        TextField bcountField = new TextField();
		        grid.add(bcountField, 1, 3);
		        
		        Label rpmLabel = new Label("RPM:");
		        grid.add(rpmLabel, 0, 4);
		        TextField rpmField = new TextField();
		        grid.add(rpmField, 1, 4);

		        Label quantityLabel = new Label("Quantity:");
		        grid.add(quantityLabel, 0, 5);
		        TextField quantityField = new TextField();
		        grid.add(quantityField, 1, 5);

		        Label priceLabel = new Label("Price:");
		        grid.add(priceLabel, 0, 6);
		        TextField priceField = new TextField();
		        grid.add(priceField, 1, 6);

		        Label itemNumberLabel = new Label("Item Number:");
		        grid.add(itemNumberLabel, 0, 7);
		        TextField itemNumberField = new TextField();
		        grid.add(itemNumberField, 1, 7);

		        Button addButton = new Button("Add Fan");
		        VBox vbox = new VBox(10);
		        vbox.setAlignment(Pos.BOTTOM_CENTER);
		        vbox.getChildren().add(addButton);
		        grid.add(vbox, 1, 8);

		        addButton.setOnAction(e -> {
		            String name = nameField.getText();
		            String fan_type = fanField.getText();
		            String color = colorField.getText();
		            int blade_count = Integer.parseInt(bcountField.getText());
		            int rpm = Integer.parseInt(rpmField.getText());
		            int quantity = Integer.parseInt(quantityField.getText());
		            double price = Double.parseDouble(priceField.getText());
		            int itemNumber = Integer.parseInt(itemNumberField.getText());

		            // Create a new Fan object and add it to the products array
		            
		            product[index] = new Fan(name, fan_type, color, blade_count, rpm, quantity, price, itemNumber);
		            Stage stage2 = new Stage();
					stage2.setTitle("Content of Product");
					VBox vb = new VBox();
					Label promptLabel = new Label("Fan added successfully.\nThe content of Product: \n");
					vb.getChildren().add(promptLabel);
		            for (int i = 1; i < product.length; i++) {
		                if (product[i] != null) {
		                  Label contentLabel = new Label(i + ": " + product[i].getName_product() + "\n");
		                  vb.getChildren().add(contentLabel);
		                }
		            }
		            Button con = new Button("Continue");
	                vb.getChildren().add(con);
	                
	                con.setOnAction(e2 ->{ stage2.close();
	                stage.close();});
		            Scene scene2 = new Scene(vb, 300, 200);
		            
		            stage2.setScene(scene2);
		            stage2.show();
		        });
		        
		        
		        
			    stage.showAndWait();
		    
		}
		
		public static void addOven(Product[] product, Scanner input) 
		{
            	int index = ProductArray(product, input);

				Stage stage = new Stage();
				stage.setTitle("Add Oven");

		        GridPane grid = new GridPane();
		        grid.setAlignment(Pos.CENTER);
		        grid.setHgap(10);
		        grid.setVgap(10);
		        grid.setPadding(new Insets(25, 25, 25, 25));

		        Scene scene = new Scene(grid, 800, 600);
		        stage.setScene(scene);

		        Label nameLabel = new Label("Name:");
		        grid.add(nameLabel, 0, 0);
		        TextField nameField = new TextField();
		        grid.add(nameField, 1, 0);

		        Label ovenLabel = new Label("Oven Type:");
		        grid.add(ovenLabel, 0, 1);
		        TextField ovenField = new TextField();
		        grid.add(ovenField, 1, 1);

		        Label colorLabel = new Label("Color:");
		        grid.add(colorLabel, 0, 2);
		        TextField colorField = new TextField();
		        grid.add(colorField, 1, 2);

		        Label capacityLabel = new Label("Capacity:");
		        grid.add(capacityLabel, 0, 3);
		        TextField capacityField = new TextField();
		        grid.add(capacityField, 1, 3);

		        Label quantityLabel = new Label("Quantity:");
		        grid.add(quantityLabel, 0, 4);
		        TextField quantityField = new TextField();
		        grid.add(quantityField, 1, 4);

		        Label priceLabel = new Label("Price:");
		        grid.add(priceLabel, 0, 5);
		        TextField priceField = new TextField();
		        grid.add(priceField, 1, 5);

		        Label itemNumberLabel = new Label("Item Number:");
		        grid.add(itemNumberLabel, 0, 6);
		        TextField itemNumberField = new TextField();
		        grid.add(itemNumberField, 1, 6);

		        Button addButton = new Button("Add Oven");
		        VBox vbox = new VBox(10);
		        vbox.setAlignment(Pos.BOTTOM_CENTER);
		        vbox.getChildren().add(addButton);
		        grid.add(vbox, 1, 7);

		        addButton.setOnAction(e -> {
		            String name = nameField.getText();
		            String oven_type = ovenField.getText();
		            String color = colorField.getText();
		            double capacity = Double.parseDouble(capacityField.getText());
		            int quantity = Integer.parseInt(quantityField.getText());
		            double price = Double.parseDouble(priceField.getText());
		            int itemNumber = Integer.parseInt(itemNumberField.getText());

		            // Create a new Oven object and add it to the products array
		            
		            product[index] = new Oven(name, oven_type, color, capacity, quantity, price, itemNumber);
		            Stage stage2 = new Stage();
					stage2.setTitle("Content of Product");
					VBox vb = new VBox();
					Label promptLabel = new Label("Oven added successfully.\nThe content of Product: \n");
					vb.getChildren().add(promptLabel);
		            for (int i = 1; i < product.length; i++) {
		                if (product[i] != null) {
		                  Label contentLabel = new Label(i + ": " + product[i].getName_product() + "\n");
		                  vb.getChildren().add(contentLabel);
		                }
		            }
		            Button con = new Button("Continue");
	                vb.getChildren().add(con);
	                
	                con.setOnAction(e2 ->{ stage2.close();
	                stage.close();});
		            Scene scene2 = new Scene(vb, 300, 200);
		            
		            stage2.setScene(scene2);
		            stage2.show();
		        });
		        
		        
		        
			    stage.showAndWait();
		    
		}

		public static void display(Product [] product)
		{			
			Stage stage = new Stage();
			stage.setTitle("View Product");
			VBox vb = new VBox();
			Button con = new Button("Continue");
            for (int i = 1; i < product.length; i++) {
                
                  Label contentLabel = new Label(i +")\n" + product[i] + "\n\n\n");
                  contentLabel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 16) );
                  vb.getChildren().add(contentLabel);
                
            }
            vb.setAlignment(Pos.TOP_LEFT);
            vb.getChildren().add(con);
            con.setOnAction(e -> {
            	stage.close();
            });
            Scene scene = new Scene(vb, 800, 1000);            
            stage.setScene(scene);
		    stage.showAndWait();
		}
		
}

	




