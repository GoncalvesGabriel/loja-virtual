package br.com.lojavirtual.validator;

public interface Validator<T> {

  void validate(T dto);

}
