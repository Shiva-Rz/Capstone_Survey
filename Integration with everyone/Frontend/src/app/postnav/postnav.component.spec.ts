import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostnavComponent } from './postnav.component';

describe('PostnavComponent', () => {
  let component: PostnavComponent;
  let fixture: ComponentFixture<PostnavComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostnavComponent]
    });
    fixture = TestBed.createComponent(PostnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
