import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
 
@Component({
  selector: 'PostComment-form',
  templateUrl: './PostCommentForm.component.html',
})
export class PostCommentFormComment implements OnInit {
  @Input() submitLabel!: string;
  @Input() hasCancelButton: boolean = false;
  @Input() initialText: string = '';
 
  @Output()
  handleSubmit = new EventEmitter<string>();
 
  @Output()
  handleCancel = new EventEmitter<void>();
 
  form!: FormGroup;
 
  constructor(private fb: FormBuilder) {}
 
  ngOnInit(): void {
    this.form = this.fb.group({
      title: [this.initialText, Validators.required],
    });
  }
 
  onSubmit(): void {
    this.handleSubmit.emit(this.form.value.title);
    this.form.reset();
  }
}