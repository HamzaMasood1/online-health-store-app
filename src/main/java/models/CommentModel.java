package models;

import org.springframework.data.repository.CrudRepository;

import entities.Comment;

public interface CommentModel extends CrudRepository<Comment, Integer>{
	Comment findByContent(String content);
}
