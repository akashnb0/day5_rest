package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class ApiService {
	@Autowired
	BookRepo r;
	public Book saveinfo(Book b)
	{
		return r.save(b);
	}
	public List<Book> savedetails(List<Book> b)
	{
		return (List<Book>) r.saveAll(b);
	}
	public List<Book> showinfo()
	{
		return r.findAll();
	}
	
	//get by id
	public Optional<Book> showbyid(int id)
	{
		return r.findById(id);
	}
	public Book changeinfo(Book b)
	{
		return r.saveAndFlush(b);
	}
	
	//put by id
	public String updateinfobyid(int id, Book b)
	{
		r.saveAndFlush(b);
		if(r.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	//delete by id
	public void deleteid(int id)
	{
		r.deleteById(id);
	}
}
