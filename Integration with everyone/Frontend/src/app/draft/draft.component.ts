
import { Component } from '@angular/core';
 
import { Option } from 'src/app/model/Option';
import { PollDTO } from '../model/PollDTO';
import { User } from '../model/User';
import { Poll } from '../model/poll';
import { PollService } from '../Admin-Service/poll.service';

 
 
@Component({
  selector: 'app-draft',
  templateUrl: './draft.component.html',
  styleUrls: ['./draft.component.css'],
})
export class DraftComponent {
 
  Poll: any;
 
  polls: Poll[] = [];
 
  optionData: any;
 
  User: any;
 
  users: User[] = [];
 
  optionId: any;
 
  Option: Option;
 
  option: Option[] = [];
 
  OptionList: Option[] = [];
 
  date: Date | undefined;
 
  pollData: PollDTO;
 
  ngOnInit() {
    this.pollService.getDraft().subscribe((AllPoll) => {
      this.polls = AllPoll;
    });
 
  }
 
  constructor(
    private pollService: PollService,
  ) {
 
    this.Option = new Option();
 
    this.optionData = new Option();
 
    this.pollData = new PollDTO();
  }
 
  getdraft() {
    this.pollService.getDraft().subscribe(() => {
      this.pollService.getOption().subscribe((save) => {
        this.option = save;
        console.log(this.option);
      });
    });
  }
 
  deleteDraft(pollId: number) {
    this.pollService.deleteDraft(pollId);
  }
 
  getDraftById(pollId: number) {
    console.log("PollId" + pollId)
    this.pollService.getDraftById(pollId).subscribe(
      value => {
        this.pollData = value;
      });
    this.pollService.getDraftOptionsById(pollId).subscribe(
      value => {
        this.OptionList = value;
      });
    console.log(this.OptionList);
    console.log(this.pollData)
  }
  pl: PollDTO = new PollDTO();
  result:any;
 
  sharePoll(data:any)
  {
    this.pl.pollId=data.pollId;
    this.pl.status = true;
    this.result = this.pollService.updateDraft(this.pl).subscribe();
 
    alert("poll shared successfully" );
   
  }
 
 
}