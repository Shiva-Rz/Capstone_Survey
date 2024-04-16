import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CommentComponent } from '../comment/comment.component';
 
@Component({
  selector: 'comment-form',
  templateUrl: './commentForm.component.html',
  styleUrls: ['./commentForm.component.css'],
})
export class CommentFormComponent implements OnInit {
  @Input() submitLabel!: string;
  @Input() hasCancelButton: boolean = false;
  @Input() initialText: string = '';
 
  @Output()
  handleSubmit = new EventEmitter<string>();
 
  @Output()
  handleCancel = new EventEmitter<void>();
 
  form!: FormGroup;
 
  constructor(private fb: FormBuilder) {}
 
  title = new FormControl('', [Validators.required,Validators.maxLength(1000)]);
  
  ngOnInit(): void {
    this.form = this.fb.group({
      title: [this.initialText, [Validators.required,Validators.maxLength(1000)]],
    });
  }
 
  onSubmit(): void {
    this.handleSubmit.emit(this.form.value.title);
    this.form.reset();
  }
  refreshPage() {
    location.reload();
}
}