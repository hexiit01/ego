package com.xdqx.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdqx.mapper.PicMapper;
import com.xdqx.pojo.Pic;
import com.xdqx.service.PicService;

@Service("picService")
public class PicServiceImpl implements PicService{
	@Resource
	private PicMapper picmapper;
	@Override
	public int insPic(Pic pic) {
		return picmapper.insPic(pic);
	}
	@Override
	public List<Pic> show() {
		return picmapper.selAll();
	}
	@Override
	public int delById(int id) {
		return picmapper.delById(id);
	}
	
}
