import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostDraftComponent } from './postdraft.component';

describe('DraftComponent', () => {
  let component: PostDraftComponent;
  let fixture: ComponentFixture<PostDraftComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostDraftComponent]
    });
    fixture = TestBed.createComponent(PostDraftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
