
import { Region } from "./Region";
import { User } from "./User";
// import { User } from "./User";

export class Content {
  
  postId!: number;
  dateTime!: string;
  postContent!: string;
  region!: Region;
  department!: bigint;
  project!: bigint;
  nativeElement: any;
  status!: boolean;
  user!:User;

  // comments!: CommentInterface ;

}
