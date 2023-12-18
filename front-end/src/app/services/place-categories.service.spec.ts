import { TestBed } from '@angular/core/testing';

import { PlaceCategoriesService } from './place-categories.service';

describe('PlaceCategoriesService', () => {
  let service: PlaceCategoriesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlaceCategoriesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
