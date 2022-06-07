package ksmart.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;
import ksmart.mybatis.mapper.GoodsMapper;
import ksmart.mybatis.mapper.MemberMapper;

@Service
@Transactional
public class GoodsService {
	
	//3. 생성자 메소드 주입방식
	private final GoodsMapper goodsMapper;
	
	public GoodsService(MemberMapper memberMapper, GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	

	/**
	 * 상품목록 조회
	 */
	public List<Member> getResisInfoList() {

		List<Member> resisInfoList = goodsMapper.getResisInfoList();
		
		return resisInfoList;
	}	
	
	/**
	 * 상품등록
	 */
	public int addGoods(Goods goods) {
	
		int result = goodsMapper.addGoods(goods);
		
		return result;
	}
	

}
