import { NgModule } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpresaModule } from './empresa/empresa.module';
import { FornecedorModule } from './fornecedor/fornecedor.module';
import { NumericoDirective } from './shared/directives/numerico.directive';

@NgModule({
  declarations: [
    AppComponent,
    NumericoDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatMenuModule,
    EmpresaModule,
    FornecedorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
