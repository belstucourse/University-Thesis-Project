package com.belstu.thesisproject.pps.service.impl;

import com.belstu.thesisproject.pps.domain.PsychoPost;
import com.belstu.thesisproject.pps.exception.PostNotFoundException;
import com.belstu.thesisproject.pps.repository.PostRepository;
import com.belstu.thesisproject.pps.service.PostService;
import java.util.List;
import javax.validation.constraints.NotNull;

public class PostServiceImpl implements PostService {
  private PostRepository postRepository;

  @Override
  public PsychoPost getPostById(@NotNull String postId) throws PostNotFoundException {
    return postRepository.getPsychoPostById(postId);
  }

  @Override
  public List<PsychoPost> getAllPostsByAuthorId(@NotNull String authorId) {
    return postRepository.getAllByAuthorId(authorId); // TODO: pagination
  }

  @Override
  public List<PsychoPost> getAllPost() {
    return postRepository.findAll(); // TODO: pagination
  }

  @Override
  public PsychoPost save(@NotNull PsychoPost post) {
    return postRepository.save(post);
  }

  @Override
  public PsychoPost update(@NotNull PsychoPost post) throws PostNotFoundException {
    return null;
  }

  @Override
  public void delete(@NotNull String postId) throws PostNotFoundException {
    postRepository.deleteById(postId);
  }

  @Override
  public PsychoPost patch(@NotNull PsychoPost post) throws PostNotFoundException {
    return null;
  }
}
