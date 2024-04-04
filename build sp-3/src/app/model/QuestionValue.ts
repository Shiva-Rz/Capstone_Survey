import { OptionValue } from "./OptionValue";

export class QuestionValue {
    questions!: string;
    questionNo!: number;
    optionType!: string;
    option!: OptionValue[];
}