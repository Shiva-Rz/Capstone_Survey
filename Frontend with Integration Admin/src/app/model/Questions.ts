import { Options } from "./Options";

export class Questions{
    questionId!:number;
    questionNo!:number;
    questions!:string;
    optionType!:string;
    pageId!:number;
    option!:Options[];
}