import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import Pessoa from '../iterface/pessoa';



@Injectable({ providedIn: 'root' })
export default class PessoaService {

    private readonly url = "http://localhost:8080/ola";

    public constructor(private http: HttpClient) { };


    public getPessoa(): Observable<Pessoa[]> {
        return this.http.get<Pessoa[]>(this.url);
    }

    public criarPessoa(pessoa: Pessoa): Observable<Pessoa> {

        return this.http.post<Pessoa>(this.url, pessoa);

    }

    public atualizarPessoa(pessoa: Pessoa):Observable<Pessoa>{
        return this.http.put<Pessoa>(this.url, pessoa);
    }

    public deletarPessoa(pessoa: Pessoa):Observable<Pessoa>{
        return this.http.delete<Pessoa>(this.url, { body: pessoa });
    }

}