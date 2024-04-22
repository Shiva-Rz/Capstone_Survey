import { Component, Input } from "@angular/core";
import { CommentsService } from "src/app/comments/services/comments.service";
import { CommentInterface } from "src/app/comments/types/comment.interface";
import { ActiveCommentInterface } from "src/app/comments/types/activeComment.interface";
import { OptionResponse } from "../model/OptionResponse";
import { OptionResponseNew } from "../model/OptionResponseNew";
import { Reaction } from "../model/Reaction";
import { User } from "../model/User";
import { Poll } from "../model/poll";
import { Option } from "../model/Option";
import { PollService } from "../Admin-Service/poll.service";
import { ReactionService } from "../Admin-Service/reaction.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-view",
  templateUrl: "./view.component.html",
  styleUrls: ["./view.component.css"],
})
export class ViewComponent {
 
    @Input() currentUserId!: string;
    @Input() pollArray: Poll[] = [];
    @Input() Allpoll!: Poll;
    @Input() pollId!: number;
   
    Id!: OptionResponse;
   
   
   
    result: string = "";
   
    results: string = "";
   
    optionResponse: any;
   
    lists: any;
   
    selected!: number;
   
    votingEnded = false;
   
    count!: number;
   
    polls: Poll[] = [];
   
    option: Option[] = [];
   
    users: User[] = [];
   
    date: Date | undefined;
   
    reaction: Reaction[] = [];
   
    Option!: Option;
   
    OptionResponse: any;
   
    OptionResponseNew: any;
   
    optionId: any;
   
    User: any;
   
    Poll: any;
   
    optCount: number = 0;
   
    reactionData!: Reaction;
   
    Reaction: any;
   
    reactCount: number = 0;
   
    responseCount: number = 0;
   
    count1: number = 0;
   
    optionCount: any;
   
    optionData: any;
   
    userId: string = '';
   
   
   addCommentById({text,parentId,pollId,userId}:{text:any,parentId:any|null,pollId: any,userId: any}): void{
    this.commentsService.createComment(text,parentId,pollId,userId).subscribe()
   }
    comments: CommentInterface[] = [];
    comment!: CommentInterface;
    activeComment: ActiveCommentInterface | null = null;
   
    poll!: Poll;
   
    isHide: boolean[] = Array(this.polls.length).fill(true);
   
    getRootComments(pollId: number): CommentInterface[] {
      return this.comments.filter(
        (comment) => comment.parentId == "0" && comment.poll.pollId === pollId
      );
      //return this.comments;
    }
   
    updateComment({
      text,
      commentId,
    }: {
      text: string;
      commentId: string;
    }): void {
      this.commentsService
        .updateComment(commentId, text)
        .subscribe((updatedComment) => {
          this.comments = this.comments.map((comment) => {
            if (comment.id === commentId) {
              return updatedComment;
            }
            return comment;
          });
          this.activeComment = null;
        });
    }
   
    deleteComment(commentId: string): void {
      this.commentsService.deleteComment(commentId).subscribe(() => {
        this.comments = this.comments.filter(
          (comment) => comment.id !== commentId
        );
      });
    }
   
    getCommentsCount(pollId: number): number {
      return this.comments.filter((comment) => comment.poll.pollId === pollId)
        .length;
    }
   
    setActiveComment(activeComment: ActiveCommentInterface | null): void {
      this.activeComment = activeComment;
    }
   
    ac: CommentInterface = new CommentInterface();
   
    addComment({
      text,
      parentId,
      userId,
      pollId: number,
    }: {
      text: string;
      parentId: string | null;
      userId: any;
      pollId: number;
    }): void {
      //this.ac.pollId = this.ac.pollId;
      this.commentsService
        .createComment(text, parentId, this.pollId, userId)
        .subscribe((createdComment) => {
         
          // createdComment.pollId=this.poll.pollId;
          this.comments = [...this.comments, createdComment];
          this.activeComment = null;
        });
      console.log(this.comments);
    }
   
    getReplies(commentId: string): CommentInterface[] {
      return (
        this.comments
          .filter((comment) => comment.parentId === commentId)
          //.filter((comment) => comment.parentId != "0")
          .sort(
            (a, b) =>
              new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
          )
      );
    }
    TotalnumberofLikes: { [pollId: number]: number } = {};
    TotalnumberofDisLikes: number = 25;
    flag: number = 0;
    dislikeS: string = "dislike-button";
    likeS: string = "like-button";
   
    TotalnumberofVotes: number = 0;
    TotalnumberofNotVoted: number = 25;
    flags: number = 0;
    NotVoted: string = "Vote-button";
    Voted: string = "Voted-button";
   
    reactionFlag: number = 0;
    voteCounts: { [key: number]: number } = {};
   
    isShow = true;
   
    isLike = false;
   
    value: number = 0;
   
    isOptionIdHide = true;
   
    isView = true;
   
    isViewHide = false;
   
    orn: OptionResponseNew = new OptionResponseNew();
   
    votes: { [key: string]: number } = {};
   
    totalVotes: any;
   
    rn: Reaction = new Reaction();
   
    userValue:number=0;
   
    view:boolean = false;
   
    isVisible = true;
   
    ngOnInit() {
   
      this.userId =  sessionStorage.getItem("userId") || "";
      this.userValue = parseInt(this.userId);
   
      this.pollService.getAllPolls().subscribe((AllPoll) => {
        this.polls = AllPoll;
        console.log(this.polls);
      });
   
      this.count = 0;
   
      this.commentsService.getComments().subscribe((comments) => {
        this.comments = comments;
        console.log(comments);
      });
    }
   
    Show = true;
   
    toggleDisplayView()
    {
      this.Show = !this.Show;
      this.Hide = !this.Hide;
    }
    Hide = true;
   
   
    constructor(
      private pollService: PollService,
      private reactionService: ReactionService,
      private commentsService: CommentsService,
      private _activatedRoute: ActivatedRoute
    ) {
      setInterval(() => {
        this.date = new Date();
      }, 1000);
      this.Id = new OptionResponse();
      this.OptionResponse = new OptionResponse();
      this.optionData = new Option();
      this.optionId = new OptionResponse();
      this.reactionData = new Reaction();
      this.Option = new Option();
      this.Reaction;
      this.changeStatus();
     
    }
    refreshPage() {
      location.reload();
  }
  callView() {
    this.isVisible = false;
    this.view = true;
  }
   
    toggleView() {
      this.isView = !this.isView;
      this.isViewHide = !this.isViewHide;
    }
    toggleDisplay() {
      this.isShow = !this.isShow;
      this.isLike = !this.isLike;
    }
   
   
    getPoll(id: any) {
      this.value = id;
      this.pollService.get(id).subscribe((AllPoll) => {
        this.polls = AllPoll;
        console.log(this.polls);
        this.pollService.getOption().subscribe((save) => {
          this.option = save;
          console.log(this.option);
        });
      });
      this.reactionService.getAllReactionCount(id).subscribe((ReactionCount) => {
        this.reactCount = ReactionCount;
        console.log(this.reactCount);
      });
      this.commentsService.getComments().subscribe((comments) => {
        this.comments = comments;
        console.log(this.comment);
      });
    }
   
   
    isHideComment = true;
   
    toggleDisplayComment(pollId: number) {
      this.isHide[pollId] = !this.isHide[pollId];
      this.isHideComment = !this.isHideComment;
    }
    receiveComment($event: any) {
      this.comments = $event;
      this.count = this.comments.length;
      console.log(this.comments.length);
    }
   
    recieveCount($event: any) {
      this.comments = $event;
      this.count = this.comments.length;
    }
   
    reactionInsert(pollId: number) {
      console.log(pollId);
      this.rn.pollId = pollId;
      this.rn.userid = this.userValue;
      if (this.TotalnumberofLikes[pollId]) {
        delete this.TotalnumberofLikes[pollId];
        this.results = this.reactionService.reactionDelete(pollId);
      } else {
        this.TotalnumberofLikes[pollId] = 1;
        this.results = this.reactionService.reactionInsert(this.rn);
      }
   
      console.log(this.results);
      if (this.TotalnumberofLikes[pollId]) {
        this.TotalnumberofLikes[pollId] = this.reactCount + 1;
      } else {
        this.TotalnumberofLikes[pollId]--;
      }
    }
   
    TotalNumberofVotes!: number;
   
    changeOption() {}
   
    voted: boolean = false;
    vote(pollId: any, optionId: any, userValue:any) {
   
      // this.userValue = parseInt(this.userId)
      console.log(userValue)
      if (!this.voted) {
        console.log("Voted for option:", optionId);
        console.log(this.userValue)
        this.pollService.vote(pollId, optionId,userValue).subscribe(() => {
          console.log(userValue)
          if (pollId) {
            console.log(pollId);
            this.updateVoteCounts();
          }
        });
        this.voted = true;
      } else {
       this.pollService.updateVote(optionId, userValue).subscribe(()=>{
        this.updateVoteCounts();
       })
      }
    }
   
    updateVoteCounts() {
      this.pollService.getVoteCounts(this.value).subscribe((data) => {
        this.voteCounts = data;
        console.log(this.voteCounts);
      });
    }
   
    getPercentage(optionId: number): number {
      const totalVotes = this.getTotalVotes();
      return totalVotes === 0
        ? 0
        : Math.round((this.voteCounts[optionId] / totalVotes) * 100);
    }
   
    getTotalVotes(): number {
      return Object.values(this.voteCounts).reduce(
        (total, count) => total + count,
        0
      );
    }
   
   
    changeStatus(){
      this.pollService.changeStatus().subscribe();
     }
    }