package br.edu.ibmec.cloudcomputing.imotors.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ibmec.cloudcomputing.imotors.exception.StreamException;
import br.edu.ibmec.cloudcomputing.imotors.model.Streams;
import br.edu.ibmec.cloudcomputing.imotors.model.Post;
import br.edu.ibmec.cloudcomputing.imotors.repository.StreamRepository;

@Service
public class StreamService {

    @Autowired
    StreamRepository streamRepository;

    @Autowired
    private AzureStorageAccountService azureStorageAccountService;

    @Autowired PostService postService;

    public List<Streams> findAll() {
        return this.streamRepository.findAll();
    }

    public Optional<Streams> findById(long id) {
        return this.streamRepository.findById(id);
    }

    public Streams update(long id, Streams newData) throws StreamException{
        Optional<Streams> opStream = this.streamRepository.findById(id);

        if(opStream.isPresent() == false)
            throw new StreamException("Comentario nao encontrado");

        Streams stream = opStream.get();
        stream.setNome(newData.getNome());
        stream.setUrlLogo(newData.getUrlLogo());
        stream.setSite(newData.getSite());

        this.streamRepository.save(stream);
        return stream;

    }

    public Streams save(long idPost, Streams item) throws StreamException {
        Optional<Post> opPost = this.postService.getById(idPost);

        if(opPost.isPresent() == false)
            throw new StreamException("Post não encontrado");

        Post post = opPost.get();
        item.setPost(post);

        this.streamRepository.save(item);

        return item;
    }

    public void delete(long id) throws StreamException {
        Optional<Streams> oldStream = this.streamRepository.findById(id);
        if(oldStream.isPresent() == false){
            throw new StreamException("Não encontrei o Stream a ser deletado");
        }

        this.streamRepository.delete(oldStream.get());

        }

    public void uploadFileToStream(MultipartFile file, long id) throws StreamException, IOException{
        Optional<Streams> opStream = this.streamRepository.findById(id);

        if(opStream.isPresent() == false) {
            throw new StreamException("Não encontrei a stream a ser utilizado");
        }

        Streams stream = opStream.get();

        String urlLogo = this.azureStorageAccountService.uploadFileToAzureLogo(file);
        stream.setUrlLogo(urlLogo);
        this.streamRepository.save(stream);
    }

}
