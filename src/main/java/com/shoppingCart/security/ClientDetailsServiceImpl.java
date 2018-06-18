package com.shoppingCart.security;

import com.shoppingCart.dto.Client;
import com.shoppingCart.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.login(email);
        if (client == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(client.getEmail(), client.getPassword(), emptyList());
    }
}
