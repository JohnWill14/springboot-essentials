package br.com.william.spring_essentials.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.william.spring_essentials.model.User;

public interface UserRepository extends PagingAndSortingRepository< User,Long>{
	User findByUsername(String username);

}
