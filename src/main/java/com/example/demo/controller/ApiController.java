package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService apser;
	@PostMapping("post")
	public Book adding(@RequestBody Book b)
	{
		return apser.saveinfo(b);
	}
	@GetMapping("get")
	public List<Book> showing()
	{
		return apser.showinfo();
	}
	
	//show by id
	@GetMapping("getbyid/{id}")
	public Optional<Book> showid(@PathVariable int id)
	{
		return apser.showbyid(id);
	}
	@PutMapping("put")
	public Book modify(@RequestBody Book b)
	{
		return apser.changeinfo(b);
	}
	
	//put by id
	@PutMapping("putbyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody Book b)
	{
		return apser.updateinfobyid(id, b);
	}
	
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		apser.deleteid(id);
	}

}
