import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsusarioComponent } from './ususario.component';

describe('UsusarioComponent', () => {
  let component: UsusarioComponent;
  let fixture: ComponentFixture<UsusarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UsusarioComponent]
    });
    fixture = TestBed.createComponent(UsusarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
