import { User } from "../../model/User";
import { Survey } from "../../model/survey";

export interface CommentInterface {
  id: string;
  body: string;
  username: string;
  user: User;
  userId: string;
  parentId: null | string;
  createdAt: string;
  surveyId:number;
  survey: Survey;
}
export class CommentInterface {
  id!: string;
  body!: string;
  username!: string;
  user!: User;
  userId!: string;
  parentId!: null | string;
  createdAt!: string;
  surveyId!:number;
  survey!: Survey;
}