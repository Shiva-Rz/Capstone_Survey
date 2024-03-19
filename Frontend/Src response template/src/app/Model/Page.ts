import { Question } from "./Question";

export class Page{

    pageId !: number;
    pageNo !: number ;
    pageTitle !: string;
    question !: Question[];
}