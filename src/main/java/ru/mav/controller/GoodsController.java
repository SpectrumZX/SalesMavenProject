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
public class GoodsController {

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

    @RequestMapping(value = "/delGoods.htm", method = RequestMethod.GET)
    public String delGoods(@RequestParam("id") Integer id, Model model) {
        goodsService.deleteGoods(id);
        return "redirect:/goods.htm"; // защищаем от F5 и повторного удаления
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

}
