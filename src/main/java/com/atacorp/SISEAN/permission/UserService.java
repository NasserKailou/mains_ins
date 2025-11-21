package com.atacorp.SISEAN.permission;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
	private HttpSession session;

    // la methode doit être forcement loadUserByUsername
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException 
	{
		 User user = userRepository.findByLogin(login);
		 List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		 try {
			 for (Role role : user.getRoles()){
			        for (Privilege privilege : role.getPrivileges()){
			            grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getLibelle()));
			        }
				 }
			 
			 //initialisation des variables sessions
			 session.setAttribute("user", user);
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}
	    return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getMotPasse(), grantedAuthorities);
	}
	
}