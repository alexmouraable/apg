package br.com.ratel.apg.infrastructure.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.mapper.Mapper;

@Component
public class ObjectMapper<I, O> implements Mapper<I, O> {
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public O map(I input, Class<O> outputClass) {
		return this.modelMapper.map(input, outputClass);
	}
}
