package cn.itcast.crm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	public List<Customer> findnoassociationCustomers() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		String hql = "from Customer where decidedzone_id is null";
		List<Customer> customers = session.createQuery(hql).list();

		session.getTransaction().commit();
		session.close();

		return customers;
	}

	public List<Customer> findhasassociationCustomers(String decidedZoneId) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		String hql = "from Customer where decidedzone_id = ?";
		List<Customer> customers = session.createQuery(hql).setParameter(0, decidedZoneId).list();

		session.getTransaction().commit();
		session.close();

		return customers;
	}

	public void assignCustomersToDecidedZone(Integer[] customerIds, String decidedZoneId) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 取消定区所有关联客户
		String hql2 = "update Customer set decidedzone_id=null where decidedzone_id=?";
		session.createQuery(hql2).setParameter(0, decidedZoneId).executeUpdate();

		// 进行关联
		String hql = "update Customer set decidedzone_id=? where id =?";
		if (customerIds != null) {
			for (Integer id : customerIds) {
				session.createQuery(hql).setParameter(0, decidedZoneId).setParameter(1, id).executeUpdate();
			}
		}
		session.getTransaction().commit();
		session.close();
	}
/*
 * 根据手机号查找顾客信息
 * @see cn.itcast.crm.service.CustomerService#findCustomerByTelephone(java.lang.String)
 */
	@Override
	public Customer findCustomerByTelephone(String telephone) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		String hql = "from Customer where telephone = ? ";
		List<Customer> customers = session.createQuery(hql).setParameter(0, telephone).list();

		session.getTransaction().commit();
		session.close();
		
		if(customers != null &&customers.size() > 0){
			return customers.get(0);
		}
		return null;
	}
/*
 * 
 * 根据地址信息查询定区id
 * (non-Javadoc)
 * @see cn.itcast.crm.service.CustomerService#finddecidedZoneIdByAddress(java.lang.String)
 */
	@Override
	public String finddecidedZoneIdByAddress(String address) {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		String hql = "select decidedzone_id from Customer where address = ?";
		List<String> decidedzoneids = session.createQuery(hql).setParameter(0, address).list();

		session.getTransaction().commit();
		session.close();
		
		if(decidedzoneids != null && decidedzoneids.size() > 0){
			String decidedzoneid = decidedzoneids.get(0);
			if(StringUtils.isNotBlank(decidedzoneid)){}
				return decidedzoneid;
		}
		return null;
	}

}
