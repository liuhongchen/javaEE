package app;

import view.MainView;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        MainView mainView=new MainView();
        mainView.run();
    }
}
