import { Dialog } from '@angular/cdk/dialog';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreateComponenteComponent } from 'src/app/component/create-componente/create-componente.component';
import { PostsService } from 'src/app/services/posts.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  post: any;

  constructor(private postService: PostsService, private route: ActivatedRoute, private dialog: Dialog) {

  }

  ngOnInit(): void {
    let id = this.route.snapshot.params["id"];
    this.postService.getPostById(id).subscribe(Response => {
      this.post = Response;
      console.log(this.post);
    });
  }

  public abrirCriarComentario() {
    this.dialog.open(CreateComponenteComponent)
  }

  public criarComentario() {
    this.dialog.open(CreateComponenteComponent)
  }

}
