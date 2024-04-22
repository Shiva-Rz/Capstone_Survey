

// import { Option } from "./Option";
// import { Options } from "./Options";
import { Option } from "./option";
import { Page } from "./page";

export class Question {
    questionId!: number;
    questionNo!: number;
    questions!: String;
    optionType !: string;
    option !: Option[];
    // pageId!:number;
    pages !: Page[];
    
}