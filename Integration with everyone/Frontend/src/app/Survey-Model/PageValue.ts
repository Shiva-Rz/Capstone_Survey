import { OptionValue } from "./OptionValue";
import { QuestionValue } from "./QuestionValue";

export class PageValue {
    pageTitle!:string;
    surveyId!:number;
    pageNo!:number;
    question:QuestionValue[]=[];
   
}