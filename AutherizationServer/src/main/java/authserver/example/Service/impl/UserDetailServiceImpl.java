package authserver.example.Service.impl;

import authserver.example.UserDto;
import authserver.example.model.UserModel;
import authserver.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<UserModel> userModel=userRepository.findByUsername(s);

        userModel.orElseThrow(() -> new UsernameNotFoundException("Invalid User Name"));

        return new UserDto(userModel.get().getUsername(), userModel.get().getPassword(),
                userModel.get().isEnabled(),
                userModel.get().isAccountNonExpired(), userModel.get().isAccountNonExpired(),userModel.get().isCredentialsNonExpired() ,
                getAuthorities(userModel.get()),userModel.get().getId().toString());

    }

    private List<GrantedAuthority> getAuthorities(UserModel userModel){

        List<GrantedAuthority> authorityList = new ArrayList<>(2);

//        try {
//            List<UserRoleEntity> userRoleEntities=userRoleRepository.findAllByEmployeeEntityAndStatus(userEntity,"ACTIVE");
//
//            if(userRoleEntities != null){
//                userRoleEntities.forEach(role->{
//                    if(role.getStatus().equalsIgnoreCase("ACTIVE")){
//                        authorityList.add(new SimpleGrantedAuthority(role.getRoleEntity().getName()));
//                    }
//                });
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        return authorityList;

    }
}
