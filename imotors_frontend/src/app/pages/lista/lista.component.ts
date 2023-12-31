import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent {
  constructor(private router: Router) {

  }

  redirectToDetail(id: any){
    this.router.navigate(["post-detail", id]);
  }
}
