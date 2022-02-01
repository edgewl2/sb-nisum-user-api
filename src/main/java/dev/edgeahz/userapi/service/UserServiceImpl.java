package dev.edgeahz.userapi.service;

import dev.edgeahz.userapi.domain.dto.UserDto;
import dev.edgeahz.userapi.domain.entity.Phone;
import dev.edgeahz.userapi.domain.entity.Role;
import dev.edgeahz.userapi.domain.entity.User;
import dev.edgeahz.userapi.exception.JwtAttemptAuthenticationException;
import dev.edgeahz.userapi.exception.UserApiActionException;
import dev.edgeahz.userapi.repository.PhoneRepository;
import dev.edgeahz.userapi.repository.RoleRepository;
import dev.edgeahz.userapi.repository.UserRepository;
import dev.edgeahz.userapi.security.provider.JwtProvider;
import dev.edgeahz.userapi.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PhoneRepository phoneRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PhoneRepository phoneRepository, PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.phoneRepository = phoneRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Transactional
    @Override
    public Optional<User> store(UserDto userDto) {
        Optional<User> userSaved = Optional.empty();
        Optional<User> userExists = this.userRepository.findByEmail(userDto.getEmail());

        if(!userDto.getPhones().isEmpty()){
            List<Optional<Phone>> phoneOptionals = userDto.getPhones().stream()
                    .map(phone -> this.phoneRepository.findByNumber(phone.getNumber()))
                    .collect(Collectors.toList());

            phoneOptionals.forEach(
                    phoneOptional -> phoneOptional.ifPresent(
                            phone -> { throw new UserApiActionException("phone.found", HttpStatus.FORBIDDEN); }
                    )
            );
        }

        userExists.ifPresent(action -> {
            throw new UserApiActionException("user.found", HttpStatus.FORBIDDEN);
        });

        Optional<Role> role = this.roleRepository.findByName(RoleType.ROLE_NORMAL.name());
        if (role.isPresent()) {
            userDto.setToken(this.jwtProvider.generateToken(userDto.getEmail(), Collections.singletonList(role.get())));
            userSaved = Optional.of(
                    this.userRepository.save(
                            UserDto.convert(userDto, this.passwordEncoder.encode(userDto.getPassword()),
                                    userDto.getToken(), role.get())
                    )
            );
        }
        return userSaved;
    }

    @Override
    public Optional<User> search(String email) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<String> authenticate(String email, String password) {
        Optional<String> token = Optional.empty();
        Optional<User> userOptional = Optional.ofNullable(this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UserApiActionException("email.not.found", HttpStatus.NOT_FOUND)));

        if(userOptional.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
                token = Optional.of(this.jwtProvider.generateToken(email, new ArrayList<>(userOptional.get().getRoles())));
                userOptional.get().setToken(token.get());
                userOptional.get().setActive(true);
                this.userRepository.save(userOptional.get());
            } catch (AuthenticationException e){
                throw new JwtAttemptAuthenticationException("user.signin.failed", e, HttpStatus.UNAUTHORIZED);
            }
        }
        return token;
    }

    @Override
    public List<User> search() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }
}
