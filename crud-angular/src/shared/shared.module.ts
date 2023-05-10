import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ErrorDialogComponent } from '../shared/components/error-dialog/error-dialog.component';
import { AppMaterialModule } from '../shared/models/app-material/app-material.module';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';

@NgModule({
  declarations: [
    ErrorDialogComponent,
    ConfirmationDialogComponent
  ],
  imports: [
     CommonModule,
     AppMaterialModule
  ],
  exports: [
    ErrorDialogComponent,
    ConfirmationDialogComponent
  ],
})
export class SharedModule { }
