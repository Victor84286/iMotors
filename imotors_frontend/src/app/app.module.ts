import { NgModule, Inject } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsusarioComponent } from './pages/ususario/ususario.component';
import { PostComponent } from './component/post/post.component';
import { CommentComponent } from './component/comment/comment.component';
import { HomeComponent } from './pages/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PostDetailComponent } from './pages/post-detail/post-detail.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { ComentariosComponent } from './pages/comentarios/comentarios.component';
import { CreateComponenteComponent } from './component/create-componente/create-componente.component';
import {MatDialogModule} from '@angular/material/dialog';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { ExplorarComponent } from './pages/explorar/explorar.component';
import { PesquisarComponent } from './pages/pesquisar/pesquisar.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { LoginComponent } from './pages/login/login.component';
import { CriarUsuarioComponent } from './pages/criar-usuario/criar-usuario.component';
import { ListaComponent } from './pages/lista/lista.component';
import { MensagensComponent } from './pages/mensagens/mensagens.component';

@NgModule({
  declarations: [
    AppComponent,
    UsusarioComponent,
    PostComponent,
    CommentComponent,
    HomeComponent,
    PostDetailComponent,
    ComentariosComponent,
    CreateComponenteComponent,
    ExplorarComponent,
    PesquisarComponent,
    PerfilComponent,
    LoginComponent,
    CriarUsuarioComponent,
    ListaComponent,
    MensagensComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
