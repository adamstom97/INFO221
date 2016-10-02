/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.ProductDB;
import gui.MainMenu;
import dao.ProductList;
import dao.ProductDAO;

/**
 * A Main class from which to run the entire admin project.
 * 
 * @author adath325
 * @version 4.0
 */
public class Main {
    private static ProductDAO list = new ProductDB();
//    private static ProductDao list = new ProductList();
    
    /**
     * Creates an instance of the MainMenu and centers it on the screen.
     * 
     * @param args  the command line arguments
     */
    public static void main(String[] args) {
        MainMenu frame = new MainMenu(list);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }
}
