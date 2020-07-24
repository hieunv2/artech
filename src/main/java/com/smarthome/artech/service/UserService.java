package com.smarthome.artech.service;

import com.smarthome.artech.model.User;
import com.smarthome.artech.repository.UserRepository;
import com.smarthome.artech.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AuthService authService;

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
}