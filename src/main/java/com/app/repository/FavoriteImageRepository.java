package com.app.repository;

import java.util.List;

import com.app.model.FavoriteImage;

public interface FavoriteImageRepository {
	
    List<FavoriteImage> findAllImage();
    
    void insert(FavoriteImage favImg);
    
    List<FavoriteImage> findByType(String keyWord);
    
    FavoriteImage findByPath(String path);
}