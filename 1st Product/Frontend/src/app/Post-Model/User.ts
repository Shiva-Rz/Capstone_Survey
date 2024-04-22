
import { Department } from "./Department";
import { Project } from "./Project";
export class User {
    userId!: number;
    userFirstName!: string;
    userLastName!: string;
    userEmailId!: string;
    userPassword!: string;
    userType!: string;
    userMobileNumber!: number;
    department!: bigint;
    departmentName!:string;
    region!: bigint;
    regionName!:string;
    project!: Project[];
}