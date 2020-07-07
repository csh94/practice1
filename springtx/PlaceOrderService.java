package swan.spring.store.service;

import swan.spring.store.vo.ItemNotFoundException;
import swan.spring.store.vo.PurchaseOrderRequest;
import swan.spring.store.vo.PurchaseOrderResult;

public interface PlaceOrderService {
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) 
			throws ItemNotFoundException;
}
