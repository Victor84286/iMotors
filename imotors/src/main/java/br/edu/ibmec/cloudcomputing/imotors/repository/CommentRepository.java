package br.edu.ibmec.cloudcomputing.imotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.cloudcomputing.imotors.model.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> { }
