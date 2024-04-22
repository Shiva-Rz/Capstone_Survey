import { User } from "src/app/Post-Model/User";
import { Content } from "src/app/Post-Model/content";

export interface PostCommentInterface {
  id: string;
  body: string;
  username: string;
  user: User;
  userId: string;
  parentId: null | string;
  createdAt: string;
  postId:number;
 
  post:Content;
  // contents:Content;
}
export class PostCommentInterface {
  id!: string;
  body!: string;
  username!: string;
  user!: User;
  userId!: string;
  parentId!: null | string;
  createdAt!: string;
  postId!:number;
  post!:Content;
 
}