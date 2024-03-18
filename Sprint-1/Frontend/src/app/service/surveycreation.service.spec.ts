import { TestBed } from '@angular/core/testing';

import { SurveycreationService } from './surveycreation.service';

describe('SurveycreationService', () => {
  let service: SurveycreationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveycreationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
