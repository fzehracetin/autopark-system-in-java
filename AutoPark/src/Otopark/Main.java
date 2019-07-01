package Otopark;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Subscription subscription1 = new Subscription("34Faz34",new Date(5,5,2000),new Date(5,5,2020));
        RegularVehicle vehicle2 = new RegularVehicle("34 EP 6932");
        OfficialVehicle vehicle3 = new OfficialVehicle("35 HB 1512");

        Date.setToday(new Date(4,5,2019));
        AutoPark autoPark = new AutoPark(12.5,15);
        //autoPark.addVehicle(subscription1.getVehicle());
        //autoPark.vehicleEnters("34Faz34",new Time(23,0),false,Date.getToday());
        autoPark.vehicleEnters("34 EP 6932", new Time(23,15),false, Date.getToday());
       // autoPark.vehicleEnters("35 HB 1512",new Time(15,45),true,Date.getToday());
        //autoPark.introduceSelf();
        autoPark.vehicleExits("34 EP 6932",new Date(5,5,2019),new Time(7,0));
        System.out.println("\n\n");
        System.out.println(autoPark.getIncomeDaily());
        autoPark.introduceSelf();
        autoPark.vehicleEnters("34 EP 6932", new Time(17,30),false, new Date(7,5,2019));
        autoPark.vehicleExits("34 EP 6932",new Date(9,5,2019),new Time(17,15));
        autoPark.introduceSelf();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
