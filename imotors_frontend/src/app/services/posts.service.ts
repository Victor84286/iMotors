import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from '../model/post/post.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PostsService {

  constructor(private httpClient: HttpClient) { }

  public getPost() : Observable<Post[]> {
    return this.httpClient.get<Post[]> ('https://imotors.azurewebsites.net/post')
  }

  public getPostById(id:any) : Observable<Post[]> {
    return this.httpClient.get<Post[]> ('https://imotors.azurewebsites.net/post/'+ id)
  }
}
