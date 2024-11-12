package br.com.cotiinformatica.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ProdutoRequestDto;
import br.com.cotiinformatica.dtos.ProdutoResponseDto;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
	public ProdutoResponseDto create(ProdutoRequestDto dto) {
		
		var produto = new Produto();
		
		produto.setId(UUID.randomUUID());
		produto.setNome(dto.getNome());
		produto.setPreco(BigDecimal.valueOf(dto.getPreco()));
		produto.setQuantidade(dto.getQuantidade());
		
		
		produtoRepository.save(produto);
		
		
		//retornar os dados do produto cadastrado..
				var response = new ProdutoResponseDto();
				response.setId(produto.getId());
				response.setNome(produto.getNome());
				response.setPreco(produto.getPreco().doubleValue());
				response.setQuantidade(produto.getQuantidade());
				
				return response;

			
		
	}
	
	
}
