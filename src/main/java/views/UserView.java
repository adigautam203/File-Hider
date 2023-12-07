package views;

import dao.DataDAO;
import db.MyConnection;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private  String email;
    UserView(String email){
        this.email = email;
    }
    public void home(){
        do{

            System.out.println("Welcome "+ this.email );
            System.out.println("Press onr to show hidden Files");
            System.out.println("Press 2 to Hide a new File");
            System.out.println("Press 3 to unhide a File");
            System.out.println("press 0 to exit");
            Scanner sc = new Scanner(System.in);
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch){
                case 1 ->{
                    try {
                        List<Data> files = DataDAO.getAllFiles(this.email);
                        System.out.println("ID - File Name ");
                        for (Data file : files){
                            System.out.println(file.getId() + " - "+ file.getFilenaame());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Enter File Path");
                    String path = sc.nextLine();
                    File f = new File(path);
                    Data file  = new Data(0,f.getName(), path, this.email);
                    try {
                        DataDAO.hidefile(file);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3  ->{
                    List<Data> files = null;
                    try {
                        files = DataDAO.getAllFiles(this.email);

                    System.out.println("ID - File Name ");
                    for (Data file : files){
                        System.out.println(file.getId() + " - "+ file.getFilenaame());
                    }
                    System.out.println("Enter th id of file to Unhide");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean isValidID = false;
                    for(Data file: files){
                        if (file.getId()==id){
                            isValidID = true;
                            break;
                        }
                    }
                    if (isValidID){
                        DataDAO.unhide(id);
                    }else {
                        System.out.println("Wrong Id");
                    }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                case  0 ->{
//
                   Welcome w = new Welcome();
                   w.welcomeScreen();

                }
            }
        }while (true);
    }
}
