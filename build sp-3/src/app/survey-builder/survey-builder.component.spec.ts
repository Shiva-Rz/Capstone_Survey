import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyBuilderComponent } from './survey-builder.component';

describe('SurveyBuilderComponent', () => {
  let component: SurveyBuilderComponent;
  let fixture: ComponentFixture<SurveyBuilderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveyBuilderComponent]
    });
    fixture = TestBed.createComponent(SurveyBuilderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
