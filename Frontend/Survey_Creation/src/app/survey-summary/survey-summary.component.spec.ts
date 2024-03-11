import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveySummaryComponent } from './survey-summary.component';

describe('SurveySummaryComponent', () => {
  let component: SurveySummaryComponent;
  let fixture: ComponentFixture<SurveySummaryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SurveySummaryComponent]
    });
    fixture = TestBed.createComponent(SurveySummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
