package br.edu.ibmec.cloudcomputing.imotors.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ibmec.cloudcomputing.imotors.exception.PostException;
import br.edu.ibmec.cloudcomputing.imotors.model.Post;
import br.edu.ibmec.cloudcomputing.imotors.model.Usuario;
import br.edu.ibmec.cloudcomputing.imotors.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AzureStorageAccountService azureStorageAccountService;

    @Autowired UsuarioService usuarioService;

    public Post create(long idUsuario, Post post) throws PostException{
        Optional<Usuario> opUsuario = this.usuarioService.findById(idUsuario);

        if(opUsuario.isPresent() == false)
            throw new PostException("Post não encontrado");

        if(post.getDtPublish() == null){
            post.setDtPublish(LocalDateTime.now());
        }

        Usuario usuario = opUsuario.get();
        post.setUsuario(usuario);

        return this.postRepository.save(post);
    }

    public Optional<Post> getById(long id){
        return this.postRepository.findById(id);
    }

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public void saveOrUpdate(Post item){
        this.postRepository.save(item);
    }

    public Post update(long id, Post newData) throws PostException{
        Optional<Post> oldPost = this.postRepository.findById(id);
        if(oldPost.isPresent() == false){
            throw new PostException("Não encontrei o post a ser atualizado");
        }

        Post post = oldPost.get();
        post.setTitle(newData.getTitle());
        post.setArticle(newData.getArticle());

        this.postRepository.save(post);
        return post;
    }

    public void delete(long id) throws PostException {
        Optional<Post> oldPost = this.postRepository.findById(id);
        if(oldPost.isPresent() == false){
            throw new PostException("Não encontrei o post a ser atualizado");
        }

        this.postRepository.delete(oldPost.get());

        }

    public void uploadFileToPost(MultipartFile file, long id) throws PostException, IOException{
        Optional<Post> opPost = this.postRepository.findById(id);

        if(opPost.isPresent() == false) {
            throw new PostException("Não encontrei o post a ser utilizado");
        }

        Post post = opPost.get();

        String urlImage = this.azureStorageAccountService.uploadFileToAzurePost(file);
        post.setUrlImage(urlImage);
        this.postRepository.save(post);
    }
}
