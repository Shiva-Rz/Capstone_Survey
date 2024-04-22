import { User } from "src/app/Survey-Model/User";
import { Survey } from "src/app/Survey-Model/survey";

export interface SurveyCommentInterface {
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
export class SurveyCommentInterface {
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