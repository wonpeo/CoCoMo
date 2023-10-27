package SHOP;

import java.util.List;

import SHOP.Customer;
import SHOP.CheckoutRespDto;
import SHOP.CustomerDao;

public class CustomerService {
	private CustomerDao customerDao;
	
	public CustomerService() {
		this.customerDao = new CustomerDao();
	}
	public List<Integer> ��ٱ��Ϲ�ȣ����Ʈ(int id) {
		return customerDao.findForCartList(id);
	}
	
	public CheckoutRespDto ����ȸ������(int id) {
		return customerDao.findById(id);
	}
}
