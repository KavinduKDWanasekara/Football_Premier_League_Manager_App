package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {

    Stage window;
    Scene scene1;

    public TableView list() {
        MyGymManager gym = new MyGymManager();
        TableView<DefaultMember> detailedTable=new TableView<>();

        final Label lb1 = new Label("Address book");

        detailedTable.setEditable(true);

        TableColumn memberId = new TableColumn("Member ID");
        memberId.setPrefWidth(125);
        memberId.setCellValueFactory(new PropertyValueFactory<>("memberFirstName"));
        TableColumn memberFName = new TableColumn("First Name");
        memberFName.setPrefWidth(125);
        memberFName.setCellValueFactory(new PropertyValueFactory<>("memberLastName"));
        TableColumn memberLName = new TableColumn("Last Name");
        memberLName.setPrefWidth(125);
        memberLName.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        TableColumn memberSchool = new TableColumn("School Name");
        memberSchool.setPrefWidth(125);
        memberSchool.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        TableColumn memberAge = new TableColumn("Age");
        memberAge.setPrefWidth(125);
        memberAge.setCellValueFactory(new PropertyValueFactory<>("memberAge"));



        detailedTable.getColumns().addAll(memberId,memberFName,memberLName,memberSchool,memberAge);
        Database database1 = new Database();
        detailedTable.setItems(database1.dMemTable());


        return detailedTable;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Double IT Fitness");

        BorderPane loginPage = new BorderPane();
        loginPage.setLeft(list());

        scene1 = new Scene(loginPage,625,600);

        window.setScene(scene1);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
