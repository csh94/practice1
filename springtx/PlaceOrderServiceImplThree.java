package swan.spring.store.service;

import org.springframework.transaction.annotation.Transactional;

import swan.spring.store.dao.ItemDao;
import swan.spring.store.dao.PaymentInfoDao;
import swan.spring.store.dao.PurchaseOrderDao;
import swan.spring.store.vo.Item;
import swan.spring.store.vo.ItemNotFoundException;
import swan.spring.store.vo.PaymentInfo;
import swan.spring.store.vo.PurchaseOrder;
import swan.spring.store.vo.PurchaseOrderRequest;
import swan.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplThree implements PlaceOrderService {
	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
		this.paymentInfoDao = paymentInformationDao;
	}
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}
	@Override
	@Transactional
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) 
			throws ItemNotFoundException {
		Item item = itemDao.findById(orderRequest.getItemId());
		if (item == null)
			throw new ItemNotFoundException(orderRequest.getItemId());
		PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
		paymentInfoDao.insert(paymentInfo);
		PurchaseOrder order = new PurchaseOrder(item.getId(), 
				orderRequest.getAddress(), paymentInfo.getId());
		purchaseOrderDao.insert(order);
		return new PurchaseOrderResult(item, paymentInfo, order);
	}
}
