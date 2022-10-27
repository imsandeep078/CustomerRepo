package com.customer.dto;

/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class QueryDataResponse {

	private long customerId;
	private String productName;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getProdustName() {
		return productName;
	}

	public void setProdustName(String produstName) {
		this.productName = produstName;
	}

	public QueryDataResponse() {

	}

	public QueryDataResponse(long customerId, String productName) {
		this.customerId = customerId;
		this.productName = productName;
	}

}
