package com.egodniak.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edyta on 6/19/2017.
 */

class BasketTest {

    @Test
    void addArticle() {
        Basket basket = new Basket();
        Article article1 = new Article();
        article1.setCode("code1");
        article1.setName("article1");
        article1.setPrice(2.3);

        basket.addArticle(article1);
        Assert.assertTrue(!basket.isEmpty() && basket.getTotalSum() == 2.3);
    }

    @Test
    void getTotalSum() {
        Basket basket = new Basket();
        Article article1 = new Article();
        article1.setCode("code1");
        article1.setName("article1");
        article1.setPrice(2.3);
        Article article2 = new Article();
        article1.setCode("code12");
        article1.setName("article2");
        article1.setPrice(5);

        basket.addArticle(article1);
        basket.addArticle(article2);
        Assert.assertTrue(basket.getTotalSum() == 7.3);
    }

    @Test
    void getListOfArticles() {
        Basket basket = new Basket();
        Article article1 = new Article();
        article1.setCode("code1");
        article1.setName("article1");
        article1.setPrice(2.3);
        Article article2 = new Article();
        article1.setCode("code12");
        article1.setName("article2");
        article1.setPrice(5);
        basket.addArticle(article1);
        basket.addArticle(article2);

        List<Article> list = new ArrayList<Article>();
        list.add(article1);
        list.add(article2);
        Assert.assertEquals(list, basket.getListOfArticles());
    }

    @Test
    void isEmpty() {
        Basket basket = new Basket();
        Assert.assertTrue(basket.isEmpty());
    }

}