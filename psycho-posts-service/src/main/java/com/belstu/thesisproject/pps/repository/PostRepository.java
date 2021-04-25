package com.belstu.thesisproject.pps.repository;

import com.belstu.thesisproject.pps.domain.PsychoPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PsychoPost, String> {
  PsychoPost getPsychoPostById(final String postId);

  List<PsychoPost> getAllByAuthorId(final String authorId);
}
