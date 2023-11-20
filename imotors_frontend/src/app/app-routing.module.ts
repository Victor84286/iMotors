import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PostComponent } from './component/post/post.component';
import { CommentComponent } from './component/comment/comment.component';
import { PostDetailComponent } from './pages/post-detail/post-detail.component';
import { ExplorarComponent } from './pages/explorar/explorar.component';
import { ListaComponent } from './pages/lista/lista.component';
import { MensagensComponent } from './pages/mensagens/mensagens.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { PesquisarComponent } from './pages/pesquisar/pesquisar.component';

const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: "home", component: HomeComponent},
  { path: "perfil", component: PerfilComponent},
  { path: "post", component: PostComponent},
  { path: "post-detail/:id", component: PostDetailComponent },
  { path: "comment", component: CommentComponent },
  { path: "explorar", component: ExplorarComponent },
  { path: "lista", component: ListaComponent },
  { path: "pesquisa", component: PesquisarComponent },
  { path: "mensagem", component: MensagensComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
