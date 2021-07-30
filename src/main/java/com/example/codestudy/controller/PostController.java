package com.example.codestudy.controller;

import com.example.codestudy.domain.Post;
<<<<<<< HEAD
import com.example.codestudy.repository.PostRepository;
import lombok.RequiredArgsConstructor;
=======
import com.example.codestudy.hateoas.CustomPagedResourceAssembler;
import com.example.codestudy.hateoas.PagedModelUtil;
import com.example.codestudy.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
>>>>>>> b_web
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
@SuppressWarnings("ALL")
@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable("id") Post post){
        return postRepository.findById(post.getId()).get();
    }
=======
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-30
 */
@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CustomPagedResourceAssembler assembler;

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable("id") Post post){
        return postRepository.findById(post.getId()).orElse(new Post());
    }

    @GetMapping("/post")
    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    @GetMapping("/posts")
    public PagedModel<EntityModel<Post>> getHateoasPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler){

        return PagedModelUtil.getEntityModels(assembler, postRepository.findAll(pageable),
                linkTo(methodOn(this.getClass()).getClass()),
                Post::getId);

        //return assembler.toModel(postRepository.findAll(pageable));
    }

>>>>>>> b_web
}
