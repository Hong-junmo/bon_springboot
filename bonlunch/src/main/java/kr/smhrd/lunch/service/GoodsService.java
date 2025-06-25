package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.smhrd.lunch.controller.HelloController;
import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	GoodsRepository goodsrepository;
	
	@Autowired
	GoodsDetailRepository detailrepo;

	public List<GoodsDTO> getAllGoods(){
		
		List<Goods> result = goodsrepository.findAll();
		
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		for(Goods g : result) {
			GoodsDTO dto = new GoodsDTO();
			dto.setId(g.getId());
			dto.setName(g.getName());
			dto.setPrice(g.getPrice());
			dto.setIsNew(g.getIsNew());
			dto.setIsBest(g.getIsBest());
			dto.setMain_thumb(g.getMain_thumb());
			list.add(dto);
		}
		
		return list;
	}

	public GoodsDTO getGoodsDetail(int id) {
		
		// 1. id값을 가지고 제품 정보 Goods 가지고 오기
		Goods goods = goodsrepository.findById(id).orElse(null);
		GoodsDetail detail = detailrepo.findById(id).orElse(null);
		
		// 2. 두 변수의 값이 null인 경우에는 null을 리턴
		if(goods == null || detail == null) {
			return null;
		}
		
		GoodsDTO dto = new GoodsDTO();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsBest());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
		
		return dto;
	}
	
	
}
