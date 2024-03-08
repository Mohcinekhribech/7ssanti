import { TestBed } from '@angular/core/testing';

import { HairSalonService } from './hair-salon.service';

describe('HairSalonService', () => {
  let service: HairSalonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HairSalonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
