import { Department } from "./department";
// import { Deserializable } from "./deserializable";
import { Project } from "./project";
import { Region } from "./region";

// implements Deserializable

export class Survey  {
    surveyId!:bigint;
    surveyName!: string;
    endDate!: Date;
    region!: bigint;
    // regionName!: string;
    // regionId!: bigint;
    department!: bigint;
    // departmentName!: string;
    // departmentId!: bigint;
    project!: bigint;
    // projectName!: string;
    // projectId!: bigint;

    // deserialize(input: any) {
    //     Object.assign(this, input);
    //     return this;
    //   }

    // deserialize(input: any): Survey {
    //     Object.assign(this, input);
    //     this.region = new Region().deserialize(input.region);
    //     return this;
    //   }
}