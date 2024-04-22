import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrafteditComponent } from './draftedit.component';

describe('DrafteditComponent', () => {
  let component: DrafteditComponent;
  let fixture: ComponentFixture<DrafteditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DrafteditComponent]
    });
    fixture = TestBed.createComponent(DrafteditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
