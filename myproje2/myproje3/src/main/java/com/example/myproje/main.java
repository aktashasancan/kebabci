package com.example.myproje;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class main extends Application {

     static String path4 = "C:\\Users\\Hasan\\Desktop\\myproje2\\myproje3\\src\\main\\resources\\satınalınan.txt";
     static String path2= "C:\\Users\\Hasan\\Desktop\\myproje2\\myproje3\\src\\main\\resources\\yemekler.txt";
     static String path3="C:\\Users\\Hasan\\Desktop\\myproje2\\myproje3\\src\\main\\resources\\usersss.txt";



    private static Stage stg;


    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;


        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 568);
        stage.setTitle("Hasan Usta Kebab Salonu!");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws  IOException{
        launch(args);

     File file=new File("usersss.txt");
     if(!file.exists()){
         file.createNewFile();

     }

     File file2=new File("yemekler.txt");
     if(!file2.exists()){
         file2.createNewFile();
     }


     FileWriter fw=new FileWriter(file,true);
     BufferedWriter bufferedWriter=new BufferedWriter(fw);

    }
}
