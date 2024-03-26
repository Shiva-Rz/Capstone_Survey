import { TestBed } from '@angular/core/testing';

import { ResponseSummaryService } from './response-summary.service';

describe('ResponseSummaryService', () => {
  let service: ResponseSummaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponseSummaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
