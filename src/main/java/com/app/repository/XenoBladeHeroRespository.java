package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.model.XenoBladeHero;

@Repository
public interface XenoBladeHeroRespository {
	
    List<XenoBladeHero> findAll();
    
    void insert(XenoBladeHero hero);
}