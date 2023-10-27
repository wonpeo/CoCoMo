package SHOP;

import java.util.List;

import SHOP.IndexDto;
import SHOP.ProductDao;
import SHOP.DetailProdRespDto;
import SHOP.CheckoutProductDto;

public class ProductService {
private ProductDao productDao;
	
	public ProductService() {
		productDao = new ProductDao();
	}
	
	public List<IndexDto> findA(int limitNum) {
		return productDao.findAllWithLimitNum(limitNum);
	}
	
	public List<IndexDto> findA() {
		return productDao.findAll();
	}
	
	//public int ��ǰ���(InsertReqDto dto) {
	//	return productDao.insert(dto);
	//}
	
	public DetailProdRespDto findB(int prodNo) {
		return productDao.findById(prodNo);
	}
	
//	public List<IndexDto> ��ǰŰ����ã��(String keyword) {
	//	return productDao.findByKeyword(keyword);
//	}
	
	public List<IndexDto> findT(String type) {
		return productDao.findByType(type);
	}
	
//	public List<HeaderBrandDto> ȸ�����Ʈ() {
//		return productDao.getAllCompName();
//	}
	
//	public List<IndexDto> ��ǰ����() {
//		return productDao.findAllSortBySoldCount();
//	}
	
	public CheckoutProductDto ���Ż�ǰ����(int productCode) {
		return productDao.findForBuy(productCode);
		}
		
	public List<CheckoutProductDto> ���Ż�ǰ����(List<Integer> cartList) {
			return productDao.findForBuy(cartList);
		}
	
//	public void ���ż�����(int prodId) {
//		productDao.updateSoldCount(prodId);
//	}
}
