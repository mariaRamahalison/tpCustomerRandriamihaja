/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerrandriamihaja.ejb;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tpcustomerrandriamihaja.entities.Customer;

/**
 *
 * @author Maria
 */
@Stateless
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * get All customers 
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    /**
     * update customer 
     * @param customer
     * @return 
     */
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    /**
     * persist customer
     * @param customer 
     */
    public void persist(Customer customer) {
       em.persist(customer);
    } 

    public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);
    }
    
    
}
