import { OptionValue } from "./OptionValue";

export class QuestionValue {
    questions!:string;
    optionType!:string;
    option!:OptionValue[];
    questionNo!:number;
    pageNo!:number;
}