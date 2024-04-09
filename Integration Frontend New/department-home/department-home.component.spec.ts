import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartmentHomeComponent } from './department-home.component';

describe('DepartmentHomeComponent', () => {
  let component: DepartmentHomeComponent;
  let fixture: ComponentFixture<DepartmentHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DepartmentHomeComponent]
    });
    fixture = TestBed.createComponent(DepartmentHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
