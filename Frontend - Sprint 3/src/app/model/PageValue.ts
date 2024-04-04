import { OptionValue } from "./OptionValue";
import { QuestionValue } from "./QuestionValue";

export class PageValue {
    pageTitle!:string;
    surveyId!:number;
    question:QuestionValue[]=[];
   
}