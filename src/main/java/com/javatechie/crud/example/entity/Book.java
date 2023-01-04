package com.javatechie.crud.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.javatechie.crud.example.enumeration.Available;

@Entity
@Table(name = "BOOK_TbL")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;



	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTHOD_Id")
	private Person author;
	
	@Column(name = "PUBLISON")
	private int publishon;
	
	@Column(name = "STOCK")
	private int stock;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "AVAILABLE")
	private Available available;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public int getPublishon() {
		return publishon;
	}

	public void setPublishon(int publishon) {
		this.publishon = publishon;
	}

	public int getStock() {
		return stock;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Available getAvailable() {
		return available;
	}

	public void setAvailable(Available available) {
		this.available = available;
	}
}
