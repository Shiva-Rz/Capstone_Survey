import { TestBed } from '@angular/core/testing';

import { DepartmentserviceService } from './departmentservice.service';

describe('DepartmentserviceService', () => {
  let service: DepartmentserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DepartmentserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
