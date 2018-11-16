package com.xdqx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.xdqx.pojo.Pic;

public interface PicMapper {
	int insPic(Pic pic);
	@Select("select * from pic1")
	List<Pic> selAll();
	@Delete("delete from pic1 where id=#{0}")
	int delById(int id);
}
