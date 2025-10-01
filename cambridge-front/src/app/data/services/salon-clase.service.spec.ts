import { TestBed } from '@angular/core/testing';

import { SalonClaseService } from './salon-clase.service';

describe('SalonClaseService', () => {
  let service: SalonClaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalonClaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
