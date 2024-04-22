
import { User } from './User';
export class Project {
    projectId!: number;
    projectName!: string;
    startDate!: Date;
    endDate!: Date;
    department!: bigint;
    departmentName!:string;
    user!: User[];
}