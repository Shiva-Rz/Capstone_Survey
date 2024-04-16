import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostregionComponent } from './postregion.component';

describe('PostregionComponent', () => {
  let component: PostregionComponent;
  let fixture: ComponentFixture<PostregionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostregionComponent]
    });
    fixture = TestBed.createComponent(PostregionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
