package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.model.Goods;


public interface TestGoodsMapper {

	@Select(" select * from goods")
	List<Goods> findAll();
}
