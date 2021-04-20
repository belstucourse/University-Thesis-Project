package com.belstu.thesisproject.pps.service;

import com.belstu.thesisproject.pps.domain.PsychoPost;
import com.belstu.thesisproject.pps.exception.AuthorNotFoundException;
import com.belstu.thesisproject.pps.exception.PostNotFoundException;

import java.util.List;
import javax.validation.constraints.NotNull;

public interface PostService {
    PsychoPost getPostById(@NotNull String postId) throws PostNotFoundException;
    List<PsychoPost> getAllPostsByAuthorId(@NotNull String authorId) throws AuthorNotFoundException; //TODO: pagination
    List<PsychoPost> getAllPost(); //TODO: pagination
    PsychoPost save (@NotNull final PsychoPost post);
    PsychoPost update (@NotNull final PsychoPost post) throws PostNotFoundException;
    void delete(@NotNull final String postId) throws PostNotFoundException;
    PsychoPost patch(@NotNull final PsychoPost post) throws PostNotFoundException;
}
