package com.egodniak.appConfiguration; /**
 * Created by Edyta on 16.06.2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.egodniak.dao.ArticleDAO;
import com.egodniak.devices.*;
import com.egodniak.model.Article;
import com.egodniak.model.Basket;



//This app is not thread-safe it is assumed that only one user is using single point of sale at the time
public class ShopApp {
    private static Basket temporaryBasket = new Basket();
    private static Device qrScanner = new QRScanner();
    private static OutputDevice printer = new Printer();
    private static OutputDevice LCD = new LCD();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateConfiguration.disableLoggingToConsole();
        List<Device> listOfDevices = new ArrayList<Device>();
        listOfDevices.add(qrScanner);
        listOfDevices.add(printer);
        listOfDevices.add(LCD);
        connectDevices(listOfDevices);
        if(allDevicesConnected(listOfDevices)){
            shopping();
        }
        else{
            System.out.println("Sorry, sth went wrong");
        }
        HibernateConfiguration.getSessionFactory().close();
    }


    private static void connectDevices(List<Device> listOfDevices){
        for (Device d : listOfDevices) {d.connect();}
    }

    private static boolean allDevicesConnected(List<Device> listOfDevices){
        for (Device d : listOfDevices) {
            if(!d.isConnected())
                return false;
        }
        return true;

    }

    public static void shopping(){
        String decision = "next";
        while(!decision.equalsIgnoreCase("exit")){
            System.out.println("What would you like to do?");
            System.out.println("Scan new article code [hit any key] End shopping [exit]");
            decision = input.nextLine();
            if(!decision.equalsIgnoreCase("exit")) {
                String code = ((QRScanner) qrScanner).scann();
                if (code.equals(null))
                    LCD.print("Invalid barcode");
                else {
                    Article article = (Article) ArticleDAO.getArticleFromDB(code);
                    if (article == null)
                        LCD.print("Product not found");
                    else {
                        LCD.print(article.toString());
                        temporaryBasket.addArticle(article);
                    }
                }
            }
            else{
                checkout();
                System.out.println("Thank you!");
            }
        }
    }


    public static void checkout(){
        String articlesSummary = prepareArticleSummary();
        String priceSummary = preparePriceSummary();
        String shoppingSummary = articlesSummary + priceSummary;
        printer.print(shoppingSummary);
        LCD.print(priceSummary);
    }

    public static String prepareArticleSummary(){
        String articlesSummary = "";
        for (Article a: temporaryBasket.getListOfArticles()) {
            articlesSummary += a.toString() + "\n";
        }
        return articlesSummary;
    }

    public static String preparePriceSummary(){
        if(temporaryBasket.isEmpty())
            return "No articles in the basket, nothing to be paid";
        String price = String.format("%1.2f", temporaryBasket.getTotalSum());
        return "Total price: " + price;
    }
}
