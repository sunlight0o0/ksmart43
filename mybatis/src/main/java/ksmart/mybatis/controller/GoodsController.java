package ksmart.mybatis.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;
import ksmart.mybatis.service.GoodsService;
import ksmart.mybatis.service.MemberService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	
	//DI (의존성 주입)
	//3. 생성자 메소드 주입방식
	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods
							,@RequestParam(name="goodsCode", required = false) String goodsCode
							,HttpServletRequest request) {
		log.info("화면에서 입력한 data : {}", goods);
		log.info("화면에서 입력한 goodsCode : {}", goodsCode);
		/* GoodsService.addGoods(goods); */
		
		return "redirect:/goods/resisInfoList";
	}	

	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		return "goods/addGoods";
	}
	
	
	
	@GetMapping("/resisInfoList")
	public String getResisInfoList(Model model) {
		List<Member> resisInfoList = goodsService.getResisInfoList();
		
		model.addAttribute("resisInfoList", resisInfoList);
		
		log.info("resisInfoList: {}" , resisInfoList);
		
		return "goods/resisInfoList";		
	}
	
}
