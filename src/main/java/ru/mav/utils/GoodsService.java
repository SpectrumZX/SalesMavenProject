package ru.mav.utils;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import ru.mav.entity.Goods;

@Service("articlesService")
@Transactional
public class GoodsService {
    
    private SessionFactory sessionFactory = null;
  
    GoodsService(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
        
 public List<Goods> getAll() {      
    Session session = sessionFactory.openSession();
    List<Goods> result = session.createCriteria(Goods.class).addOrder(Order.asc("id")).list();
    session.close();
    return result;    
 }
 
  public Goods getGoodsById(Integer id) {      
    Session session = sessionFactory.openSession();
    Goods goods = (Goods) session.get(Goods.class, id);
    session.close();
    return goods;    
 }
  
    public void addNewGoods(Goods goods) {     
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(goods);
    session.flush();
    session.getTransaction().commit();
    session.close();
        
 }
    public void deleteGoods(Integer id) {     
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Goods goods = getGoodsById(id);
    session.delete(goods);
    session.flush();
    session.getTransaction().commit();
    session.close();        
 }
    
    public void saveGoods(Goods goods) {     
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(goods);
    session.flush();
    session.getTransaction().commit();
    session.close();
        
 }
    
    

}
