package com.example.myproje;


import javax.swing.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


import static com.example.myproje.main.path2;
import static com.example.myproje.main.path3;
import static com.example.myproje.main.path4;

public class HelloController implements Initializable {
    Stage stage;

    ObservableList<yemekler>eat= FXCollections.observableArrayList();
    ObservableList<yemekler>secilen= FXCollections.observableArrayList();

    @FXML
    AnchorPane anchorpane;

    @FXML
    private Pane kullanıcıPane,siparişler_pane;

    @FXML
    TableView<yemekler>yemekTableview;
    @FXML
    private TableColumn<yemekler, String>yemekisimsütun;

    @FXML
    private TableColumn<yemekler , String>yemektürüsütun ;

    @FXML
    private TableColumn<yemekler , String>yemekfiyatısütun;


    @FXML
    TableView<yemekler>yemekTableview1;
    @FXML
    private TableColumn<yemekler, String>yemekisimsütun1;
    @FXML
    private TableColumn<yemekler, String>yemektürüsütun1;
    @FXML
    private TableColumn<yemekler, String>yemekfiyatısütun1;


    @FXML
    TableView<yemekler>siparistableview;
    @FXML
    private TableColumn<yemekler, String > kullanıcıAdı_column;
    @FXML
    private TableColumn<yemekler, String> yemekİsim_column;
    @FXML
    private TableColumn<yemekler, String> yemekTürü_column;
    @FXML
    private TableColumn<yemekler, String> yemekFiyatı_column;





    @FXML
    Pane kayitol, login, yemekPane;

    @FXML
    TextField login_kullaniciadı, kayitol_ad, kayitol_kullaniciadi, yemekİsim_textfield, yemekTürü_textfield, yemekFiyatı_textfield;

    @FXML
    PasswordField login_parola, kayitol_parola;

    @FXML
    Button login_girisbuton, login_kayitolbuton, kayitol_kayitolbuton,
            yemekEkle_btn,yemekSil_btn,siparisonayla_btn,
            kayitol_geributon,siparisGeri_btn,
            yemekback_btn, yemekback_btn2,satınal_btn,siparişler_btn;



    @FXML
    void login_girisbuton(ActionEvent event) throws IOException {





        if (event.getSource() == login_girisbuton) {
            File file = new File("usersss.txt");
            boolean isValid = false;

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(path3));
            String str = reader.readLine();

            while (str != null) {

                String arry[] = str.split(" ", 3);
                String ad = arry[0];
                String kullanıcıadi = arry[1];
                String parola = arry[2];

                if (login_kullaniciadı.getText().equals("admin") && login_parola.getText().equals("12345")) {
                    JOptionPane.showMessageDialog(null, "Admin Giriş Başarılı!");
                    yemekPane.toFront();
                    isValid = true;
                    break;
                } else if (login_kullaniciadı.getText().equals(kullanıcıadi) && login_parola.getText().equals(parola)) {

                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
                    kullanıcıPane.toFront();
                    isValid = true;

                    break;
                } else if (login_kullaniciadı.getText().equals(kullanıcıadi) && !login_parola.getText().equals(parola)) {
                    JOptionPane.showMessageDialog(null, " Şifre Hatalı");
                    login.toFront();
                    isValid = true;
                    break;
                } else {
                    str = reader.readLine();
                }
            }

            if (login_kullaniciadı.getText().equals("") || login_parola.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Boşlukları Doldurunuz!");

            } else if (!isValid) {
                JOptionPane.showMessageDialog(null, "Kullanıcı kayıtlı değil!");
            }
        }
    }

    @FXML
    void kayitol_kayitolbuton(ActionEvent event) throws IOException {

        File file = new File("usersss.txt");
        boolean isValid = false;
        if (!file.exists()) {

            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(writer);
        BufferedReader reader = new BufferedReader(new FileReader(path3));
        String str = reader.readLine();


        if (event.getSource() == kayitol_kayitolbuton) {

            while (str != null) {
                String array[] = str.split(" ", 3);
                String ad = array[0];
                String kullaniciadi = array[1];
                String sifre = array[2];

                if (kayitol_kullaniciadi.getText().equals(kullaniciadi) && !kayitol_ad.getText().equals("") && !kayitol_parola.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Kullanıcı Adı Sistemde Kayıtlıdır!");
                    kayitol.toFront();
                    isValid = true;
                    break;
                } else {

                    str = reader.readLine();
                }

            }
            if (kayitol_ad.getText().equals("") || kayitol_kullaniciadi.getText().equals("") || kayitol_parola.getText().equals(""))
             {
                JOptionPane.showMessageDialog(null, "Lütfen boşlukları doldurunuz!");
                kayitol.toFront();
            }
            else if (!isValid) {
                JOptionPane.showMessageDialog(null, "Başarıyla kayıt olundu!");
                FileWriter fileWriter=new FileWriter(path3,true);
                String wrt=kayitol_ad.getText()+" "+kayitol_kullaniciadi.getText()+" "+kayitol_parola.getText()+"\n";
                fileWriter.write(wrt);
                fileWriter.close();

            }
        }
    }
    @FXML

    void login_kayitolbuton(ActionEvent event){

        if(event.getSource() == login_kayitolbuton){
            kayitol.toFront();
        }
    }
    @FXML

    void kayitol_geributon(ActionEvent event){

        if(event.getSource() == kayitol_geributon){

            login.toFront();
        }
    }

    @FXML

    void yemekback_btn(ActionEvent event){

        if(event.getSource() == yemekback_btn){
            login.toFront();


        }
    }
    @FXML

    void siparisGeri_btn(ActionEvent event){

        if(event.getSource() == siparisGeri_btn){
            yemekPane.toFront();
        }
    }

    @FXML
    void yemekback_btn2(ActionEvent event){

        if(event.getSource() == yemekback_btn2){
            login.toFront();
        }
    }

    @FXML
    void siparisonayla_btn(ActionEvent event)throws IOException{

        if(event.getSource() == siparisonayla_btn) {
            if(siparistableview.getSelectionModel().isEmpty()){
                JOptionPane.showMessageDialog(null,"Seçim Yapmadınız!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Siparişiniz alındı!");


                int secilen1 = siparistableview.getSelectionModel().getSelectedIndex();
                siparistableview.getItems().remove(secilen1);

                String x = "";
                FileReader fr = new FileReader(path4);
                BufferedReader br = new BufferedReader(fr);
                int i = 0;
                String str;
                str = br.readLine();

                while (str != null) {

                    if (i != secilen1) {
                        x += str + "\n";


                    }
                    i++;
                    str = br.readLine();
                }
                FileWriter fw = new FileWriter(path4);
                fw.write(x);
                fw.close();

            }
        }

    }


    @FXML
    void satınal_btn(ActionEvent event) throws IOException {
        if(event.getSource()==satınal_btn){
            //buraya bişeyler gelcek.

          try {
              yemekler yy=new yemekler();
              yy.setKullaniciAdi(login_kullaniciadı.getText());


              FileWriter fw=new FileWriter(path4,true);
              BufferedWriter br=new BufferedWriter(fw);

              String text =login_kullaniciadı.getText()+" "+yemekTableview1.getSelectionModel().getSelectedItem().getIsim() +" "+ yemekTableview1.getSelectionModel().getSelectedItem().getTürü()+" "+ yemekTableview1.getSelectionModel().getSelectedItem().getFiyat() +"\n";
              fw.write(text);
              fw.close();

          }catch (Exception e){
              JOptionPane.showMessageDialog(null,"Seçim yapmadınız!");

          }



        }
    }

    @FXML
    void yemekEkle_btn(ActionEvent event){
        if(event.getSource()==yemekEkle_btn){

            eat.add(new yemekler(yemekİsim_textfield.getText(),yemekTürü_textfield.getText(),yemekFiyatı_textfield.getText()));
            FileWriter writer = null;
            try {
                writer = new FileWriter(path2, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String yeniVeri ="";
            yeniVeri = yemekİsim_textfield.getText() + " " + yemekTürü_textfield.getText() + " " + yemekFiyatı_textfield.getText() + "\n";
            try {
                writer.write(yeniVeri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @FXML
    void siparişler_btn(ActionEvent event) throws IOException {
        if(event.getSource()==siparişler_btn){
            //buraya bişeyler gelicek.

            secilen.clear();

            siparişler_pane.toFront();
            FileReader fr = new FileReader(path4);
            BufferedReader br = new BufferedReader(fr);
            String str;
            String array[] ;
            while((str = br.readLine()) != null){
                array = str.split(" ");
                yemekler y = new yemekler(array[0], array[1],array[2],array[3]);
                secilen.add(y);
            }
        }
    }


    @FXML
    void yemekSil_btn(ActionEvent event){
        if(event.getSource()==yemekSil_btn){
          try {
              String x = "";
              FileReader fr = new FileReader(path2);
              BufferedReader br=new BufferedReader(fr);
              int i=0;
              String str;
              str=br.readLine();

              while(str!=null){
                  if(i!=yemekTableview.getSelectionModel().getSelectedIndex()){
                      x+=str+"\n";
                  }i++;
                  str= br.readLine();
              }
              FileWriter fw=new FileWriter(path2);
              fw.write(x);
              fw.close();
              yemekTableview.getItems().remove(yemekTableview.getSelectionModel().getSelectedIndex());

          }catch (IOException e){
              e.printStackTrace();
          }
        }
    }
  ///////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "" ;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(line!=null){
            String veri[] = line.split(" ",3);
            String yemekisim = veri[0];
            String yemektürü = veri[1];
            String yemekfiyat = veri[2];

            eat.add(new yemekler(yemekisim,yemektürü,yemekfiyat));
            try {
                line   = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        yemekisimsütun.setCellValueFactory(new PropertyValueFactory<yemekler,String>("isim"));
        yemektürüsütun.setCellValueFactory(new PropertyValueFactory<yemekler,String>("türü"));
        yemekfiyatısütun.setCellValueFactory(new PropertyValueFactory<yemekler,String>("fiyat"));

        yemekTableview.setItems(eat);

        yemekisimsütun1.setCellValueFactory(new PropertyValueFactory<yemekler,String>("isim"));
        yemektürüsütun1.setCellValueFactory(new PropertyValueFactory<yemekler,String>("türü"));
        yemekfiyatısütun1.setCellValueFactory(new PropertyValueFactory<yemekler,String>("fiyat"));

        yemekTableview1.setItems(eat);



        kullanıcıAdı_column.setCellValueFactory(new PropertyValueFactory<yemekler,String>("kullaniciAdi"));
        yemekİsim_column.setCellValueFactory(new PropertyValueFactory<yemekler,String>("isim"));
        yemekTürü_column.setCellValueFactory(new PropertyValueFactory<yemekler,String>("türü"));
        yemekFiyatı_column.setCellValueFactory(new PropertyValueFactory<yemekler,String>("fiyat"));

        siparistableview.setItems(secilen);
        siparistableview.refresh();

    }
}






