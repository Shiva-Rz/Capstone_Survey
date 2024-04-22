import { Question } from "./question";

export class Page{
    pageId !: number;
    pageNo !: number ;
    pageTitle !: string;
    question !: Question[];
    
}