import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OnInit } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import Pessoa from './iterface/pessoa';
import PessoaService from './service/pessoa-service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {

  private pessoas$: Observable<Pessoa[]> | undefined;

  private pessoaObserver: Observer<Pessoa[]> = {
    next: pessoas => console.log(pessoas),
    error: err => console.error(err),
    complete: () => console.log('Completed')
  }


  constructor(private pessoaService: PessoaService) { }
  title = 'teste-front';



  ngOnInit(): void {

    this.pessoas$ = this.pessoaService.getPessoa();

    this.pessoas$.subscribe(this.pessoaObserver);
  }
}
