package com.ivy.investigate.table;

import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

public class ProductBean {

	private List<Product> products1 = Collections.emptyList();
	private List<Product> products2 = Collections.emptyList();
	private List<Product> products3 = Collections.emptyList();

	private ProductService service;

	public void init() {
		this.service = new ProductService();
		this.products1 = this.service.getClonedProducts(2);
		this.products2 = this.service.getClonedProducts(2);
		this.products3 = this.service.getClonedProducts(2);
	}

	public List<Product> getProducts1() {
		return products1;
	}
	
	public List<Product> getProducts2() {
		return products2;
	}

	public List<Product> getProducts3() {
		return products3;
	}
	
	public InventoryStatus[] getInventoryStatusList() {
		return InventoryStatus.values();
	}

	public void setService(ProductService service) {
		this.service = service;
	}

	public void saveProducts() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Products1 is saved", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
	
	public void saveProducts2() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Products2 is saved", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		PrimeFaces.current().ajax().update("form2");
	}
}
