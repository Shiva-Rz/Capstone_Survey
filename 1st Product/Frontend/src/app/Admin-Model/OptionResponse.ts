import { Option } from "./Option";
import { User } from "./User";

export class OptionResponse {
    pollId!: number; 
    optionId!: Option;
    optionResponseId!: number;
    optionResponse!: number;
    user!: User;

    /*constructor(optionResponseId?: number, optionResponse?: number, optionId?: Option) {
        this.optionResponseId = optionResponseId || 0;
        this.optionResponse = optionResponse || 0;
        this.optionId = optionId || new Option();
      }*/
}