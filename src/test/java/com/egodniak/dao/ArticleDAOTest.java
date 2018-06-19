package com.egodniak.dao;
import com.egodniak.model.Article;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Edyta on 18.06.2017.
 */

public class ArticleDAOTest {

    @Test
    public void getArticleFromDBExisting() throws Exception {
        Article article = ArticleDAO.getArticleFromDB("00001");
        Assert.assertTrue(article != null);
    }

    @Test
    public void getArticleFromDBNonExisting() throws Exception {
        Article article = ArticleDAO.getArticleFromDB("nonexistingcode");
        Assert.assertTrue(article == null);
    }

}
