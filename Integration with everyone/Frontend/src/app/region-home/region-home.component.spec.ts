import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegionHomeComponent } from './region-home.component';

describe('RegionHomeComponent', () => {
  let component: RegionHomeComponent;
  let fixture: ComponentFixture<RegionHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegionHomeComponent]
    });
    fixture = TestBed.createComponent(RegionHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
