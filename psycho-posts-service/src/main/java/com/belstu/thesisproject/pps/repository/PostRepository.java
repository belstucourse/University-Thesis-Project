package com.belstu.thesisproject.pps.repository;

import java.util.List;
import java.util.Optional;

import com.belstu.thesisproject.pps.domain.PsychoPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PsychoPost, String> {
    PsychoPost getPsychoPostById(final String postId);
    List<PsychoPost> getAllByAuthorId(final String authorId);
}

