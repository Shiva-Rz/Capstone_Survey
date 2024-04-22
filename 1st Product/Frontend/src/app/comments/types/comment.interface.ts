import { User } from "src/app/model/User";
import { Poll } from "src/app/model/poll";

export interface CommentInterface {
  id: string;
  body: string;
  username: string;
  user: User;
  userId: string;
  parentId: null | string;
  createdAt: string;
  pollId:number;
  poll: Poll;
}
export class CommentInterface {
  id!: string;
  body!: string;
  username!: string;
  user!: User;
  userId!: string;
  parentId!: null | string;
  createdAt!: string;
  pollId!:number;
  poll!: Poll;
}