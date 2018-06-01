/*package com.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Bill")
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_id")
	private int billId;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="total_value")
	private float totalValue;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "client_id")
	@JsonIgnore
	private Client client;

	public Bill() {
		this.billDate = new Date();
		this.totalValue = 0;
		this.orderDetails = new ArrayList<OrderDetail>();
		//this.client = new Client();
	}

	public int getOrderId() {
		return billId;
	}

	public void setOrderId(int orderId) {
		this.billId = orderId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
*/