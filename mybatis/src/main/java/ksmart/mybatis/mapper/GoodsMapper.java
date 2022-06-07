package ksmart.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;

@Mapper
public interface GoodsMapper {
	
	// 판매자 자신의 상품목록 조회
	public List<Member> getResisInfoList();

	public int addGoods(Goods goods);
	
}
