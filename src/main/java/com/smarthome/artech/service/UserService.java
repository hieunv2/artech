package com.smarthome.artech.service;

import com.smarthome.artech.model.User;
import com.smarthome.artech.repository.UserRepository;
import com.smarthome.artech.request.UserRequest;
import com.smarthome.artech.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

//    public void save(PostRequest postRequest) {
//        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
//                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
//        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
//    }

//    @Transactional(readOnly = true)
//    public PostResponse getPost(Long id) {
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new PostNotFoundException(id.toString()));
//        return postMapper.mapToDto(post);
//    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
//        User user = new User();
//        user.setUsername(userRequest.getUsername());
//        user.setEmail(userRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//        user.setCreated(Instant.now());
//        user.setEnabled(userRequest.getEnabled());

        userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void remove(User user){
        userRepository.delete(user);
    }
}