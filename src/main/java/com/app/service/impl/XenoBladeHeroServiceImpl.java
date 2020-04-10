package com.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.model.XenoBladeHero;
import com.app.repository.XenoBladeHeroRespository;
import com.app.service.XenobladeHeroService;


@Service
public class XenoBladeHeroServiceImpl implements XenobladeHeroService{
	
	@Resource
	private XenoBladeHeroRespository bladeHeroDao;
	
	@Override
	public List<XenoBladeHero> findAll() {
		System.out.println("-------XenoBladeHeroServiceImpl.java--------");
		List<XenoBladeHero> result = bladeHeroDao.findAll();
		return result;
	}
}
