package kr.smhrd.lunch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.smhrd.lunch.BonlunchApplication;
import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.service.GoodsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://52.79.46.16:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {
	
    @Autowired
	GoodsService service;
    
    @GetMapping("/goods_list/{id}")
    public GoodsDTO viewGoodList(@PathVariable("id") int id) {
    	GoodsDTO data = service.getGoodsDetail(id);
    	System.out.println(data);
    	
    	return data;
    }
    
    
    

	@GetMapping("/goods_list")
	public List<GoodsDTO> getGoodsList(Goods goods) {
		System.out.println("list 출력 컨트롤러");
		
		// 2Step -> Service -> Repository
		List<GoodsDTO>data = service.getAllGoods();
		
		return data;
	}
	
	
}
