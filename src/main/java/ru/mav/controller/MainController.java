package ru.mav.controller;

import java.util.Iterator;
import java.util.List;
import ru.mav.utils.GoodsService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mav.entity.Goods;
import ru.mav.entity.Sales;
import ru.mav.utils.SalesService;

@Controller
public class MainController {

    @Resource(name = "articlesService")
    private GoodsService goodsService;
    @Resource(name = "salesService")
    private SalesService salesService;

    @RequestMapping("/goods.htm")
    public String getGoodsList(Model model) {
        List<Goods> listGoods = goodsService.getAll();

        // считаем продажи 
        
        Iterator<Goods> iterator = listGoods.iterator();
        Goods goods;
        while (iterator.hasNext()) {
            goods = (Goods) iterator.next();
            List<Sales> listSales = salesService.selectSales(goods.getId());
            Iterator salesIter = listSales.iterator();
            Integer sales_counter = 0; // счетчик продаж (штук)
            // считаем общее количество проданного экземпляра по всем продажам (штук)
            while (salesIter.hasNext()) {
                Sales sale = (Sales) salesIter.next();
                sales_counter += sale.getNumber();
            }
            goods.setCountSales(sales_counter);
        }
        
        model.addAttribute("goodsList", listGoods);
        return "goods";
    }

    @RequestMapping("/sales.htm")
    public String getSalesList(Model model) {
        
        List<Sales> listSales = salesService.getAll();
        Iterator iterator = listSales.iterator();
        while(iterator.hasNext()){
        Sales sale = (Sales) iterator.next();
        sale.setNameOfGoods(goodsService.getGoodsById(sale.getGoodsId()).getName());
        }
        
        model.addAttribute("salesList", listSales);
        return "sales";
    }

    @RequestMapping(value = "/delGoods.htm", method = RequestMethod.GET)
    public String delGoods(@RequestParam("id") Integer id, Model model) {
        goodsService.deleteGoods(id);
        return "redirect:/goods.htm"; // защищаем от F5 и повторного удаления
    }

    @RequestMapping(value = "/delSale.htm", method = RequestMethod.GET)
    public String delSales(@RequestParam("id") Integer id, Model model) {
        salesService.deleteSales(id);
        return "redirect:/sales.htm"; // защищаем от F5 и повторного удаления
    }

    @RequestMapping("/goodsNew.htm")
    public String newGoods(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);
        model.addAttribute("action", "insert"); // ставим параметр, что в БД сохраняем новый товар
        return "goodsEdit";
    }

    @RequestMapping(value = "/goodsEdit.htm", method = RequestMethod.GET)
    public String editGoods(@RequestParam("id") Integer id, Model model) {
        Goods goods = goodsService.getGoodsById(id);
        model.addAttribute("id", id);
        model.addAttribute("goods", goods);
        model.addAttribute("action", "update"); // ставим параметр, что в БД сохраняем изменения старого товара
        return "goodsEdit";
    }

    @RequestMapping(value = "/saveGoods.htm", method = RequestMethod.GET)
    public String saveGoods(@RequestParam("action") String action,
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("price") Integer price,
            Model model) {

        if (action.equals("insert")) {
            Goods goods = new Goods(name, price);
            goodsService.addNewGoods(goods);
        }
        if (action.equals("update")) {
            Goods goods = goodsService.getGoodsById(id);
            goods.setName(name);
            goods.setPrice(price);
            goodsService.saveGoods(goods);
        }

        return "redirect:/goods.htm"; // защищаем от F5 и повторного добавления goods
    }

    @RequestMapping("/saleNew.htm")
    public String newSale(Model model) {
        Sales sale = new Sales();
        model.addAttribute("goodsList", goodsService.getAll()); // передаем список товаров для combobox формы
        model.addAttribute("sale", sale);
        model.addAttribute("action", "insert"); // ставим параметр, что в БД сохраняем новый товар
        return "saleEdit";
    }

    @RequestMapping(value = "/saleEdit.htm", method = RequestMethod.GET)
    public String editSale(@RequestParam("id") Integer id, Model model) {
        Sales sale = salesService.getSalesById(id);
        model.addAttribute("current_goods", goodsService.getGoodsById(sale.getGoodsId()));  // передаем goods текущей продажи 
        model.addAttribute("goodsList", goodsService.getAll()); // передаем список товаров для combobox формы
        model.addAttribute("sale", sale);
        model.addAttribute("action", "update"); // ставим параметр, что в БД сохраняем изменения старого товара
        return "saleEdit";
    }

    @RequestMapping(value = "/saveSale.htm", method = RequestMethod.GET)
    public String saveGoods(@RequestParam("action") String action,
            @RequestParam("id") Integer id,
            @RequestParam("goods_id") Integer goods_id,
            @RequestParam("number") Integer number,
            @RequestParam("cost") Integer cost,
            @RequestParam("date") String date,
            Model model) {

        if (action.equals("insert")) {
            Sales sale = new Sales(goods_id, number, cost, date);
            salesService.addNewSale(sale);
        }
        if (action.equals("update")) {
            Sales sale = salesService.getSalesById(id);
            sale.setGoodsId(goods_id);
            sale.setNumber(number);
            sale.setCost(cost);
            sale.setDate(date);
            salesService.saveSale(sale);
        }

        return "redirect:/sales.htm"; // защищаем от F5 и повторного добавления goods
    }
    
     /// Список продаж по одному товару
      @RequestMapping(value = "/sales_select.htm", method = RequestMethod.GET)
    public String saleSelect(@RequestParam("id") Integer id, Model model) {
        List<Sales> salesList = salesService.selectSales(id);
        model.addAttribute("salesList", salesList);
        model.addAttribute("goods_name", goodsService.getGoodsById(id).getName());
        return "sales_select";
    }

}
