import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommentModule } from '../model/comment/comment.module';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  public getComment(idPost:any) : Observable<CommentModule[]> {
    return this.http.get<CommentModule[]>(`http://localhost:8080/comment/${idPost}`);
  }

  public createComment(idPost: any, comment: CommentModule): Observable<CommentModule> {
    return this.http.post<CommentModule>(`http://localhost:8080/comment/${idPost}`, comment);
  }
}
