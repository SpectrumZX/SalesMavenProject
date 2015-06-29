package ru.mav.controller;
import ru.mav.utils.GoodsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mav.utils.SalesService;



@Controller
public class MainController {

 @Resource(name="articlesService")
 private GoodsService goodsService;
 @Resource(name="salesService")
 private SalesService salesService;
 
 @RequestMapping("/goods.htm")
 public String getGoodsList(Model model) {
 model.addAttribute("goodsList", goodsService.getAll());
 
 
 return "goods";
 }
 
 @RequestMapping("/sales.htm")
 public String getSalesList(Model model) { 
 model.addAttribute("salesList", salesService.getAll());
 return "sales";
 }
 
 @RequestMapping(value = "/del_goods.htm", method = RequestMethod.GET)
 public String delGoods(@RequestParam("id") Integer id, Model model) {
 goodsService.deleteGoods(id);
 model.addAttribute("goodsList", goodsService.getAll());
 return "goods";
 }
 
 @RequestMapping(value = "/del_sales.htm", method = RequestMethod.GET)
 public String delSales(@RequestParam("id") Integer id, Model model) {
 salesService.deleteSales(id);
 model.addAttribute("salesList", salesService.getAll());
 return "sales";
 }

}