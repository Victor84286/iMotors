package br.edu.ibmec.cloudcomputing.imotors.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ibmec.cloudcomputing.imotors.exception.StreamException;
import br.edu.ibmec.cloudcomputing.imotors.model.Streams;
import br.edu.ibmec.cloudcomputing.imotors.service.StreamService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/stream")
@Tag(name = "Stream", description = "")
@CrossOrigin
class StreamController {

    @Autowired
    StreamService streamService;

    @GetMapping
    public ResponseEntity<List<Streams>> getAll() {
        try {
            List<Streams> items = new ArrayList<Streams>();

            streamService.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Streams> getById(@PathVariable("id") long id) {
        Optional<Streams> existingItemOptional = streamService.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<Streams> create(@PathVariable("id") long idPost, @Valid @RequestBody Streams item) throws StreamException{
        Streams savedItem = streamService.save(idPost, item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Streams> update(@PathVariable("id") long id, @Valid @RequestBody Streams item)throws StreamException {
        return new ResponseEntity<>(streamService.update(id, item), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id)throws StreamException {
        streamService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("{id}/uploadFile")
    public ResponseEntity<String> uploadPostImage(@PathVariable ("id") long id, @RequestParam("file") MultipartFile file) throws StreamException, IOException {
        streamService.uploadFileToStream(file, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}