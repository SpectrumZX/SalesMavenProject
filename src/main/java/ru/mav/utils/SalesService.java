package ru.mav.utils;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.mav.entity.Sales;

@Service("salesService")
@Transactional
public class SalesService {
   
 public List<Sales> getAll() {      
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Sales> result = session.createCriteria(Sales.class).list();
    return result;    
 }
 
  public Sales getSalesById(Integer id) {      
    Session session = HibernateUtil.getSessionFactory().openSession();
    Sales sales = (Sales) session.get(Sales.class, id);
    return sales;    
 }
 

}
