package br.com.william.spring_essentials.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.william.spring_essentials.model.User;
import br.com.william.spring_essentials.repositorio.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository dao;

	
	@Autowired
	public CustomUserDetailsService(UserRepository dao) {
		super();
		this.dao = dao;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = Optional.ofNullable(dao.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("username não encontrado"));
		List<GrantedAuthority> createAuthorityListAdm = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADM");
		List<GrantedAuthority> createAuthorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isAdimin() ? createAuthorityListAdm : createAuthorityListUser);
	}

}
