import { CommentModule } from "../comment/comment.module";
import { StreamModule } from "../stream/stream.module";
import { UsuarioModule } from "../usuario/usuario.module";

export interface Post {
  id?:number;
  article?:string;
  dtPublish?:Date;
  title?:string;
  urlImage?:string;
  comments:Array<CommentModule>;
  usuario?:UsuarioModule;
  streamsDisponiveis:Array<StreamModule>;
}