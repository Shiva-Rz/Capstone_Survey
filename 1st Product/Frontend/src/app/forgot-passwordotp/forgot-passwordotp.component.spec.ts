import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotPasswordotpComponent } from './forgot-passwordotp.component';

describe('ForgotPasswordotpComponent', () => {
  let component: ForgotPasswordotpComponent;
  let fixture: ComponentFixture<ForgotPasswordotpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ForgotPasswordotpComponent]
    });
    fixture = TestBed.createComponent(ForgotPasswordotpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
