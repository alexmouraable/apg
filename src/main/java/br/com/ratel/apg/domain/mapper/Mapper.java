package br.com.ratel.apg.domain.mapper;

public interface Mapper<I, O> {
	public O map(I input, Class<O> outputClass);
}
