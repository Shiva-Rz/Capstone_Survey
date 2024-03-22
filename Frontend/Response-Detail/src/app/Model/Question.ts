import { Option } from "./Option";

export class Question{

    questionId !: number;
    questionNo !: number ;
    questions !: string;
    optionType !: string;
    pageId!:number;
    option !: Option[];
}


