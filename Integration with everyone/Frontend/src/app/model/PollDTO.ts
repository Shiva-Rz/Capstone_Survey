import { Option } from "./Option";
import { Department } from "./Department";
import { Project } from "./Project";
import { Region } from "./Region";
import { User } from "./User";

export class PollDTO
{
 
    // this.reaction = reaction;
    // this.comments = comments;
 
   
 
    pollId!: number;
    pollQuestion!: string;
 
    options!: Option;
    optionId!: number;
   
    timeStamp!: Date;
 
    userid!:number;
    user!: User;
 
    region!: Region;
    project!: Project;
    department!: Department;
 
    endDate!: Date;
    status!: boolean;
}