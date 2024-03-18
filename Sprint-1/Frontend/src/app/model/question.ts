import { Option } from "./option";

export class Question {
    questionId!: number;
    questionNo!: number;
    questions!: String;
    optionType !: string;
    option !: Option[];
}