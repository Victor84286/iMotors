package br.edu.ibmec.cloudcomputing.imotors.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.cloudcomputing.imotors.model.Comments;
import br.edu.ibmec.cloudcomputing.imotors.model.Post;
import br.edu.ibmec.cloudcomputing.imotors.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired PostService postService;

    public List<Comments> findAll() {
        return this.commentRepository.findAll();
    }

    public Optional<Comments> findById(long id) {
        return this.commentRepository.findById(id);
    }

    public Comments update(long id, Comments newData) throws Exception{
        Optional<Comments> opComment = this.commentRepository.findById(id);

        if(opComment.isPresent() == false)
            throw new Exception("Comentario nao encontrado");

        Comments comment = opComment.get();
        comment.setAuthor(newData.getAuthor());
        comment.setText(newData.getText());
        comment.setDtComment(newData.getDtComment());

        this.commentRepository.save(comment);
        return comment;

    }

    public Comments save(long idPost, Comments item) throws Exception {
        Optional<Post> opPost = this.postService.getById(idPost);

        if(opPost.isPresent() == false)
            throw new Exception("Post não encontrado");

        if(item.getDtComment() == null){
            item.setDtComment(LocalDateTime.now());
        }

        Post post = opPost.get();
        item.setPost(post);

        this.commentRepository.save(item);

        return item;
    }

    public void delete(long id) throws Exception {
        Optional<Comments> oldComment = this.commentRepository.findById(id);
        if(oldComment.isPresent() == false){
            throw new Exception("Não encontrei o Comment a ser deletado");
        }

        this.commentRepository.delete(oldComment.get());

        }

}