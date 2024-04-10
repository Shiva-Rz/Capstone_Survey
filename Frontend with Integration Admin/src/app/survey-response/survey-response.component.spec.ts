import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyResponseComponent } from './survey-response.component';

describe('SurveyResponseComponent', () => {
  let component: SurveyResponseComponent;
  let fixture: ComponentFixture<SurveyResponseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveyResponseComponent]
    });
    fixture = TestBed.createComponent(SurveyResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
