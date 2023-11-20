import { Component, EventEmitter, Input, Optional, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CommentService } from 'src/app/services/comment.service';
import { CommentModule } from 'src/app/model/comment/comment.module';

@Component({
  selector: 'app-create-componente',
  templateUrl: './create-componente.component.html',
  styleUrls: ['./create-componente.component.css'],
  providers: []
})

export class CreateComponenteComponent {
  comentario = new FormControl('', [Validators.required]);
  autor = new FormControl('', [Validators.required]);
  @Output() newCommentEvent = new EventEmitter();
  @Input() idPost:any = '';

  constructor (private commentService: CommentService, private snackBar: MatSnackBar  ) {}

  public criarNovoComentario() {
    if (this.comentario.hasError("required")) {
      return;
    }

    if (this.autor.hasError("required")) {
      return;
    }

    let comment: CommentModule = {
      author: this.autor.value as string,
      text: this.comentario.value as string
    };

    this.commentService.createComment(this.idPost, comment).subscribe(response => {
      this.snackBar.open("Comentário criado com sucesso", "Ok");
      this.newCommentEvent.emit();
    });
  }

}
