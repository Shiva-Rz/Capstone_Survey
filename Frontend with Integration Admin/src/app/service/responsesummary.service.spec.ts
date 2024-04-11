import { TestBed } from '@angular/core/testing';

import { ResponsesummaryService } from './responsesummary.service';

describe('ResponsesummaryService', () => {
  let service: ResponsesummaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponsesummaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
