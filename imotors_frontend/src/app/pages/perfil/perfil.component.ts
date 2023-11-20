import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent {
  constructor(private router: Router) {

  }

  redirectToDetail(id: any){
    this.router.navigate(["post-detail", id]);
  }
}
