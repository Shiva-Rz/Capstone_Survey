import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewregionComponent } from './viewregion.component';

describe('ViewregionComponent', () => {
  let component: ViewregionComponent;
  let fixture: ComponentFixture<ViewregionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewregionComponent]
    });
    fixture = TestBed.createComponent(ViewregionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
