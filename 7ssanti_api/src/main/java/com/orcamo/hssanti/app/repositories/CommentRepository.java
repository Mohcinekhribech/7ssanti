package com.orcamo.hssanti.app.repositories;

import com.orcamo.hssanti.app.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
