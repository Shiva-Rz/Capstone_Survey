import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SummaryPageComponent } from './summary-page.component';

describe('SummaryPageComponent', () => {
  let component: SummaryPageComponent;
  let fixture: ComponentFixture<SummaryPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SummaryPageComponent]
    });
    fixture = TestBed.createComponent(SummaryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
