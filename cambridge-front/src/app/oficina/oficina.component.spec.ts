import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OficinaComponent } from './oficina.component';

describe('OficinaComponent', () => {
  let component: OficinaComponent;
  let fixture: ComponentFixture<OficinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OficinaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OficinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
