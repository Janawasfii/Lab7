package com.example.lab7service.Service;

import com.example.lab7service.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> newsArticles = new ArrayList<NewsArticle>();
    public ArrayList<NewsArticle> getNewsArticles(){
        return newsArticles;
    }

public void addNewsArticle(NewsArticle newsArticle){
        newsArticles.add(newsArticle);

}

public boolean updateNewsArticle(int id, NewsArticle newsArticle){
        for(int i=0; i<newsArticles.size(); i++){
            if(newsArticles.get(i).getId() == id){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }return false;
}
public boolean deleteNewsArticle(int id){
        for(int i=0; i<newsArticles.size(); i++){
            if(newsArticles.get(i).getId() == id){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
}
public boolean changeNewsArticle(int id){
        for(int i=0; i<newsArticles.size(); i++){
            if(newsArticles.get(i).getId() == id ){
                    newsArticles.get(i).setPublished(true);
                    newsArticles.get(i).setPublishedDate(LocalDate.now());
                    return true;}}
                    return false;}

public ArrayList<NewsArticle> getsPublishNewsArticles() {
        ArrayList<NewsArticle> newsArticle = new ArrayList<>();
        for(int i=0; i<newsArticles.size(); i++){
            if(newsArticles.get(i).isPublished()==true){
                newsArticle.add(newsArticles.get(i));
            }
        }
        return newsArticle;

    }
 public ArrayList<NewsArticle> findNewsArticles(String category){
        ArrayList<NewsArticle> newsArticle = new ArrayList<>();
        for(int i=0; i<newsArticles.size(); i++){
            if(newsArticles.get(i).getCategory().equalsIgnoreCase(category)){
                newsArticle.add(newsArticles.get(i));
            }

        }
     return newsArticle;


 }


}

















