package com.xdqx.service;


import java.util.List;

import com.xdqx.pojo.Pic;
public interface PicService {
	int insPic(Pic pic);
	List<Pic> show();
	int delById(int id);
	
}
