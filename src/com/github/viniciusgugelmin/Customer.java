package com.github.viniciusgugelmin;

public class Customer {
	
	private long id;
	private String name;
	private int code;
	private double credit;
	
	// getters
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
	
	public double getCredit() {
		return credit;
	}
	
	// setters
	public void setId(String num) {
		long id = Long.parseLong(num);
		
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCode(String num) {
		int code = Integer.parseInt(num);
		
		this.code = code;
	}

	public void setCredit(String num) {
		double credit = Double.parseDouble(num.replaceAll(",", "."));
		
		this.credit = credit;
	}
}
