import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestbodyComponent } from './testbody.component';

describe('TestbodyComponent', () => {
  let component: TestbodyComponent;
  let fixture: ComponentFixture<TestbodyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestbodyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestbodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
