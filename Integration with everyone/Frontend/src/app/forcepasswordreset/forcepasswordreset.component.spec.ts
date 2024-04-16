import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForcepasswordresetComponent } from './forcepasswordreset.component';

describe('ForcepasswordresetComponent', () => {
  let component: ForcepasswordresetComponent;
  let fixture: ComponentFixture<ForcepasswordresetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ForcepasswordresetComponent]
    });
    fixture = TestBed.createComponent(ForcepasswordresetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
