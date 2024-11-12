package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutoRequestDto;
import br.com.cotiinformatica.dtos.ProdutoResponseDto;
import br.com.cotiinformatica.service.ProdutoService;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	
	@Autowired
	ProdutoService produtoService;
	
	
	
	@PostMapping
	public ProdutoResponseDto post(@RequestBody ProdutoRequestDto dto) {
		
		
		return produtoService.create(dto);
	}
	
	
}
