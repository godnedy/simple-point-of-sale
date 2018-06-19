package com.egodniak.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edyta on 6/19/2017.
 */
public class Basket {
    private List<Article> listOfArticles = null;
    private double totalSum;

    public Basket(){
        listOfArticles = new ArrayList<Article>();
        totalSum = 0;
    }

    public void addArticle(Article article){
        listOfArticles.add(article);
        totalSum += article.getPrice();
    }

    public double getTotalSum(){
        return totalSum;
    }

    public List<Article> getListOfArticles(){return listOfArticles;}

    public boolean isEmpty(){
        if(listOfArticles == null || listOfArticles.isEmpty()){
            return true;
        }
        else
            return false;
    }
}