import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectHomeComponent } from './project-home.component';

describe('ProjectHomeComponent', () => {
  let component: ProjectHomeComponent;
  let fixture: ComponentFixture<ProjectHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProjectHomeComponent]
    });
    fixture = TestBed.createComponent(ProjectHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
