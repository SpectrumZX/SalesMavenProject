package ru.mav.controller;
import ru.mav.utils.GoodsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mav.utils.SalesService;



@Controller
//@RequestMapping("/main")
public class MainController {

 @Resource(name="articlesService")
 private GoodsService goodsService;
 @Resource(name="salesService")
 private SalesService salesService;
 
 @RequestMapping("/index.htm")
 public String getGoodsList(Model model) {
 model.addAttribute("goodsList", goodsService.getAll());
 
 return "index";
 }
 
 @RequestMapping("/sales.htm")
 public String getSalesList(Model model) {
  
 model.addAttribute("salesList", salesService.getAll());
 
 return "sales";
 }

}