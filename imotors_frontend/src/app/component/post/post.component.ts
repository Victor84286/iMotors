import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/model/post/post.module';
import { PostsService } from '../../services/posts.service';
import { Router } from '@angular/router';
import { Dialog } from '@angular/cdk/dialog';
import { CreateComponenteComponent } from '../create-componente/create-componente.component';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  posts: Post[] = [];

  constructor(private postsService: PostsService, private router: Router, private dialog: Dialog) {

  }

  ngOnInit(): void {
    this.postsService.getPost().subscribe(response => {
      this.posts = response as any;
    });
  }

  redirectToDetail(id: any){
    this.router.navigate(["post-detail", id]);
  }

  public criarComentario() {
    this.dialog.open(CreateComponenteComponent)
  }
}
