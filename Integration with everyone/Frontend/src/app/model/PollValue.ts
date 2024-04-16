import { Option } from "./Option";
import { Department } from "./Department";
import { Project } from "./Project";
import { Region } from "./Region";
 
 
export class PollValue {
    pollId!: number;
    endDate!: Date;
    status!: boolean;
    pollQuestion!: string;
    timeStamp!: Date;
    region!: string;
    options!: Option;
    optionId!: number;
    user!: string;
    userId!:string;
    regionId!:string;
    departmentId!:string;
    projectId!:string;
    project!: string;
    department!: string;
    voted?: boolean;
    constructor() {
        this.voted = false;
      }
}