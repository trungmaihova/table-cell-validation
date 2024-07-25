package com.ivy.investigate.table;

import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

public class ProductBean {

	private List<Product> products = Collections.emptyList();

	private ProductService service;

	public void init() {
		this.service = new ProductService();
		this.products = this.service.getClonedProducts(3);
	}

	public List<Product> getProducts() {
		return products;
	}

	public InventoryStatus[] getInventoryStatusList() {
		return InventoryStatus.values();
	}

	public void setService(ProductService service) {
		this.service = service;
	}

	public void onRowEdit(RowEditEvent<Product> event) {
		FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Product> event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getCode()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		event.getColumn().getCellEditor().addClientBehavior(null, null);
		

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void save() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Products is saved", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
}
