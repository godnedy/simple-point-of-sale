package com.egodniak.dao;

import com.egodniak.appConfiguration.HibernateConfiguration;
import com.egodniak.model.Article;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import java.util.List;


/**
 * Created by Edyta on 18.06.2017.
 */
public class ArticleDAO extends Article {

    public ArticleDAO(String code, String name, Double price){
        super();
    }

    public static Article getArticleFromDB(String code){
        Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Article retrievedArticle = null;
        try {
            tx = session.beginTransaction();
            retrievedArticle = session.get(Article.class, code);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return retrievedArticle;
    }


    /* method to retrieve article from DB with native named sql, not used in this project */
    public static Article getArticleFromDBNamedSQL(String code) throws HibernateException{
        Session session = HibernateConfiguration.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Article article = null;
        try {
            tx = session.beginTransaction();
            String sql = "SELECT * FROM ARTICLE WHERE code = :code";
            NativeQuery<String> query = session.createNativeQuery(sql);
            query.addEntity(Article.class);
            query.setParameter("code", code);
            List articleList = query.list();
            article = (Article)articleList.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return article;
    }
}
